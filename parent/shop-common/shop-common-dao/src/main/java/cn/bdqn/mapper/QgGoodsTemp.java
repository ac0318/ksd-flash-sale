package cn.bdqn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface QgGoodsTemp {
    public int insert (@Param("gid")int gid,@Param("uid")int uid);
}
