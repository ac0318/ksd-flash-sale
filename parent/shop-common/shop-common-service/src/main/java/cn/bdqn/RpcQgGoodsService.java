package cn.bdqn;
import cn.bdqn.common.Dto;
import cn.bdqn.pojo.QgGoods;
import cn.bdqn.vo.QgGoodsMessageVo;

import javax.jms.JMSException;
import java.util.List;
import java.util.Map;
/**
 * Created by shang-pc on 2015/11/7.
 */
public interface RpcQgGoodsService {


    public boolean ifenouth();

    public boolean lockNum(String userid,String goodid);

    /***
     * 根据商品Id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    public QgGoods getQgGoodsById(String id)throws Exception;
    /***
     * 查询商品列表
     * @param param
     * @return
     * @throws Exception
     */
    public List<QgGoods> getQgGoodsListByMap(Map<String,Object> param)throws Exception;
    /***
     * 提供的减库存的方法
     * @throws Exception
     */
    public Dto lockGoods(QgGoodsMessageVo qgGoodsMessageVo) throws Exception;
    /***
     * 发送抢购商品消息
     * @param qgGoodsMessageVo
     * @return
     * @throws Exception
     */
    public Dto sendQgGoodsMessage(QgGoodsMessageVo qgGoodsMessageVo)throws Exception;
    /***
     * 减去库存
     * @param num
     * @param goodsId
     * @return
     * @throws Exception
     */
    public Integer minusGoods(Integer num,String goodsId) throws Exception;

    /**
     * 支付成功，减库存
     * @param qgGoodsMessageVo
     * @return
     * @throws JMSException
     */
    public Dto updateGoodsStock(QgGoodsMessageVo qgGoodsMessageVo) throws Exception;

    /**
     * 修改锁定的库存（用于定时任务）
     * @param param
     * @return
     * @throws Exception
     */
    public boolean flushGoodsLock(Map<String,Object> param) throws Exception;

}
