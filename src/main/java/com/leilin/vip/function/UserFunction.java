package com.leilin.vip.function;

import com.leilin.vip.entity.UserEntity;

public interface UserFunction {
    public UserEntity login(String account, String password) throws Exception;
}
