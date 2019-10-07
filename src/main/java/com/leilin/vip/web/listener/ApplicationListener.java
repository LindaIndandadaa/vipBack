package com.leilin.vip.web.listener;

import com.leilin.vip.dao.VipRankDao;
import com.leilin.vip.entity.VipRankEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationListener extends ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        //不知道VipRankDan存储的名字，所以要通过这个来获取
        ServletContext sc = sce.getServletContext();
        //初始化系统数据
        try {
            this.initVipRank(sc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        super.contextDestroyed(sce);
    }

    private void initVipRank(ServletContext sc) throws Exception {
        //Spring工具类，可以拿到整个spring容器，
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        //获取DAO对象
        VipRankDao rDao = ac.getBean(VipRankDao.class);//按类型取，因为只有一个
        List<VipRankEntity> ranks =  rDao.selectAll();
        Map<Integer, VipRankEntity> ranksMap = new HashMap<>();
        for(VipRankEntity v:ranks)
            ranksMap.put(v.getCode(), v);
        sc.setAttribute("RANKS-MAP", ranksMap);
    }
}
