package com.magdaly.santos.meetup.consumer

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException


@Service

class ConsumerMessage {
    private val logger: Logger = LoggerFactory.getLogger(ConsumerMessage::class.java)

    @KafkaListener(topics = ["meetups-events"])
    @Throws(IOException::class)
    fun consume(message: String?) {
        logger.info(String.format("#### -> Consumed message -> %s", message))
    }
}