package com.example.coldchain.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Admin {

    /**
     * 管理员id
     */
    private Long creatorId;

    /**
     * 管理员姓名
     */
    private String name;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 手机号
     */
    private String teleNum;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 部门
     */
    private String department;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 账户种类
     */
    private Integer kind;

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
     * 订单员审核标志位
     * todo
     */


}
