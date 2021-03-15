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
     * 货物种类
     */
    private String goodKind;

//    /**
//     * 货物名称
//     */
//    private String goodName;

    /**
     * 起点
     */
    private String starting;

    /**
     * 终点
     */
    private String destination;

    /**
     * 车牌号
     */
    private String carId;

    /**
     * 设备编号
     */
    private Integer deviceId;



    /**
     * 司机id
     */
    private String driverId;

//    /**
//     * 建议最高温度
//     */
//    private String tempHigh;

//    /**
//     * 建议最低温度
//     */
//    private String tempLow;
//
//    /**
//     * 建议最高湿度
//     */
//    private String humidityHigh;
//
//    /**
//     * 建议最低湿度
//     */
//    private String humidityLow;
//
//    /**
//     * 视频流url
//     */
//    private String videoHttp;

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

    /**
     * 订单完成状态
     */
    private String completeState;

    /**
     * 开关门计数
     */
    private int countDoor;
    /**
     * 订单异常状态
     */
    private Boolean errorState;

    /**
     * 动物检疫证明id
     */
    private String quarantineCertificateId;

    /**
     * 肉品品质检验合格证明id
     */
    private String meatQualityInspectionId;

    /**
     * 非洲猪瘟自测报告
     */
    private String selfTestReportId;

    /**
     * 车厢摄像头地址
     */
    private String videoHttpBack;

    /**
     * 司机摄像头地址
     */
    private String videoHttpFront;

    /**
     * 屠宰场字段
     */
    private String slaughter;

    /**
     * 运输公司字段
     */
    private String transportCompany;

    /**
     * 订单重量
     */
    private String height;

    /**
     * 装车视频id
     */
    private String loadingVideoId;

    /**
     * 卸车视频id
     */
    private String unloadingVideoId;

    /**
     * 日期
     */
    private String date;

}
