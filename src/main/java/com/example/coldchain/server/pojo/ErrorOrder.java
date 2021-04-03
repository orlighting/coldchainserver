package com.example.coldchain.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author ccesss
 * @Date 2021/3/29 10:27
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class ErrorOrder {
    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 问题发生时间
     */
    private LocalDateTime createTime;

//    private static final long serialVersionUID = 1L;
    /**
     * 问题类型：0.开关门异常1.温湿度异常
     */
    private Integer alert;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 1.东经；0.西经
     */
    private Boolean longitudeState;

    /**
     * 维度
     */
    private String latitude;

    /**
     * 1.北纬；0.南纬
     */
    private Boolean latitudeState;

    /**
     * 删除标志位
     */
    private Boolean delete;

    /**
     * 问题结束时间
     */
    private LocalDateTime endTime;
}
