package com.springcloud.fast.fastspringcloud.repsitory;


import com.alibaba.fastjson.JSON;
import com.springcloud.fast.fastspringcloud.redis.CacheHelper;
import com.springcloud.fast.fastspringcloud.vo.GatewayDefine;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyRouteDefinitionRepository implements RouteDefinitionRepository {

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        try {
            //从redis获取数据
            /**
             * 这里是否需要锁来限制并发？
             */
            List<GatewayDefine> gatewayDefineList = JSON.parseArray(CacheHelper.getCache("gateway_routes").toString(),GatewayDefine.class);
            System.out.println("===================路由数据===========================");
            System.out.println(gatewayDefineList.toString());
            System.out.println("===================路由数据===========================");
            Map<String, RouteDefinition> routes = new LinkedHashMap<String, RouteDefinition>();
            for (GatewayDefine gatewayDefine: gatewayDefineList) {
                RouteDefinition definition = new RouteDefinition();
                definition.setId(gatewayDefine.getId());
                definition.setUri(new URI(gatewayDefine.getUri()));
                List<PredicateDefinition> predicateDefinitions =
                        gatewayDefine.getPredicateDefinition();
                if (predicateDefinitions != null) {
                    definition.setPredicates(predicateDefinitions);
                }
                List<FilterDefinition> filterDefinitions = gatewayDefine.getFilterDefinition();
                if (filterDefinitions != null) {
                    definition.setFilters(filterDefinitions);
                }
                routes.put(definition.getId(), definition);
            }
            return Flux.fromIterable(routes.values());
        } catch (Exception e) {
            e.printStackTrace();
            return Flux.empty();
        }
    }


    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
       return null;
    }

//    public static void main(String[] args) {
//        //生成路由json 数据
//        PredicateDefinition predicate = new PredicateDefinition();
//        predicate.setName("Path");
//
//        Map<String, String> predicateParams = new HashMap<>(8);
//        predicateParams.put("pattern", "/order/**");
//        predicate.setArgs(predicateParams);
//
//        FilterDefinition filter = new FilterDefinition();
//        filter.setName("StripPrefix");
//        Map<String, String> filterParams = new HashMap<>(8);
//        filterParams.put("_genkey_0", "1");
//        filter.setArgs(filterParams);
//
//
//        /**
//        *           - name: RequestRateLimiter
//         *             args:
//         *               # 令牌桶每秒填充平均速率,即行等价于允许用户每秒处理多少个请求平均数
//         *               redis-rate-limiter.replenishRate: 10
//         *               # 令牌桶的容量，允许在一秒钟内完成的最大请求数
//         *               redis-rate-limiter.burstCapacity: 20
//         *               # 用于限流的键的解析器的 Bean 对象的名字。它使用 SpEL 表达式根据#{@beanName}从 Spring 容器中获取 Bean 对象。
//         *               key-resolver: "#{@apiKeyResolver}"
//        **/
//        FilterDefinition filter2 = new FilterDefinition();
//        filter2.setName("RequestRateLimiter");
//        Map<String,String> filter2Params = new HashMap<>(8);
//        filter2Params.put("redis-rate-limiter.replenishRate","10");
//        filter2Params.put("redis-rate-limiter.burstCapacity","20");
//        filter2Params.put("key-resolver","#{@apiKeyResolver}");
//
//        filter2.setArgs(filter2Params);
//        List ss = new ArrayList();
//        ss.add(filter2);
//        ss.add(filter);
//
//        System.out.println(JSON.toJSONString(predicate));
//        System.out.println(JSON.toJSONString(ss));
//     //   System.out.println(JSON.toJSONString(filter2));
//    }

}
