package com.captain.store.controller;

import com.captain.store.base.redis.RedisCL;
import com.captain.store.dao.cluster.RBillMapper;
import com.captain.store.model.RBill;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Resource
    private RBillMapper rBillMapper;

    @Autowired
    private RedisCL redisCL;

    @RequestMapping("/")
    public String index() {
        return "dafy/bill";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public RBill getBill(@PathVariable("id") long id) {
        return rBillMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<RBill> selectList() {
        List<RBill> billList = new ArrayList<RBill>();
        try {
            Page<RBill> page = PageHelper.startPage(1, 10);
            billList = this.rBillMapper.getBillList(new RBill());

            System.out.println("总条数 : " + page.getTotal());

        } catch (Exception e) {
            System.out.println("分页查询失败----");
            e.printStackTrace();
        }
        return billList;
    }

    /**
     * redis test
     * @param key
     * @param val
     * @return
     */
    @RequestMapping("/set/{key}/{value}")
    @ResponseBody
    public String set(@PathVariable("key") String key , @PathVariable("value") String val) {
        redisCL.set(key, val);
        return "success";
    }



}
