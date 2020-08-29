1.cloud-dependency maven版本控制  pom
2.cloud-commons
       - cloud-common-domain  核心业务逻辑层
       - cloud-core  微服务返回内容封装
3.cloud-business-gateway 网关服务  最外层 可在数据库中存储,redis缓存动态获取网关,不适合用sentinel限流,只做转发功能
4.cloud-front-consumer-feign  feign客户端+nacos+sentinel,限流 降级
5.cloud-business-provider  服务提供者,对feign暴露接口