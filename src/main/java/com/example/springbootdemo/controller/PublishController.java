package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.QuestionDTO;
import com.example.springbootdemo.mapper.QuestionMapper;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.Question;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model) {
        QuestionDTO question = questionService.getById(id);
        //回显到页面
        model.addAttribute("title", question.getTitle());
        model.addAttribute("tag", question.getDescription());
        model.addAttribute("description", question.getTag());
        //问题的标识
        model.addAttribute("id", question.getId());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("tag", tag);
        model.addAttribute("description", description);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空！");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空！");
            return "publish";
        }

        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空！");
            return "publish";
        }
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            //如果有异常，跳转到发布页面
            model.addAttribute("error", "用户未登陆");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setId(id);
        questionService.createOrUpdate(question);

        return "redirect:/";
    }


}
