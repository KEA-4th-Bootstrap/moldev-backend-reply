package org.bootstrap.reply.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, UpdateMessageDto> kafkaTemplate;

    public void send(String topic, UpdateMessageDto payload) {
        log.info("sending payload={} to topic={}", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
