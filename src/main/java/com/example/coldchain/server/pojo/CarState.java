package com.example.coldchain.server.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarState {

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 1号传感器温度
     */
    private String temperature1;

    /**
     * 2号传感器温度
     */
    private String temperature2;

    /**
     * 3号传感器温度
     */
    private String temperature3;

    /**
     * 4号传感器温度
     */
    private String temperature4;

    /**
     * 5号传感器温度
     */
    private String temperature5;

    /**
     * 6号传感器温度
     */
    private String temperature6;

    /**
     * 7号传感器温度
     */
    private String temperature7;

    /**
     * 1号传感器湿度
     */
    private String humidity1;

    /**
     * 2号传感器湿度
     */
    private String humidity2;

    /**
     * 3号传感器湿度
     */
    private String humidity3;

    /**
     * 4号传感器湿度
     */
    private String humidity4;

    /**
     * 5号传感器湿度
     */
    private String humidity5;

    /**
     * 6号传感器湿度
     */
    private String humidity6;

    /**
     * 7号传感器湿度
     */
    private String humidity7;

    /**
     * 开关门信息
     */
    private Boolean doorState;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 经度状态
     */
    private Boolean longitudeState;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 纬度状态
     */
    private Boolean latitudeState;

    /**
     * 是否出于告警状态
     */
    private Boolean alert;

    /**
     * 是否是该订单的最新记录
     */
    private Boolean latest;

    /**
     * 是否被删除
     */
    private Boolean delete;

}
