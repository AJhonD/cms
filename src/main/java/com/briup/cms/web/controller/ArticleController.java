package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.utils.ObjectUtils;
import com.briup.cms.utils.Result;
import com.briup.cms.web.vm.ArticleVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lining
 * @Date 2022/11/1
 */
@Api(tags = "咨询管理模块")
@RestController
@RequestMapping("/auth/article")
public class ArticleController {
    @Autowired
    private IArticleService service;
    @ApiOperation("新增咨询")
    @PostMapping
    public Result addArticle(@RequestBody ArticleVM vm){
        //使用自己封装的工具类，将vm对象转换为bean对象
        service.saveOrUpdateArticle(ObjectUtils.vm2Bean(vm,Article.class));
        return Result.success();
    }
    @ApiOperation("修改咨询")
    @PutMapping
    public Result updateArticle(@RequestBody Article article){
        service.saveOrUpdateArticle(article);
        return Result.success();
    }
    @ApiOperation(value = "批量删除咨询信息",notes = "删除咨询信息，并且将对应的评论信息一起删除")
    @DeleteMapping
    public Result deleteByBatch(@RequestBody List<Integer> ids){
        service.deleteArticleInBatch(ids);
        return Result.success();
    }

}
