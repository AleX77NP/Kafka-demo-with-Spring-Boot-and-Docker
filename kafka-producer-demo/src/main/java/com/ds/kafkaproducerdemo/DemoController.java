package com.ds.kafkaproducerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, Product> template;

    private static final String TOPIC = "DemoTopic";

    @PostMapping("/publish")
    public String publishProduct(@RequestBody Product product) {
        template.send(TOPIC, product);
        return "Product published!";
    }
}
