package com.bdqn.biz;

import cn.bdqn.RpcQgGoodsService;
import cn.bdqn.common.Dto;
import cn.bdqn.mapper.QgGoodsMapper;
import cn.bdqn.pojo.QgGoods;
import cn.bdqn.vo.QgGoodsMessageVo;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
@Service(interfaceClass = RpcQgGoodsService.class)
public class GoodBiz implements RpcQgGoodsService {
    @Resource
    QgGoodsMapper goodsMapper;

    @Override
    public boolean ifenouth() {
        return false;
    }

    @Override
    public boolean lockNum(String userid, String goodid) {
        return false;
    }

    @Override
    public QgGoods getQgGoodsById(String id) throws Exception {
        QgGoods goods = goodsMapper.getQgGoodsById(id);
        return goods;
    }

    @Override
    public List<QgGoods> getQgGoodsListByMap(Map<String, Object> param) throws Exception {
        return null;
    }

    @Override
    public Dto lockGoods(QgGoodsMessageVo qgGoodsMessageVo) throws Exception {
        return null;
    }

    @Override
    public Dto sendQgGoodsMessage(QgGoodsMessageVo qgGoodsMessageVo) throws Exception {
        return null;
    }

    @Override
    public Integer minusGoods(Integer num, String goodsId) throws Exception {
        return null;
    }

    @Override
    public Dto updateGoodsStock(QgGoodsMessageVo qgGoodsMessageVo) throws Exception {
        return null;
    }

    @Override
    public boolean flushGoodsLock(Map<String, Object> param) throws Exception {
        return false;
    }
}
