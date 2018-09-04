package com.faceyee.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 97390 on 9/4/2018.
 */
@Controller
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    public String callProducer() {
        ResponseEntity<String> result =
                this.restTemplate.getForEntity(
                        // 调用了服务生产者ID为PengProducerService的接口方法pengproducer
                        "http://PengProducerService/pengproducer",
                        String.class,
                        "");
        if (result.getStatusCode() == HttpStatus.OK) {
            System.out.printf(result.getBody() + " called in callProducer");
            return result.getBody();
        } else {
            System.out.printf(" is it empty");
            return " empty ";
        }
    }
}