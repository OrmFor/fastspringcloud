package com.springcloud.fast.fastspringcloud.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.fast.fastspringcloud.CommonResult;


//fallback：fallback 函数名称，可选项，用于在抛出异常的时候提供 fallback 处理逻辑。fallback 函数可以针对所有类型的异常（除了 - exceptionsToIgnore 里面排除掉的异常类型）进行处理。fallback 函数签名和位置要求：
//        返回值类型必须与原函数返回值类型一致；
//        方法参数列表需要和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常。
//        fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
public class CustomerFallback {

    public static CommonResult consumerFallBack(BlockException exception) {
        return new CommonResult(200, "自定义降级处理信息....CustomerBlockHandler");

    }
}
