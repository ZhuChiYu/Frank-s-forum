package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.PaginationDTO;
import com.example.springbootdemo.dto.QuestionDTO;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.springbootdemo.service.QuestionService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name="page",defaultValue = "1")Integer page,
                        @RequestParam(name="size",defaultValue = "2") Integer size
                        ){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length!=0){
            for(Cookie cookie :cookies){
                if(cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user=userMapper.findByToken(token);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }

            }
        }
        //返回既带有questionmapper信息，又带有user信息。
        PaginationDTO pagination =questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }



}
