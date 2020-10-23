package com.bbs.demo.service.impl;

import com.bbs.demo.dao.IArticleRankingDao;
import com.bbs.demo.entity.ArticleRanking;
import com.bbs.demo.service.IArticleRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ArticleRankingServiceImpl implements IArticleRankingService {

    @Resource
    private IArticleRankingDao articleRankingDao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;//redis操作字符串

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;//redis操作对象

    @Resource
    private JavaMailSenderImpl javaMailSender;//设置邮件

    /**
     * 查询所有点赞数最高的文章
     *
     * @return
     */
    @Override
    public List<ArticleRanking> findArticleAll(Integer id,Integer limit) {

        List<ArticleRanking> list=new ArrayList<>();
        Set<Object> articleRanking3 = redisTemplate.opsForZSet().reverseRange("articleRanking", 0, 9);
        Iterator<Object> iterator = articleRanking3.iterator();
        while (iterator.hasNext()) {
            ArticleRanking articleRanking4 = (ArticleRanking) iterator.next();
            list.add(articleRanking4);
            System.out.println(articleRanking4.getId());
        }
        return list;
    }

    /**
     * 添加前十点赞最高
     *
     * @param articleRanking
     * @return
     */
//    @Scheduled(cron = "* * 8 * * ?")
    @Override
    public void insertArticle(ArticleRanking articleRanking) {


        List<ArticleRanking> articleRankingList = this.findArticleAll(0,10);

        //保存到redis
        int i = 1;
        for (ArticleRanking ranking : articleRankingList) {

            /*//给排名前3的用户发邮件
            if (i++ <= 3) {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = null;
                try {
                    mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

                    mimeMessageHelper.setSubject("BBS排行榜");
                    mimeMessageHelper.setText("恭喜您的帖子在本站获得第" + i + "名!<br><a href='#'>点击查看</a>");

                    mimeMessageHelper.setTo("2420587354@qq.com");//发给谁
                    mimeMessageHelper.setFrom("990355623@qq.com");//谁发的

                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }*/
            redisTemplate.opsForZSet().add("articleRanking", ranking, ranking.getId());
        }




    }
}
