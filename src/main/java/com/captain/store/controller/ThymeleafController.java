package com.captain.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * SSE 页面跳转
     * @return
     */
    @RequestMapping("/sse")
    public String ssm_view() {
        return "publishing/SSE";
    }

    /**
     * SSE 功能
     * produces 必须设置为 text/event-stream
     * 根据情况设置编码格式 charset
     * @return
     */
    @RequestMapping(value = "/randomNumber" , produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String sse() {
        Random random = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // SSE 服务 返回的数值 , 需要使用 "data:" 开头 , "\n\n"结尾
        return "data:" + "SSM test : " + random.nextInt() + "\n\n";
    }

}
