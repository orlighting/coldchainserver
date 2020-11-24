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
    private Float temperature1;

    /**
     * 2号传感器温度
     */
    private Float temperature2;

    /**
     * 3号传感器温度
     */
    private Float temperature3;

    /**
     * 4号传感器温度
     */
    private Float temperature4;

    /**
     * 5号传感器温度
     */
    private Float temperature5;

    /**
     * 6号传感器温度
     */
    private Float temperature6;

    /**
     * 7号传感器温度
     */
    private Float temperature7;

    /**
     * 1号传感器湿度
     */
    private Float humidity1;

    /**
     * 2号传感器湿度
     */
    private Float humidity2;

    /**
     * 3号传感器湿度
     */
    private Float humidity3;

    /**
     * 4号传感器湿度
     */
    private Float humidity4;

    /**
     * 5号传感器湿度
     */
    private Float humidity5;

    /**
     * 6号传感器湿度
     */
    private Float humidity6;

    /**
     * 7号传感器湿度
     */
    private Float humidity7;

    /**
     * 开关门信息
     */
    private Boolean doorState;

    /**
     * 经度
     */
    private Float longitude;

    /**
     * 经度状态
     */
    private Boolean longitudeState;

    /**
     * 纬度
     */
    private Float latitude;

    /**
     * 纬度状态
     */
    private Boolean latitudeState;

    /**
     * 是否出于告警状态
     */
    private Boolean alert;

    /**
     * 是否被删除
     */
    private Boolean delete;

}
