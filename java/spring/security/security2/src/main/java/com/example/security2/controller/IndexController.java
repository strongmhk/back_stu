package com.example.security2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"", "/"})
    public String index() {
        // mustache 기본 경로 : src/main/resources/
        // ViewResolver 설정 : templates (prefix) , mustache(suffix) - 생략 가능
        return "index";
    }

}
