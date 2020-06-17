package com.bdqn.biz;

import cn.bdqn.RpcQgGoodsTemp;
import cn.bdqn.mapper.QgGoodsTemp;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = RpcQgGoodsTemp.class)
public class OrderBiz implements RpcQgGoodsTemp {
    @Resource
    QgGoodsTemp goodsTemp;

    @Override
    public int insert(int gid, int uid) {
        return goodsTemp.insert(gid, uid);
    }
}
