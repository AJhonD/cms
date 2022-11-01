package com.briup.cms.web.vm;

import com.briup.cms.bean.Category;
import lombok.Data;

/**
 * 新增咨询时的参数信息
 * @Author lining
 * @Date 2022/11/1
 */
@Data //jackson 调用set方法
public class ArticleVM {
    private String title;
    private String content;
    private Category category;
}
