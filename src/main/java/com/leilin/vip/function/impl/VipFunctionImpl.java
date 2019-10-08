package com.leilin.vip.function.impl;

import com.leilin.common.ThisSystemException;
import com.leilin.common.ThisSystemUtil;
import com.leilin.vip.dao.VipDAO;
import com.leilin.vip.entity.VipEntity;
import com.leilin.vip.function.VipFunction;
import com.leilin.vip.web.handler.arguementObject.VipAo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.leilin.common.AssertThrowUtil.*;

@Service
public class VipFunctionImpl implements VipFunction {
    @Autowired
    VipDAO vDao;
    @Override
    public VipEntity queryVip (String code) throws Exception {
        //1验证参数
        code = $("VIP账号必须填写", code);
        //2业务查询
        VipEntity vip = vDao.select("code", code);

        if(vip==null)
            throw new ThisSystemException("未找到客户："+code);
        //3封装业务结果
        return vip;
    }

    @Override
    public VipEntity addVip(VipAo ao) throws Exception {
        //1参数验证
        if(ao == null)
            throw new IllegalArgumentException("ao不能为空");//非业务异常
        String phone = $("手机号码必须填写", ao.getPhone());
        String name = $("姓名必须填写", ao.getName());
        //验证手机号是否合法
        assertPatternMatch("手机号码不合法","\\d{11}", phone);
        //验证手机号码是否已存在
        assertFalse("手机号已存在", vDao.exist("code", phone));
        //验证姓名是否合法
        System.out.println(name);
        assertPatternMatch("姓名不合法","[\u4e00-\u9fa5]{2,}", name);
        //获取性别
        boolean male = "1".equals(ao.getSex());
        //获取年龄
        int age = parstInt(ao.getAge(), 0);

        // 2业务处理
        VipEntity v = new VipEntity();
        v.setId(ThisSystemUtil.uuid());
        v.setAddress(ao.getAddress());
        v.setAge(age);
        v.setAmount(0);
        v.setCode(phone);
        v.setEmail(ao.getEmail());
        v.setName(name);
        v.setSex(male?0:1);
        v.setQq(ao.getQq());
        v.setZip(ao.getZip());
        v.setRemark(ao.getRemark());
        v.setRank(0);
        vDao.insert(v);

        //3封装业务结果
        return null;

    }
}
