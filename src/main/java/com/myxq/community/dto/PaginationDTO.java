package com.myxq.community.dto;

import com.myxq.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李永庆
 * @since 2019/11/24
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
//        this.totalPage = totalPage;
//        this.page = page;
//        Integer totalPage = 0;
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        this.page = page;

        pages.add(page);
        for (int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);
            }

            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }

        // 是否展示上一页
        if (page == 1){
            showPrevious = false;
        } else {
            showNext = true;
        }
        // 是否展示下一页
        if (page.equals(totalPage)){
            showPrevious = true;
        } else {
            showNext = false;
        }

        // 是否展示第一页
        showFirstPage = !pages.contains(1);
        // 是否展示最后一页
        showEndPage = !pages.contains(totalCount);
    }
}
