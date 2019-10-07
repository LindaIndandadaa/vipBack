package com.leilin.vip.web.handler;

import com.leilin.common.ThisSystemException;
import com.leilin.vip.entity.VipEntity;
import com.leilin.vip.entity.VipRankEntity;
import com.leilin.vip.function.VipFunction;
import com.leilin.vip.web.handler.vo.VipVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class VipHandler extends AbstractHandler {

    @Autowired
    VipFunction fun;

    @RequestMapping(path="/vip/qry.do", method = RequestMethod.GET)
    public String qryView() throws Exception{
        return "vip/qry";
    }
    @RequestMapping(path="/vip/qry.do", method = RequestMethod.POST)
    public String qry(String code, HttpServletRequest req) throws Exception{
        try {
            VipEntity vip = fun.queryVip(code);
            VipVo vo = new VipVo();
            vo.setAddress(vip.getAddress());
            vo.setAge(String.valueOf(vip.getAge()));
            vo.setAmount(String.valueOf(vip.getAmount()/100.0));
            vo.setCode(vip.getCode());
            vo.setName(vip.getName());
            vo.setEmail(vip.getEmail());
            vo.setQq(vip.getQq());
            VipRankEntity rank = this.getRank(req, vip.getRank());
            vo.setRank(rank.getName());

            vo.setSex(vip.getSex().equals("1")?"男":"女");
            vo.setZip(vip.getZip());
            vo.setRemark(vip.getRemark());

            req.setAttribute("vip", vo);//VO
        }catch (ThisSystemException e) {
            req.setAttribute("message", e.getMessage());
        }
        return "vip/qry";
    }


}
