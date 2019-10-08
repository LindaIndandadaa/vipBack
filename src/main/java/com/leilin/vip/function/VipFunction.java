package com.leilin.vip.function;

import com.leilin.vip.entity.VipEntity;
import com.leilin.vip.web.handler.arguementObject.VipAo;
import org.springframework.transaction.annotation.Transactional;

public interface VipFunction {
    /**
     * VIP客户查询
     * @param code
     * @return
     * @throws Exception
     */
    VipEntity queryVip(String code) throws Exception;

    /**
     * 录入Vip
     * @param ao
     * @return
     * @throws Exception
     */
    @Transactional
    VipEntity addVip(VipAo ao)throws Exception;

}
