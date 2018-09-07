package com.captain.store.controller;

import com.captain.store.dao.cluster.RBillMapper;
import com.captain.store.model.RBill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Resource
    private RBillMapper rBillMapper;

    @RequestMapping("/")
    public String index() {
        return "dafy/bill";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public RBill getBill(@PathVariable("id") long id) {
        return rBillMapper.selectByPrimaryKey(id);
    }

//    @RequestMapping("/list")
//    public List<RBill> selectList() {
//        PageHelper.startPage(1, 10);
//        return this.rBillMapper.s(new RBill());
//        //return null ;
//    }
}
