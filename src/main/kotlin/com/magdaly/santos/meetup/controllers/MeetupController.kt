package com.magdaly.santos.meetup.controllers

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.MeetupRequest
import com.magdaly.santos.meetup.services.MeetupService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1/meetup")
class MeetupController(
    val service: MeetupService
) {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Int): ResponseEntity<Meetup> = ResponseEntity(service.getById(id), HttpStatus.OK)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@Valid @RequestBody meetupRequest: MeetupRequest) = service.save(
        Meetup(
            reason = meetupRequest.reason,
            description = meetupRequest.description
        )
    )

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): ResponseEntity<List<Meetup>> = ResponseEntity(service.getAll(), HttpStatus.OK)

}