package com.magdaly.santos.meetup.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.magdaly.santos.meetup.models.ParticipantMeetup
import com.magdaly.santos.meetup.services.ParticipantService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.io.IOException


@Service

class ConsumerMessage (
    val participantService: ParticipantService,
    val objectMapper: ObjectMapper
    ){
    private val logger: Logger = LoggerFactory.getLogger(ConsumerMessage::class.java)

    @KafkaListener(topics = ["meetups-events"])
    @Throws(IOException::class)
    fun consume(message: String?) {

        logger.info(String.format("#### -> Consumed message -> %s", message))
        participantService.save(objectMapper.readValue(message, ParticipantMeetup::class.java))
    }
}