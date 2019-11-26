package com.myxq.community.controller;

import com.myxq.community.dto.PaginationDTO;
import com.myxq.community.dto.QuestionDTO;
import com.myxq.community.mapper.QuestionMapper;
import com.myxq.community.mapper.UserMapper;
import com.myxq.community.model.Question;
import com.myxq.community.model.User;
import com.myxq.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李永庆
 * @since 2019/11/17
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page ,
                        @RequestParam(name = "size",defaultValue = "2") Integer size){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
