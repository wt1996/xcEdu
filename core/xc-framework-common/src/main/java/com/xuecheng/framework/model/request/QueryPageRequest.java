package com.xuecheng.framework.model.request;

/**
 * @ClassName QueryPageRequest
 * @Auth 桃子
 * @Date 2019-9-11 14:38
 * @Version 1.0
 * @Description  请求模型接口，查询页面
 **/
public class QueryPageRequest  extends RequestData {

    //站点id
    private String siteId;

    //页面Id
    private String pageId;

    //页面名称
    private String pageName;

    //页面别名
    private String pageAlias;

    //模板Id
    private String templateId;


}
