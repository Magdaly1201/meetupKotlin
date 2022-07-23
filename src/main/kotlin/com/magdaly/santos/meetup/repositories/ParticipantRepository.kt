package com.magdaly.santos.meetup.repositories

import com.magdaly.santos.meetup.models.ParticipantMeetup
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ParticipantRepository : CrudRepository<ParticipantMeetup, Int>{

     fun findAllByMeetId(meetId: Int) : List<ParticipantMeetup>

}