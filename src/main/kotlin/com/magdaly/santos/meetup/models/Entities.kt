package com.magdaly.santos.meetup.models

import java.math.BigInteger
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "meetup")
data class Meetup(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Integer? = null,
    val reason: String? = null,
    val description: String? = null,
    val status : MeetupStatus = MeetupStatus.ACTIVED,
    val date: LocalDate = LocalDate.now(),
)

@Entity
@Table(name = "participant_meetup")
class ParticipantMeetup (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Integer? = null,
    @Column(nullable = false) var username: String? = null,
    @Column(nullable = false) var email: String? = null,
    @Column(nullable = false, name = "created_at") var createdAt: LocalDate? = null,
    @Column(nullable = false, name = "meet_id") var meetId: Integer? = null,

)

