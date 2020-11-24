package com.example.coldchain.server.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GoodOrder {

    /**
     * 订单id
     */
    private Long id;

    /**
     * 司机id
     */
    private Long driverId;

    /**
     * 货物种类
     */
    private String goodKind;

    /**
     * 货物名称
     */
    private String goodName;

    /**
     * 起点
     */
    private String starting;

    /**
     * 终点
     */
    private String destination;

    /**
     * 车辆id
     */
    private Long carId;

    /**
     * 订单是否完成
     */
    private Boolean complete;

    /**
     * 建议最高温度
     */
    private Float tempHigh;

    /**
     * 建议最低温度
     */
    private Float tempLow;

    /**
     * 建议最高湿度
     */
    private Float humidityHigh;

    /**
     * 建议最低湿度
     */
    private Float humidityLow;

    /**
     * 是否被删除
     */
    private Boolean delete;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

}
