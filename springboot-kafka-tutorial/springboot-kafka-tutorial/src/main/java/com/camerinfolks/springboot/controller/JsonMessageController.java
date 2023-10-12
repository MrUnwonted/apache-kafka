package com.camerinfolks.springboot.controller;

import com.camerinfolks.springboot.kafka.JsonKafkaProducer;
import com.camerinfolks.springboot.kafka.KafkaProducer;
import com.camerinfolks.springboot.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
       return ResponseEntity.ok("Json message sent to Kafka topic");
    }
}
