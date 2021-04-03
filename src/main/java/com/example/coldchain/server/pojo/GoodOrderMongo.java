package com.example.coldchain.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ccesss
 * @Date 2021/3/23 10:08
 * @Version 1.0
 * 用于接收三个类型的照片
 **/
@Data
@AllArgsConstructor
public class GoodOrderMongo {
    /**
     * 订单id
     */
    private Long id;


    /**
     * 动物检疫证明id
     */
    private MultipartFile quarantineCertificate;

    /**
     * 肉品品质检验合格证明id
     */
    private MultipartFile meatQualityInspection;

    /**
     * 非洲猪瘟自测报告
     */
    private MultipartFile selfTestReport;


}
