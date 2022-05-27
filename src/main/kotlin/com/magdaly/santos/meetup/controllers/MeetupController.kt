package com.magdaly.santos.meetup.controllers

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.services.MeetupService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/meetup")
class MeetupController(
    val service: MeetupService
) {
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id:Long) : ResponseEntity<Meetup> = ResponseEntity( service.getById(id), HttpStatus.OK)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestParam meetup:String ) = service.save(meetup)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll() : ResponseEntity<List<Meetup>> = ResponseEntity( null, HttpStatus.OK)

}