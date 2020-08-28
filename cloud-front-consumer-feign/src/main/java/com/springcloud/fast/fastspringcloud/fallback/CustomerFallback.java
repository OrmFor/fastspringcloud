package com.springcloud.fast.fastspringcloud.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.fast.fastspringcloud.CommonResult;

public class CustomerFallback {

    public static CommonResult fallBack(BlockException exception) {
        return new CommonResult(200, "自定义降级处理信息....CustomerBlockHandler");

    }
}
