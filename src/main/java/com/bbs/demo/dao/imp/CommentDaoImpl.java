package com.bbs.demo.dao.imp;

import com.bbs.demo.dao.ICommentDao;
import com.bbs.demo.entity.Comment;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import org.json.JSONObject;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class CommentDaoImpl implements ICommentDao {

    @Resource
    private MongoTemplate mongoTemplate;
//    db.comment.insert({commentId:"1",postId:"1",userName:"张三",photo:"sd.img",createDate:new ISODate(),star:"30",content:"不错",commentObjects:[{commentId:"1",postId:"1",userName:"张三",photo:"sd.img",createDate:new ISODate(),star:"30",content:"不错",commentObjects:[{}]}]})

    /**
     * 查询评论
     *
     * @return
     */
    @Override
    public List<Comment> findCommentList(Comment comment) {
        comment.setPostId(1);

        List<Comment> commentList=null;
        if (comment.getPostId()!=0){
            Query query=new Query(Criteria.where("postId").is(comment.getPostId()));
            commentList = mongoTemplate.find(query,Comment.class);
        }

        return commentList;
    }

    /**
     * 添加评论
     *
     * @param comment
     */
    @Override
    public Comment insertComment(Comment comment) {
        comment.setCommentObjects(new ArrayList<>());
        mongoTemplate.insert(comment);
        return comment;
    }


        /**
         * 删除评论
         */
    @Override
    public void deleteComment(Comment comment) {

        //判断是否是子评论
        if (comment.getCommentCon() == 0) {
            Query query = new Query(Criteria.where("_id").is(comment.getId()));
            mongoTemplate.remove(query, Comment.class);
        } else {
            this.deleteConComment(comment);
        }
    }

    /**
     * 删除子评论
     */
    public void deleteConComment(Comment comment) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(comment.getId()));
        //删除
        Update update = new Update();
        update.pull("commentObjects", new BasicDBObject("commentId", comment.getCommentId()));
        mongoTemplate.updateFirst(query, update, Comment.class);
    }

    /**
     * 添加子评论
     *
     * @param comment
     */
    @Override
    public Comment insertConComment(Comment comment) {
        if (comment != null) {
            comment.setCommentCon(1);
            comment.setStar(0);
            String id = comment.getId();
            Query query = new Query(Criteria.where("_id").is(id));
            //设置评论id
            comment.setCommentId(String.valueOf(Integer.parseInt(this.commentId(comment)) + 1));
            //添加
            Update update = new Update();
            update.push("commentObjects", comment);
            mongoTemplate.updateFirst(query, update, Comment.class);
            //修改评论总数
            Update update1=new Update();
            update1.inc("commentSize",1);
            mongoTemplate.updateFirst(query,update1,Comment.class);
        }
        return comment;
    }

    /**
     * 查找最后最后一条评论id
     */
    public String commentId(Comment comment) {

        Query query = new Query();
        if (comment.getId() != "" && comment.getId() != null) {
            query.addCriteria(Criteria.where("_id").is(comment.getId()));
        }
        List<Comment> list = mongoTemplate.find(query, Comment.class);
        Comment comment1 = list.get(0);
        if (comment1.getCommentObjects().size()==0){
            return "1";
        }else {
            return comment1.getCommentObjects().get(comment1.getCommentObjects().size() - 1).getCommentId();
        }
    }

    /**
     * 查询排名前十的评论总数
     * @return
     */
    @Override
    public List<Comment> commentRanking() {
        /*List<Comment> list = this.commentList();
        for (Comment comment : list) {

        }*/

        Aggregation aggregation = Aggregation.newAggregation(

                //分组
                Aggregation.group("postId").sum("commentSize").as("commentSize"),
                //倒序
                Aggregation.sort(Sort.Direction.DESC, "commentSize"),
                Aggregation.limit(10)
        );

        AggregationResults<Comment> collectionName = mongoTemplate.aggregate(aggregation, "comment", Comment.class);
        List<Comment> commentList = collectionName.getMappedResults();
        return commentList;
    }

    /**
     * 点赞
     * @param comment
     */
    @Override
    public void star(Comment comment){
        Query query=new Query();

        Criteria criteria=Criteria.where("_id").is(comment.getId());
        if (comment.getCommentCon()==1){
            query.addCriteria(criteria.and("commentObjects.commentId").is(comment.getCommentId()));

        }else{
            query.addCriteria(criteria);
        }

        Update update=new Update();
        if (comment.getCommentCon()==0){

            if (comment.isWhetherStar()==false) {
                update.inc("star", 1);
                update.set("whetherStar",true);
            }else {
                update.inc("star", -1);
                update.set("whetherStar",false);

            }
        }else {
            if (comment.isWhetherStar()==false) {
                update.inc("commentObjects.$.star", 1);
                update.set("commentObjects.$.whetherStar",true);
            }else {
                update.inc("commentObjects.$.star", -1);
                update.set("commentObjects.$.whetherStar",false);
            }
        }

        mongoTemplate.updateFirst(query,update,Comment.class);
    }
}
