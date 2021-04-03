package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.ErrorOrderMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.ErrorOrder;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import com.example.coldchain.server.server.WebSocketUtil;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.websocket.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author ccesss
 * @Date 2021/3/29 10:32
 * @Version 1.0
 **/
@Controller
public class ErrorOrderController {
    @Resource
    ErrorOrderMapper errorOrderMapper;
    @Resource
    GoodOrderMapper goodOrderMapper;


    /**
     * 接收订单接口
     * @param errorOrder
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/errorOrder")
    public HttpResult<ErrorOrder> addNewErrorOrder(@RequestBody ErrorOrder errorOrder){
        System.out.println("接收到异常订单"+errorOrder);
        if(errorOrder.getOrderId()==null){
            System.out.println("orderId没接到");
            errorOrder.setOrderId(1L);
        }
        errorOrder.setDelete(false);
        errorOrder.setCreateTime(LocalDateTime.now());
        GoodOrder goodOrder = goodOrderMapper.getByPrimaryKey(errorOrder.getOrderId());
        goodOrder.setAlert(errorOrder.getAlert());
        goodOrderMapper.updateByPrimaryKeySelective(goodOrder);
        errorOrderMapper.addNew(errorOrder);
        WebSocketUtil.sendMessageToAllOnlineUser("1");//websocket

        return HttpResult.of(errorOrder);
    }


    //异常订单结束接口
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/errorOrderEnd")
    public HttpResult endErrorOrder(){
        System.out.println("进入结束异常订单函数");
        LocalDateTime now = LocalDateTime.now();
        errorOrderMapper.updateEndTimeNull(now);
        WebSocketUtil.sendMessageToAllOnlineUser("1");//websocket
        return HttpResult.of();
    }

    /**
     * 返回所有异常订单信息
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/errorOrder/showAll")
    public HttpResult<List<ErrorOrder>> showAllErrorOrder(){
        List<ErrorOrder> all = errorOrderMapper.findAll();
        System.out.println(all);
        return HttpResult.of(all);
    }


    /**
     * 根据一个订单id查询订单下所有的问题订单
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/errorOrder/anOrder")
    public HttpResult<List<ErrorOrder>> queryErrorOrderById(@NotNull Long id){
        List<ErrorOrder> errorOrders = errorOrderMapper.selectByPrimaryKey(id);
        if(errorOrders==null){
            return HttpResult.of(null);
        }
        System.out.println(errorOrders);
        return HttpResult.of(errorOrders);
    }



    private static void sendMessage(Session session, String message) {

        final RemoteEndpoint.Basic basic = session.getBasicRemote();

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void openSession(Session session){
        //存储用户
        WebSocketUtil.USERS_ONLINE.put("username", session);

    }


    @OnClose
    public void closeSession(Session session){


        //删除用户
        WebSocketUtil.USERS_ONLINE.remove("username");
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message){


    }

    @OnError
    public void sessionError(Session session, Throwable throwable){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("WebSocket连接发生异常，message:"+throwable.getMessage());
    }
}
