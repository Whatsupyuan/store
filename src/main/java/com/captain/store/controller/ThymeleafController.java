package com.captain.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
