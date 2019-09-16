package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.model.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @ClassName PageService
 * @Auth 桃子
 * @Date 2019-9-16 17:57
 * @Version 1.0
 * @Description
 **/
@Service
public class PageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * @Date 2019-9-16  18:03
     * @Param page 当前页码
     * @Param size 页面显示个数
     * @Param queryPageRequest 查询条件
     * @return
     * @Description
     **/
    public QueryResponseResult findPageList(int page, int size, QueryPageRequest queryPageRequest){

        //查询条件的判定
        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }
        //页面的码数与显示个数进行调整
        if(page <= 0){
            page = 1;
        }
        page = page-1;  //MongoDB会页码减一

        if(size <= 0){
            size = 20;
        }
        //执行查询
        Pageable pageable = new PageRequest(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,cmsPageQueryResult);
    }

}
