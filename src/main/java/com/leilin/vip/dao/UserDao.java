package com.leilin.vip.dao;

import com.leilin.vip.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserDao {
    public UserEntity selectByAccount(@Param("account") String account) throws Exception;

}
