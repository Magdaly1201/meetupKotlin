package com.magdaly.santos.meetup.services

import com.magdaly.santos.meetup.exceptions.MeetupNotFoundException
import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.MeetupStatus
import com.magdaly.santos.meetup.repositories.MeetupRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class MeetupService (
    val repository: MeetupRepository
){
    fun save(meetup:Meetup)= repository.save(Meetup(id=1, reason="HOLA",description = "Hola",status = MeetupStatus.ACTIVED,date = LocalDate.now()))

    fun getById(id:Long):Meetup = repository.findById(id).orElseThrow { MeetupNotFoundException() }

}