package com.magdaly.santos.meetup.models

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "meetup")
data class Meetup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    val reason: String? = null,
    val description: String? = null,
    val status : MeetupStatus = MeetupStatus.ACTIVED,
    val date: LocalDate = LocalDate.now(),
)

