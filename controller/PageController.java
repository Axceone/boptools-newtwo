package com.baiwang.bophttpapi.controller;

import com.baiwang.bophttpapi.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* @Author: LiuGuobin
* @Description: 启动首页跳转
* @Date: 15:13 2017/12/20
*/
@Controller
public class PageController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String String(Constants constants){
        return "httl";
    }

}
