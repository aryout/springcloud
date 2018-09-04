package com.faceyee.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 97390 on 9/4/2018.
 */
@SpringBootApplication
public class ConsumerApplication {

    /*RestTemplate则是使用Ribbon的负载平衡策略，使用@LoadBalanced注释resttemplate并使用zuul代理服务器作为边缘服务器。
    那么对zuul边缘服务器的任何请求将默认使用Ribbon进行负载平衡，而resttemplate将以循环方式路由请求。
    * */
    @Bean
    @LoadBalanced // 通过调用RestTemplate对象实际就是获得负载平衡后的服务实例
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext ctx  =  SpringApplication.run(ConsumerApplication
                .class, args);
        ConsumerService consumerService = ctx.getBean(ConsumerService.class); // 实例化一个bean实例

        // 连续5次调用生产者，这边的consumerService是全局唯一的有状态bean，它的状态即RestTemplate是值变化的，经过@LoadBalanced
        // 得到的不同的生产者实例[服务级别，而不是线程级别，同一个服务跑在多个容器上形成多个实例]
        for (int i = 0; i < 5; i++) {
            System.out.printf(" final result RestTemplate = " + consumerService
                    .callProducer() + " \n");
        }
    }

    // 如果系统基于https进行负载平衡，那么只需要两个步骤：ribbon.IsSecure=true
/*    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() { // 代码中RestTemplate初始化时传入ClientHttpRequestFactory对象
        CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
        HttpComponentsClientHttpRequestFactory clientrequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientrequestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(clientrequestFactory);
        return restTemplate;
    }*/
}