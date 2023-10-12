package com.camerinfolks.springboot.kafka;

import com.camerinfolks.springboot.controller.MessageController;
import com.camerinfolks.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User date){

        LOGGER.info(String.format("Message sent -> %s", date.toString()));

        Message<User> message = MessageBuilder
                .withPayload(date)
                .setHeader(KafkaHeaders.TOPIC,"topic_demo")
                .build();

        kafkaTemplate.send(message);
    }
}
