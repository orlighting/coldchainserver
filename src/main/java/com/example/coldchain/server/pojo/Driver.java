package com.example.coldchain.server.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
@AllArgsConstructor
public class Driver implements Serializable {
    /**
     * 司机编号
     */
    private Long driverId;

    /**
     * 司机姓名
     */
    private String name;

    /**
     * 司机电话
     */
    private String phoneNumber;

    /**
     * 司机面部特征
     */
    private String faceToken;

    /**
     * 司机驾龄
     */
    private String driverYear;

    /**
     * 驾照类型
     */
    private String driverLicense;

    private Integer checkState;

    private Boolean delete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}