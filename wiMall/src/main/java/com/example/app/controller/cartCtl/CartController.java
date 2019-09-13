package com.example.app.controller.cartCtl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("cart/")
public class CartController {

    /**
     * 购物车详情
     */
    @RequestMapping("cartInfo.do")
    public void info(){

    }


}
