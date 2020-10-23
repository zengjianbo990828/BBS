package com.bbs.demo.service.impl;

import com.bbs.demo.dao.FansUserMapper;
import com.bbs.demo.pojo.FansUser;
import com.bbs.demo.service.IFansUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: 曾建波
 * @date: 2020-09-28
 * @description: 我的粉丝模块接口实现
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bbs.demo.service.impl
 */
@Service
@Transactional
public class FansUserServiceImpl implements IFansUserService {
    @Resource
    private FansUserMapper fansUserMapper;

    @Override
    public List<String> queryFansList(FansUser fansUser) {
        return this.fansUserMapper.queryFansList(fansUser);

    }

    @Override
    public Integer queryFansNum(Integer uid) throws RuntimeException {
        return this.fansUserMapper.queryFansNum(uid);
    }

    @Override
    public List<Map> queryUserConcern(FansUser fansUser) throws RuntimeException {
        return this.fansUserMapper.queryUserConcern(fansUser);
    }

    @Override
    public Integer queryConcernNum(Integer uid) throws RuntimeException {
        return this.fansUserMapper.queryConcernNum(uid);
    }

    @Override
    public List<Map> queryLikeInfo(FansUser fansUser) throws RuntimeException {
        return this.fansUserMapper.queryLikeInfo(fansUser);
    }
}
