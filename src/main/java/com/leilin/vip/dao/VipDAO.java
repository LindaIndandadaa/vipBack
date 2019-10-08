package com.leilin.vip.dao;

import com.leilin.common.AbstractDao;
import com.leilin.vip.entity.VipEntity;
import org.apache.ibatis.annotations.Param;

public interface VipDAO extends AbstractDao<VipEntity> {

    VipEntity select(@Param("key") String ukfiled, @Param("value") Object value) throws Exception;

}
