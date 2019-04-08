package com.lily.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

public class RouteInfo {
    private String id;  //id
    private String type;  //专线类型
    private String startPoint;  //起点
    private String endPoint;  //终点
    private String staAndEndTime;  //首末班时间
    private Integer totalFare;  //总票价(单位：分)
    private Integer shiftNum;  //班次数量
    private String status; //状态
    private String cityCode;  //服务城市码
    private String cityName;  //服务城市名称
    private String[] siteNameArr;  //站点名称数组(便于之后根据站点名称查询)
    private LinkedHashMap<String, Site> siteMap;  //站点集合
    private Date createTime;  //创建时间
    private Date updateMap;  //更新时间
    /**
     * 站点对象
     */
    @Data
    public class Site{
        private String siteName;  //站点名称
        private String[] siteCoord;  //站点坐标
        private Integer siteFare;  //站点票价
    }
}
