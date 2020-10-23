package com.bbs.demo.service.impl;

import com.bbs.demo.dao.ICommentDao;
import com.bbs.demo.entity.Comment;
import com.bbs.demo.service.ICommentService;
import com.bbs.demo.utils.constant.MessageConstant;
import com.bbs.demo.utils.exception.CommentException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Resource
    private ICommentDao iCommentDao;

    /**
     * 查询评论
     *
     * @return
     */
    @Override
    public List<Comment> findCommentList(Comment comment) {

        List<Comment> commentList = null;
        try {
            commentList = iCommentDao.findCommentList(comment);
        } catch (RuntimeException e) {
            throw new CommentException(MessageConstant.MESSAGE_LOADING_FAILED);
        }
        return commentList;
    }

    /**
     * 添加评论
     *
     * @param comment
     */
    @Override
    public Comment insertComment(Comment comment, Integer articleUserId) {
        comment.setCreateDate(new Date());
        String message = "";
        Comment comment1 = new Comment();
        try {
            //判断是否是文章主人s
            if (articleUserId == comment.getUserId()) {
                comment.setFlag(true);
            }

            message = MessageConstant.CHARACTER_RETRIEVAL(comment.getContent());
            if (message != "") {
                comment1.setCommentId("-1");
                comment1.setContent(message);
            } else {
                comment1 = iCommentDao.insertComment(comment);
            }

        } catch (RuntimeException e) {
            comment1.setCommentId("-1");
            comment1.setContent(MessageConstant.MESSAGE_SAVE_FAILED);
        } finally {
            return comment1;
        }

    }

    /**
     * 添加子评论
     *
     * @param comment
     */
    @Override
    public Comment insertConComment(Comment comment, Integer articleUserId) {
        comment.setCreateDate(new Date());
        comment.setCommentCon(1);
        String message = "";
        Comment comment1 = new Comment();
        try {
            if (articleUserId == comment.getUserId()) {
                comment.setFlag(true);
            }
            //提取内容
            int content = comment.getContent().indexOf(":");
            if (content != -1) {
                message = MessageConstant.CHARACTER_RETRIEVAL(comment.getContent());
                if (message != "") {
                    comment1.setCommentId("-1");
                    comment1.setContent(message);
                } else {
                    String substring = comment.getContent().substring(content + 1);
                    comment.setContent(substring);

                }

            }
            iCommentDao.insertConComment(comment);
            message = "评论成功！";
        } catch (Exception e) {

            comment1.setCommentId("-1");
            comment1.setContent(MessageConstant.MESSAGE_SAVE_FAILED);
        } finally {
            return comment1;
        }


    }

    /**
     * 删除评论
     *
     * @param comment
     * @return
     */
    @Override
    public String deleteComment(Comment comment) {

        String message = "";

        try {
            if (comment.getId() == null || comment.getId() == "") {
                message = MessageConstant.MESSAGE_DELETE;
            } else {
                iCommentDao.deleteComment(comment);
                message="删除成功！";
            }
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            return message;
        }

    }

    /**
     * 点赞
     *
     * @param comment
     */
    @Override
    public String star(Comment comment) {
        String message = "";

        try {
            iCommentDao.star(comment);
            message = "1";
        } catch (Exception e) {
            message = MessageConstant.MESSAGE_STAR;
        } finally {
            return message;
        }
    }
}
