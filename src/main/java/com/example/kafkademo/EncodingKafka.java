package com.example.kafkademo;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class EncodingKafka implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return BeanUtils.bean2Byte(data);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        return BeanUtils.bean2Byte(data);
    }

    @Override
    public void close() {

    }
}
