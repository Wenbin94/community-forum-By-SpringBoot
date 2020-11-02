package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Create {
    @GetMapping("/create")
    public String create(){

        return "site/create";
    }
}
