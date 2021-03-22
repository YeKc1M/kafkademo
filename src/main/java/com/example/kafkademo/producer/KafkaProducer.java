package com.example.kafkademo.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, String msg) {
        kafkaTemplate.send(topic, msg).addCallback(success -> {
            log.info(success.getRecordMetadata().topic());
            log.info(success.getRecordMetadata().offset() + "");
            log.info(success.getRecordMetadata().partition() + "");
        }, failure -> {
            log.info("send fail");
            log.info(failure.getMessage());
        });
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void sendTransaction(){
        kafkaTemplate.send("topic1", "topic1 outside transaction");
        kafkaTemplate.send("topic2", "topic2 outside transaction");
        throw new RuntimeException("outside transaction");
    }

    public void sendTransaction2(){
        //java.lang.IllegalStateException: Producer factory does not support transactions
        kafkaTemplate.executeInTransaction(operations -> {
           operations.send("topic1", "topic1 in transaction");
           operations.send("topic2", "topic2 in transaction");
           return "success";
//           throw new RuntimeException("transaction exception");
        });
    }

}
