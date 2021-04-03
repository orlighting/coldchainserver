package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.AdminMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.Admin;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import com.example.coldchain.server.pojo.GoodOrderMongo;
import com.mongodb.client.gridfs.model.GridFSFile;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.bson.types.ObjectId;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @Author ccesss
 * @Date 2021/3/15 9:25
 * @Version 1.0
 **/
@Controller
public class DataController {

    @Resource
    GridFsTemplate gridFsTemplate;
    @Resource
    GoodOrderMapper goodOrderMapper;
    @Resource
    DriverMapper driverMapper;
    @Resource
    AdminMapper adminMapper;




    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/carBendOrder")//车辆订单绑定接口
    public HttpResult<GoodOrder> carBendOrder(@RequestBody GoodOrder goodOrder){
        System.out.println(goodOrder.getDeviceId());
        GoodOrder goodOrder2=goodOrderMapper.getOrderByDeviceId(goodOrder.getDeviceId());
        System.out.println(goodOrder2);
        return HttpResult.of(goodOrder2);
    }


    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/getDriver")//获取司机信息
    public HttpResult<Driver> getDriver(@RequestBody Driver driver){
        System.out.println(driver.getDriverId());
        return HttpResult.of(driverMapper.selectByPrimaryKey(driver.getDriverId()));
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/getCreator")//获取订单员信息
    public HttpResult<Admin> getAdmin(@RequestBody Admin admin){
        System.out.println(admin.getCreatorId());
        return HttpResult.of(adminMapper.getByPrimaryKey(admin.getCreatorId()));
    }


    /**
     * 获取详细申报的文件
     */
    @CrossOrigin
    @RequestMapping("api/data/detailFile")
    public ResponseEntity<FileSystemResource> detailList(@RequestBody JSONObject fileId) {

        try {
            GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId.get("fileId"))));
            GridFsResource gridFsResource = gridFsTemplate.getResource(gridFSFile);
            File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "dmp");
            FileUtils.copyInputStreamToFile(gridFsResource.getInputStream(), file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", "attachment; filename=" +
                    URLEncoder.encode(gridFSFile.getFilename(), "utf-8"));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(System.currentTimeMillis()));

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(new FileSystemResource(file));
        } catch (Exception e) {
            System.out.println("获取文件出错，e="+ e);

            return ResponseEntity.badRequest().body(null);
        }

    }

    /**
     * 查看文件
     * @param goodOrderMongo
     * @return
     * @throws IOException
     */

    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/receiveFile")
    public HttpResult receiveFile(GoodOrderMongo goodOrderMongo) throws IOException {
        System.out.println("receiveFile:"+goodOrderMongo);
        MultipartFile meatQualityInspection = goodOrderMongo.getMeatQualityInspection();
        MultipartFile selfTestReport = goodOrderMongo.getSelfTestReport();
        MultipartFile quarantineCertificate = goodOrderMongo.getQuarantineCertificate();

        String meatQualityInspectionId = saveFileToMongo(meatQualityInspection);
        String selfTestReportId = saveFileToMongo(selfTestReport);
        String quarantineCertificateId = saveFileToMongo(quarantineCertificate);

        Long orderId = goodOrderMongo.getId();
        GoodOrder goodOrder = goodOrderMapper.getByPrimaryKey(orderId);
        System.out.println(goodOrder);
        goodOrder.setMeatQualityInspectionId(meatQualityInspectionId);
        goodOrder.setSelfTestReportId(selfTestReportId);
        goodOrder.setQuarantineCertificateId(quarantineCertificateId);
        System.out.println(goodOrder );
        goodOrderMapper.updateByPrimaryKeySelective(goodOrder);

        return HttpResult.of(goodOrder);
    }



    /**
     * 将前端传来的文件保存到mongo
     *
     * @param file
     * @return mongo中保存记录的id
     */
    private String saveFileToMongo(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        ObjectId objectId = gridFsTemplate.store(inputStream, fileName);
        return objectId.toHexString();
    }






}
