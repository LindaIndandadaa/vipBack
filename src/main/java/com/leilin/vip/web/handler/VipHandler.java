package com.leilin.vip.web.handler;

import com.leilin.common.ThisSystemException;
import com.leilin.vip.entity.VipEntity;
import com.leilin.vip.entity.VipRankEntity;
import com.leilin.vip.function.VipFunction;
import com.leilin.vip.web.handler.arguementObject.VipAo;
import com.leilin.vip.web.handler.viewObject.VipVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理index界面的请求
 */
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

            vo.setSex(vip.getSex()==1?"男":"女");
            vo.setZip(vip.getZip());
            vo.setRemark(vip.getRemark());

            req.setAttribute("vip", vo);//VO
        }catch (ThisSystemException e) {
            req.setAttribute("message", e.getMessage());
        }
        return "vip/qry";
    }

    @RequestMapping(path="/vip/add.do", method = RequestMethod.GET)
    public String addView() throws Exception{
        return "vip/add";
    }
    @RequestMapping(path="/vip/add.do", method = RequestMethod.POST)
    public String addVip(VipAo ao, HttpServletRequest req) throws Exception{
        try{
            //1 ao传给业务层执行
            VipEntity ve = fun.addVip(ao);
            //2 页面跳转
            req.setAttribute("message", "录入成功！");
            return "vip/add";
            //TODO:后期跳转到消费录入界面
        }catch (ThisSystemException e) {
            req.setAttribute("message", e.getMessage());
        }

        return "vip/add";
    }

    //访问welcome界面
    @RequestMapping("/welcome.do")
    public String welcome() {
        return "welcome";
    }

}
