package com.leilin.vip.dao;

import com.leilin.common.AbstractDao;
import com.leilin.vip.entity.VipRankEntity;

import java.util.List;

public interface VipRankDao{
    List<VipRankEntity> selectAll() throws Exception;
}
