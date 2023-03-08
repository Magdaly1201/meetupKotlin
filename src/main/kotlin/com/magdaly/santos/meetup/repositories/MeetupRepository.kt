package com.magdaly.santos.meetup.repositories

import com.magdaly.santos.meetup.models.Meetup
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface MeetupRepository : CrudRepository<Meetup, Int> {

}