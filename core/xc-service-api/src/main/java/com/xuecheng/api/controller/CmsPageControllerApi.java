package com.xuecheng.api.controller;

import com.xuecheng.framework.model.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * @ClassName CmsPageControllerApi
 * @Auth 桃子
 * @Date 2019-9-12 11:15
 * @Version 1.0  CMS的对外服务接口
 **/
public interface CmsPageControllerApi {

     QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
