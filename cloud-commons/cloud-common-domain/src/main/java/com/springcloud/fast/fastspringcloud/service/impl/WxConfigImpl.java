package com.springcloud.fast.fastspringcloud.service.impl;

import com.springcloud.fast.fastspringcloud.dao.WxConfigMapper;
import com.springcloud.fast.fastspringcloud.pojo.WxConfig;
import com.springcloud.fast.fastspringcloud.service.IWxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cc.s2m.web.utils.webUtils.service.BaseServiceImpl;

@Service
public class WxConfigImpl extends BaseServiceImpl<WxConfig, WxConfigMapper, Integer> implements IWxConfig {
    @Autowired
    private WxConfigMapper wxConfigMapper;

    protected WxConfigMapper getDao() {
        return wxConfigMapper;
    }
}