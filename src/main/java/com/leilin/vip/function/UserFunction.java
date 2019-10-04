package com.leilin.vip.function;

import com.leilin.vip.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public interface UserFunction {
    /**
     * 用户登录
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public UserEntity login(String account, String password) throws Exception;

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param newPasswordConfirm
     * @return
     * @throws Exception
     */
    @Transactional
    public UserEntity updatepassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception;
}
