package com.springcloud.fast.fastspringcloud.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.fast.fastspringcloud.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(200, "自定义限流处理信息....CustomerBlockHandler");

    }
}
