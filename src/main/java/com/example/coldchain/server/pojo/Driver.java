package com.example.coldchain.server.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Driver {

    /**
     * 司机工号id
     */
    private Long id;

    /**
     * 司机姓名
     */
    private String name;

    /**
     * 司机面部信息对应的faceToken
     */
    private String faceToken;

    /**
     * 司机的驾龄
     */
    private Integer driveYear;

    /**
     * 司机的驾照
     */
    private String driveLicense;

    /**
     * 司机账号的审核状态，0-未审核状态，1-已通过，2-不通过
     */
    private Integer checkState;

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
