package com.magdaly.santos.meetup.services

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.ParticipantMeetup
import com.magdaly.santos.meetup.repositories.ParticipantRepository
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    val repository: ParticipantRepository
) {

    fun save(participantMeetup: ParticipantMeetup)= repository.save(participantMeetup)

}