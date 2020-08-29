package com.springcloud.fast.fastspringcloud.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.fast.fastspringcloud.CommonResult;


/**
* @Author wwy
fallback：失败调用，若本接口出现未知异常，则调用fallback指定的接口。
blockHandler：sentinel定义的失败调用或限制调用，若本次访问被限流或服务降级，则调用blockHandler指定的接口。
**/
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(200, "自定义限流处理信息....CustomerBlockHandler");

    }
}
