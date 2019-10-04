package com.leilin.vip.function.impl;

import com.leilin.common.ThisSystemException;
import com.leilin.common.ThisSystemUtil;
import static com.leilin.common.ThisSystemUtil.*;
import com.leilin.vip.dao.UserDao;
import com.leilin.vip.entity.UserEntity;
import com.leilin.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        System.out.println("账户："+account+"密码："+password);
        account = $("账户不能为空", account);
        System.out.println("已判断");
        password = $("密码不能为空", password);

        //判断用户是否存在以及是否正确
        UserEntity user = uDao.selectByAccount(account);
        if(user == null)
            throw new ThisSystemException("账户不存在");
        if(!user.getPassword().equals(password))
            throw new ThisSystemException("密码错误");

        return user;
    }

}
