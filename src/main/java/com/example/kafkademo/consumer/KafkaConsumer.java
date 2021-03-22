package com.example.kafkademo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"topic1"})
    public void onMessageTopic1(ConsumerRecord record){
        log.info("topic: " + record.topic());
//        log.info("partition:" + record.partition());
//        log.info(record.offset()+"");
        log.info("value: " + record.value());
//        System.out.println("topic: " + record.topic());
//        System.out.println("value" + record.value());
//        System.out.println("header:" + record.headers());
    }

    @KafkaListener(topics = {"topic2"})
    public void onMessageTopic2(ConsumerRecord record){
        log.info("topic: " + record.topic());
//        log.info("partition:" + record.partition());
//        log.info(record.offset()+"");
        log.info("value" + record.value());
//        System.out.println("topic: " + record.topic());
//        System.out.println("value: " + record.value());
//        System.out.println("header: " + record.headers());
    }

}
