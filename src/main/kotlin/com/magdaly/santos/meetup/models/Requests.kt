package com.magdaly.santos.meetup.models

import java.time.LocalDate
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class MeetupRequest(
    val reason: String = "",
    val description: String = "",
)