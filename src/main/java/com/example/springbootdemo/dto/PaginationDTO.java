package com.example.springbootdemo.dto;

import com.example.springbootdemo.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;//显示前一页标志<
    private boolean showFirstPage;//显示第一页标志<<
    private boolean showNext;//显示后一页标志>
    private boolean showEndPage;//显示最后一页标志>>
    private Integer page;//显示当前页
    private List<Integer> pages=new ArrayList<>();//显示列表，当前页左三个页码，右三个页码
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else totalPage=totalCount/size+1;

        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }
        this.page=page;
        pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalPage){
                pages.add(page+i);
            }
        }

        //是否展示前一页
        if(page==1){
            showPrevious=false;
        }else showPrevious=true;
        //是否展示后一页
        if(page==totalPage){
            showNext=false;
        }else showNext=true;
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else showFirstPage=true;
        //是否展示最后一页
        if(pages.contains(totalPage)){
            showEndPage=false;
        }else showEndPage=true;

    }
}
