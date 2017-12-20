package com.baiwang.bophttpapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baiwang.bophttpapi.common.Constants;
import com.baiwang.bophttpapi.service.InterfaceDebugService;
import com.baiwang.bophttpapi.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @Author: LiuGuobin
* @Description: 开放平台在线接口调试工具
* @Date: 15:12 2017/12/20
*/
@RestController
public class InterfaceDebugController {

    @Autowired
    private InterfaceDebugService interfaceDebugService;

    /**
    * @Author: LiuGuobin
    * @Description: Controller层
    * @Date: 15:11 2017/12/20
    */
    @RequestMapping(value = "/check",method = RequestMethod.POST )
    public ResultMsg check(@RequestBody Constants constants){
        String data = interfaceDebugService.dataProcess(constants);
        if(data!=null){
            JSONObject object = JSONObject.parseObject(data);
            return ResultMsg.ok(object);
        }
        return ResultMsg.build(500,"业务返回数据有误，请检查输入项！",null);
    }

}
