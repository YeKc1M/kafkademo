package com.example.kafkademo.controller;

import com.example.kafkademo.Inner;
import com.example.kafkademo.Outer;
import com.example.kafkademo.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void sendMsg(String topic, String msg){
        kafkaProducer.sendMessage(topic, msg);
    }

    @GetMapping("/transaction")
    public void sendTran(){
        kafkaProducer.sendTransaction();
    }

    @GetMapping("/obj")
    public void sendObj(){
        Outer outer = new Outer();
        outer.id = 1;
        outer.inner = new Inner();
        outer.inner.id = 1;
        outer.inner.msg = "msg";
        kafkaProducer.sendOuter(outer);
    }

}
