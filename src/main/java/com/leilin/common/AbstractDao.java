package com.leilin.common;

import com.leilin.vip.entity.UserEntity;
import com.leilin.vip.entity.VipEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *公共DAO接口
 */
public interface AbstractDao<T> {
    void insert(T t) throws Exception;
    void delete(@Param("key") String ukfiled, @Param("value") Object value) throws Exception;
    void update(T t) throws Exception;
    boolean exist(@Param("key") String ukfiled, @Param("value") Object value) throws Exception;
    List<T> selectLike(@Param("key") String key) throws Exception;

}
