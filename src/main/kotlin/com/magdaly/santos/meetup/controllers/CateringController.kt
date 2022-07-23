package com.magdaly.santos.meetup.controllers

import com.magdaly.santos.meetup.models.CateringMeetup
import com.magdaly.santos.meetup.services.CateringService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CateringController (
    val service : CateringService
    ) {

    @GetMapping("/meet/{id}/catering")
    @ResponseStatus(HttpStatus.OK)
    fun getCateringByMeet(@PathVariable id: Int): ResponseEntity<CateringMeetup> =
        ResponseEntity(service.getCateringByMeet(id), HttpStatus.OK)
}