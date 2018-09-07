package com.captain.store.controller;

import com.alibaba.druid.util.StringUtils;
import com.captain.store.dao.cluster.RBillMapper;
import com.captain.store.dao.master.MRelationMapper;
import com.captain.store.model.MRelation;
import com.captain.store.model.RBill;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/relation")
public class RelationController {

    @Resource
    private MRelationMapper relationMapper;


    @RequestMapping("/index")
    public String index() {
        return "dafy/index";
    }

    /**
     * 使用PageHelper进行分页
     * @return
     */
    @RequestMapping(value = "/all")
    @ResponseBody
    public List<MRelation> selectAll() {
        List<MRelation> listRelation = new ArrayList<>();
        Page<MRelation> page = PageHelper.offsetPage(1, 10 , false);
        listRelation = relationMapper.selectAll();

        return listRelation;
    }

    /**
     * 调用存储过程
     * @return
     */
    @RequestMapping(value = "/flush" , method = RequestMethod.POST)
    @ResponseBody
    public Integer pro_callFlushMatchRelationData() {
        int status = 0 ;
        try {
            relationMapper.pro_callFlushMatchRelationData();
        } catch (Exception e) {
            System.out.println(e);
            status = -1 ;
        }
        return status;
    }

    /**
     * 查询数据
     *
     * @return
     */
    @RequestMapping(value="/query" , method = RequestMethod.POST)
    public void query(HttpServletRequest request , HttpServletResponse response) throws Exception {
        String date = request.getParameter("strDate");
        Map<String, Object> condition = new HashMap<String, Object>();
        if(StringUtils.isEmpty(date)){
            this.write(response, "date 参数为空");
            return ;
        }

        // 出借资金总和
        JSONObject object = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();

        condition.put("date", date);
        condition.put("state", 1000);
        //object.put("出借资金总和", relationMapper.sum_LendIntent(condition));
        stringBuffer.append("出借资金总和 - " + relationMapper.sum_LendIntent(condition) + "<br/>");

        condition.put("state", 4000);
        //object.put("还款资金总和", relationMapper.sum_LendIntent(condition));
        stringBuffer.append("还款资金总和 - " + relationMapper.sum_LendIntent(condition) + "<br/>");

        condition.put("state", 1000);
        //object.put("原始借款金额", relationMapper.sum_borrowIntent(condition));
        stringBuffer.append("原始借款金额 - " + relationMapper.sum_borrowIntent(condition) + "<br/>");


        condition.put("state", 2000);
        //object.put("赎回产生的借款总金额", relationMapper.sum_borrowIntent(condition));
        stringBuffer.append("赎回产生的借款总金额 - " + relationMapper.sum_borrowIntent(condition) + "<br/>");

        //object.put("匹配上的理财金额", relationMapper.sum_matchRelation(condition));
        stringBuffer.append("匹配上的理财金额 - " +  relationMapper.sum_matchRelation(condition) + "<br/>");

        stringBuffer.append("账单表还款本金 - " + relationMapper.sum_borrowBill(condition) + "<br/>");

        stringBuffer.append("赎回产生可债转的借款 - " + relationMapper.sum_redemptionIntent(condition) + "<br/>");

        //JSONArray array = JSONArray.fromObject(object);
        this.write(response , stringBuffer.toString());
    }


    /**
     * 将内容写入response
     *
     * @param response
     * @param o
     * @throws Exception
     */
    public void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }

}
