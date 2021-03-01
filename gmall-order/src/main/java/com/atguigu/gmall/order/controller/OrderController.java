package com.atguigu.gmall.order.controller;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.oms.vo.OrderSubmitVo;
import com.atguigu.gmall.order.feign.GmallUmsClient;
import com.atguigu.gmall.order.pojo.OrderConfirmVo;
import com.atguigu.gmall.order.service.OrderService;
import com.atguigu.gmall.ums.entity.UserAddressEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GmallUmsClient umsClient;

    @GetMapping("confirm")
    public String confirm(Model model){
        OrderConfirmVo confirmVo = this.orderService.confirm();
        model.addAttribute("confirmVo",confirmVo);
        return "trade";
    }

    @PostMapping("submit")
    @ResponseBody
    public ResponseVo<String> submit(@RequestBody OrderSubmitVo submitVo){
        this.orderService.submit(submitVo);
        return ResponseVo.ok(submitVo.getOrderToken());
    }

//    @GetMapping("test/user/add/{userId}")
//    @ResponseBody
//    public ResponseVo<List<UserAddressEntity>> queryAddressesByUserId(@PathVariable("userId")Long userId){
//        ResponseVo<List<UserAddressEntity>> listResponseVo = this.umsClient.queryAddressesByUserId(userId);
//        List<UserAddressEntity> data = listResponseVo.getData();
//        return ResponseVo.ok(data);
//    }
}
