package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.PaginationDTO;
import com.example.springbootdemo.dto.QuestionDTO;
import com.example.springbootdemo.mapper.QuestionMapper;
import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.Question;
import com.example.springbootdemo.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//service层用来组装两个mapper
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount=questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        if(page<1){
            page=1;
        }
        if(page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }
        Integer offset=size*(page-1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            //1、将questionMapper放到questionDTO中
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        //
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
