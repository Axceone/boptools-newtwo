package com.baiwang.bophttpapi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baiwang.bophttpapi.common.Constants;
import com.baiwang.bophttpapi.service.InterfaceDebugService;
import com.baiwang.bophttpapi.util.HttpClientUtil;
import com.baiwang.bophttpapi.util.ToolUtil;
import org.springframework.stereotype.Service;


@Service
public class InterfaceDebugServiceImpl implements InterfaceDebugService{

    /**
    * @Author: LiuGuobin
    * @Description: 业务层，后台数据处理
    * @Date: 15:14 2017/12/20
    */
    @Override
    public String dataProcess(Constants constants) {

        String tokenURL = ToolUtil.getTokenRequestURL(constants.getAppKey(),constants.getAppSecret(),constants.getUserName(),
                constants.getPassword(),constants.getUserSalt(),constants.getUrl());
        try{
            String rtnTokenData = HttpClientUtil.doPostJson(tokenURL,"");
            JSONObject object = JSONObject.parseObject(rtnTokenData);
            JSONObject responseObject = object.getJSONObject("response");

            /**
             * 获取请求路径,发送请求数据
             */
            String token= responseObject.getString("access_token");
            String requestURL = ToolUtil.getAPIRequestURL( constants.getUrl(), constants.getApiName(), constants.getAppKey(), constants.getAppSecret(), token, constants.getBody());
            String doPost = HttpClientUtil.doPostJson(requestURL, constants.getBody());
            return doPost;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
