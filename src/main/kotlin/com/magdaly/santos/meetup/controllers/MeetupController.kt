package com.magdaly.santos.meetup.controllers

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.MeetupRequest
import com.magdaly.santos.meetup.services.MeetupService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1/meetup")
class MeetupController(
    val service: MeetupService
) {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id:Integer) : ResponseEntity<Meetup> = ResponseEntity( service.getById(id), HttpStatus.OK)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@Valid @RequestBody meetupRequest:MeetupRequest ) = service.save(Meetup(
        reason = meetupRequest.reason,
        description = meetupRequest.description
    ))

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() : ResponseEntity<List<Meetup>> = ResponseEntity( null, HttpStatus.OK)

}