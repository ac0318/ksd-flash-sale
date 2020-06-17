package com.bdqn.biz;

import cn.bdqn.RpcQgUserService;
import cn.bdqn.mapper.QgUserMapper;
import cn.bdqn.pojo.QgUser;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Service(interfaceClass = RpcQgUserService.class)
public class UserBizImpl implements RpcQgUserService {
    @Resource
    private QgUserMapper userMapper;

    @Override
    public QgUser getQgUserById(String id) throws Exception {
        return null;
    }

    @Override
    public QgUser getQgUserByWxUserId(String wxUserId) throws Exception {
        return null;
    }

    @Override
    public QgUser findByPhone(String phone) throws Exception {
        return userMapper.findByPhone(phone);
    }

    @Override
    public QgUser login(String name, String password) throws Exception {
        return null;
    }

    @Override
    public QgUser getCurrentUser(String tokenString) throws Exception {
        return null;
    }

    @Override
    public Integer createQgUser(String wxUserId, String id) throws Exception {
        return null;
    }
}
