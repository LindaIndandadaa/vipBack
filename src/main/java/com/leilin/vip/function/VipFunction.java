package com.leilin.vip.function;

import com.leilin.vip.entity.VipEntity;

public interface VipFunction {
    VipEntity queryVip(String code) throws Exception;
}
