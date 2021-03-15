//package com.example.coldchain.server.mapper;
//
//import com.example.coldchain.server.pojo.CarState;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author ZhaoDesong
// * @date 2020/11/29 10:25
// */
//@SpringBootTest
//class CarStateMapperTest {
//    @Resource
//    private CarStateMapper carStateMapper;
//
//    @Test
//    void saveSelective() {
//    }
//
//    @Test
//    void updateByPrimaryKeySelective() {
//    }
//
//    @Test
//    void getByOrderId() {
//        System.out.println(carStateMapper.getByOrderId(1020000000000L));
//    }
//
//    @Test
//    void getCarLatestStateByOrderIdList() {
//        List<CarState> carStateList = carStateMapper.getCarLatestStateByOrderIdList(Arrays.asList(1020000000000L,1020000000001L));
//        System.out.println(carStateList);
//    }
//}