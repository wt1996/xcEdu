package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import com.xuecheng.manage_cms.run.ManageCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * @ClassName CmsPageRepositoryTest
 * @Auth 桃子
 * @Date 2019-9-16 16:39
 * @Version 1.0
 * @Description 使用SpringBoot的测试类
 **/

@SpringBootTest(classes = ManageCmsApplication.class)
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    //测试连接
    @Test
    public void testFindPage(){
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all.getContent());
    }

    //测试添加
    @Test
    public void testInsert(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam>  pageParams = new ArrayList<>();//页面参数？？？
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        pageParams.add(cmsPageParam);
        cmsPage.setPageParams(pageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    //测试修改
    @Test
    public void testUpdate(){
        Optional<CmsPage> optional = cmsPageRepository.findById("5d7f54ba482833269840554d");
        if(optional.isPresent()){
            //存在则修改
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("测试修改页面");
            cmsPageRepository.save(cmsPage);
        }
    }

    //测试删除
    @Test
    public void testDelete(){
        cmsPageRepository.deleteById("5d7f54ba482833269840554d");
    }
}
