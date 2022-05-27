package com.magdaly.santos.meetup.services

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.repositories.MeetupRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean

@WebMvcTest(MeetupService::class)
internal class MeetupServiceTest(

){
    @MockBean
    lateinit var repository: MeetupRepository

    @Autowired
    lateinit var service: MeetupService

    private val meetup = Meetup("Hello World")

    @Test
    fun `get all and return meetups`(){
        Mockito.`when`(repository.getAll()).thenReturn(listOf(Meetup("Hello World")))

        val result = service.getAll()
        assertEquals(meetup.text, result[0].text)
    }

    @Test
    fun `get meetup by id and return meetup`(){
        Mockito.`when`(repository.getById(1)).thenReturn(Meetup("Hello World"))

        val result = service.getById(1)
        assertEquals(meetup.text, result.text)
    }

    @Test
    fun `create meetup and return meetup`(){
        Mockito.`when`(repository.save("Hello World")).thenReturn(Meetup("Hello World"))

        val result = service.save("Hello World")
        assertEquals(meetup.text, result.text)
    }
}