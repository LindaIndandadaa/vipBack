package com.leilin.vip.function.impl;

import com.leilin.common.ThisSystemException;

import static com.leilin.common.AssertThrowUtil.*;

import com.leilin.common.ThisSystemUtil;
import com.leilin.vip.dao.UserDao;
import com.leilin.vip.entity.UserEntity;
import com.leilin.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionImpl implements UserFunction {

    @Autowired
    UserDao uDao;

    @Override
    public UserEntity login(String account, String password) throws Exception {
       /*
        if(account == null || account.trim().length()==0) {
            throw new ThisSystemException("用户名为空");
        }
        if(account == null || account.trim().length()==0) {}
        */
        account = $("账户不能为空", account);
        password = $("密码不能为空", password);

        //判断用户是否存在以及是否正确
        UserEntity user = uDao.select("account",account);
        if(user == null)
            throw new ThisSystemException("账户不存在");
        password = ThisSystemUtil.md5(password);//md5加密
        if(!user.getPassword().equals(password))
            throw new ThisSystemException("密码错误");

        return user;
    }

    @Override
    public UserEntity updatepassword(String id, String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1：验证参数
        id = $("id不能为空", id);
        oldPassword = $("旧密码不能为空", oldPassword);
        newPassword = $("新密码必须填写", newPassword);
        newPasswordConfirm = $("新密码确认必须填写", newPasswordConfirm);
        System.out.println(oldPassword+"----"+newPassword);
        assertNotEquals("新旧密码不能一样", oldPassword, newPassword);
        assertEquals("两次密码输入不一致", newPassword, newPasswordConfirm);

        //2：找到用户
        oldPassword = ThisSystemUtil.md5(oldPassword);
        UserEntity user = uDao.select("id", id);
        assertNotNull("无法找到用户", user);

        //3：验证旧密码
        assertEquals("旧密码不正确", user.getPassword(), oldPassword);

        //4:更新旧密码,写入数据库
        newPassword = ThisSystemUtil.md5(newPassword);
        user.setPassword(newPassword);
        uDao.update(user);

        return user;
    }

}
