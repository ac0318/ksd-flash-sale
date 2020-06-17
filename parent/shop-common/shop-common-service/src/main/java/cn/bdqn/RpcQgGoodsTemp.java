package cn.bdqn;

import org.springframework.data.repository.query.Param;

public interface RpcQgGoodsTemp {
    public int insert (@Param("gid")int gid, @Param("uid")int uid);
}

