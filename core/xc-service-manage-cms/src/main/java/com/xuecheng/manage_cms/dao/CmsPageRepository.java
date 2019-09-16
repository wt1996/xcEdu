package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName CmsPageRepository
 * @Auth 桃子
 * @Date 2019-9-16 16:35
 * @Version 1.0
 * @Description
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    //根据页面名称查询
    CmsPage findByPageName(String pageName);

    //根据页面名称与类型查询
    CmsPage findByPageNameAndPageType(String pageName, String pageType);

    //根据站点与页面类型查询记录数
    int countBySiteIdAndPageType(String siteId, String pageType);

    //根据站点与页面类型分页查询
    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);

}
