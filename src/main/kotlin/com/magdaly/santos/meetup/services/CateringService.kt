package com.magdaly.santos.meetup.services

import com.magdaly.santos.meetup.models.CateringMeetup
import org.springframework.stereotype.Service

@Service
class CateringService(
    val meetupService: MeetupService,
    val participantService: ParticipantService,
    val temperatureService: TemperatureService
) {

    fun getCateringByMeet(id: Int): CateringMeetup {
        val meetup = meetupService.getById(id)
        val participantsByMeet = meetup.id?.let { participantService.getByMeetId(it).size }
        return CateringMeetup(
            0, participantsByMeet
        )
    }
}