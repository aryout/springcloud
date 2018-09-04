package com.faceyee;

import com.faceyee.feignconsumer.service.ConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class FeignconsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FeignconsumerApplication
				.class, args);
		ConsumerService consumerService = context.getBean(ConsumerService
				.class);
		System.out.printf("all articles ok: " + consumerService
				.getAllArticles()+"\n");
	}
}
