package com.bbs.demo.service.impl;

import com.bbs.demo.dao.ICommentDao;
import com.bbs.demo.entity.Comment;
import com.bbs.demo.entity.CommentRanking;
import com.bbs.demo.service.ICommentRankingService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentRankingServiceImpl implements ICommentRankingService {

    @Resource
    private ICommentDao iCommentDao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;//redis操作字符串

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;//redis操作对象

    @Resource
    private JavaMailSenderImpl javaMailSender;//设置邮件

    /**
     * 从mongodb中查询前十的评论
     *
     * @param id
     * @param limit
     * @return
     */
    @Override
    public List<CommentRanking> mongodbCommentRankingList(Integer id, Integer limit) {

        return null;
    }

    /**
     * 查询排名前十的评论条数
     *
     * @return
     */
    @Override
    public List<Comment> commentRanking() {
        return iCommentDao.commentRanking();
    }



    /**
     * 添加前十评论最高
     *
     * @return
     */
    @Override
    @CachePut(value = "commentRanking")
//    @Scheduled(cron = "0 * * * * ?")
    public List<Comment> insertArticle() {
        List<Comment> commentList = this.commentRanking();

        for (Comment comment : commentList) {

        }
        List<Comment> commentList2=new ArrayList<Comment>();
        return commentList2;
    }
}
