package com.faceyee.feignconsumer.service;

import com.faceyee.feignconsumer.domain.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Created by 97390 on 9/4/2018.
 */

/*这是我们消费者的服务，调用生产者 /articles，这是一个接口，无需实现，注意需要标注FeignClient，
其中写入name或value微服务生产者的application.properties配置
* */

/*当然，这里会直接耦合PengProducerService这个名称，我们以后可以通过配置服务器更改
* */
@FeignClient(name="PengProducerService")
@Controller // 配置为bean,才能注入控制器中外网访问,当然,如果这个服务是内部服务,只需在注册中心注册服务就行,不需要暴露给外网,
// 则不用添加此注解以及配置控制器
public interface ConsumerService {

    @GetMapping("/articles") // 访问PengProducerService负载平衡后的实例的/articles映射方法
    List<Article> getAllArticles();
}