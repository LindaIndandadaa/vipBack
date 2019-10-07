package com.leilin.vip.function.impl;

import com.leilin.common.ThisSystemException;
import com.leilin.vip.dao.VipDAO;
import com.leilin.vip.entity.VipEntity;
import com.leilin.vip.function.VipFunction;
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
}
