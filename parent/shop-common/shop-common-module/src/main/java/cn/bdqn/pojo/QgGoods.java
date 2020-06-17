package cn.bdqn.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   
*/
public class QgGoods implements Serializable {
    //主键
    private String id;
    //商品图片
    private String goodsImg;
    //商品名称
    private String goodsName;
    //商品单价
    private Double price;
    //原始库存
    private Integer originalStock;
    //当前库存
    private Integer currentStock;
    //已锁定库存
    private Integer lockStock;
    //
    private Date createdTime;
    //
    private Date updatedTime;
    //get set 方法
    public void setId (String  id){
        this.id=id;
    }
    public  String getId(){
        return this.id;
    }
    public void setGoodsImg (String  goodsImg){
        this.goodsImg=goodsImg;
    }
    public  String getGoodsImg(){
        return this.goodsImg;
    }
    public void setGoodsName (String  goodsName){
        this.goodsName=goodsName;
    }
    public  String getGoodsName(){
        return this.goodsName;
    }
    public void setPrice (Double  price){
        this.price=price;
    }
    public  Double getPrice(){
        return this.price;
    }
    public void setOriginalStock (Integer  originalStock){
        this.originalStock=originalStock;
    }
    public  Integer getOriginalStock(){
        return this.originalStock;
    }
    public void setCurrentStock (Integer  currentStock){
        this.currentStock=currentStock;
    }
    public  Integer getCurrentStock(){
        return this.currentStock;
    }
    public void setLockStock (Integer  lockStock){
        this.lockStock=lockStock;
    }
    public  Integer getLockStock(){
        return this.lockStock;
    }
    public void setCreatedTime (Date  createdTime){
        this.createdTime=createdTime;
    }
    public  Date getCreatedTime(){
        return this.createdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
}
