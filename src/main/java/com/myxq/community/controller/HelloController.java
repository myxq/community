package com.myxq.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李永庆
 * @since 2019/11/17
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
