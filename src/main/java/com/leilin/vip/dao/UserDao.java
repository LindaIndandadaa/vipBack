package com.leilin.vip.dao;

import com.leilin.common.AbstractDao;
import com.leilin.vip.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserDao extends AbstractDao<UserEntity> {
    //public UserEntity selectByAccount(@Param("account") String account) throws Exception;
    UserEntity select(@Param("key") String ukfiled, @Param("value") Object value) throws Exception;

}
