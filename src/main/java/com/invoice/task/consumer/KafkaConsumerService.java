package com.invoice.task.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "request_logs", groupId = "log_group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Received Log: " + record.value());
    }
}