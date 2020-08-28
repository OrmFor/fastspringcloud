package com.springcloud.fast.fastspringcloud.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.springcloud.fast.fastspringcloud.CommonResult;
import com.springcloud.fast.fastspringcloud.controller.base.BaseController;
import com.springcloud.fast.fastspringcloud.pojo.WxConfig;
import com.springcloud.fast.fastspringcloud.service.IWxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController("WxConfigController")
@RequestMapping("/wxConfig")
public class ConfigController extends BaseController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private IWxConfig wxConfigService;

    @RequestMapping(value = "/add",method=RequestMethod.POST)
    public CommonResult add() {
        JSONObject json = getJsonFromRequest();
        Integer id = json.getInteger("id");
        HashMap<String, Object> data = Maps.newHashMap();
        WxConfig bean = new WxConfig();
        bean.setAppId("123213");
        bean.setCertString("safsafas");
        bean.setKey("xsfsf");
        bean.setMchId("123213131");
        wxConfigService.insert(bean);

        return new CommonResult(200,"success");
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult list(){
        WxConfig condi = new WxConfig();
        condi.setOrderBy(" id desc");
        List<WxConfig> list = wxConfigService.getList(condi);
        System.out.println("server.port"+serverPort);

        return new CommonResult(200,String.valueOf(serverPort),list);
    }
    
}