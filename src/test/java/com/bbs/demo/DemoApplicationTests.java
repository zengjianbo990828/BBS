package com.bbs.demo;

import com.bbs.demo.dao.imp.CommentDaoImpl;
import com.bbs.demo.entity.ArticleRanking;
import com.bbs.demo.entity.Comment;
import com.bbs.demo.entity.ConComment;
import com.bbs.demo.service.IArticleRankingService;
import com.bbs.demo.service.ICommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private IArticleRankingService articleRankingService;

    @Resource
    private ICommentService iCommentService;

    @Test
    public void test() {

        List<Comment> comments = iCommentService.findCommentList(new Comment());
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    @Test
    void insertComment(){

        Comment comment=new Comment();
        comment.setUserId(1);
        comment.setPostId(1);
        comment.setUserName("张三a");
        comment.setPhoto("255e2f6cbf2cd0ea6d66ba1c5e991f8f.jpg");
        comment.setCreateDate(new Date());
        comment.setStar(1);
        comment.setContent("好");
        comment.setCommentId("1");


        List<Comment> list=new ArrayList<>();
//        list.add(comment);
//        list.add(comment);

        Comment comment1=new Comment();
        comment1.setCommentId("1");
        comment1.setUserId(1);
        comment1.setPostId(1);
        comment1.setUserName("张d三");
        comment1.setPhoto("give.png");
        comment1.setCreateDate(new Date());
        comment1.setStar(1);
        comment1.setContent("好");
        comment1.setCommentObjects(list);

        iCommentService.insertComment(comment1,1);
        this.test();
    }
    @Test
    void contextLoads() {
        Comment comment=new Comment();
        comment.setCommentId("5f65603967b4f13d3db65fcf");
        iCommentService.deleteComment(comment);

    }

}
