package com.magdaly.santos.meetup.services

import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.MeetupStatus
import com.magdaly.santos.meetup.repositories.MeetupRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate
import java.util.*


@WebMvcTest(MeetupService::class)
internal class MeetupServiceTest(

){
    @MockBean
    lateinit var mockRepository: MeetupRepository

    @Autowired
    lateinit var service: MeetupService

    private val meetup =  Meetup(
        id = 1,
        reason = "Hello World",
        description= "hello world description",
        status = MeetupStatus.ACTIVED,
        date = LocalDate.now()
    )

/*
    @Test
    fun `get all and return meetups`(){
        Mockito.`when`(repository.getAll()).thenReturn(listOf(Meetup("Hello World")))

        val result = service.getAll()
        assertEquals(meetup.text, result[0].text)
    }
*/
    @Test
    fun `get meetup by id and return meetup`(){
       `when`(mockRepository.findById(any(Long::class.java))).thenReturn(Optional.of(meetup))

        val result = service.getById(1)
        assertEquals(1, result.id)
    }

    @Test
    fun `create meetup and return meetup`(){
        `when`(mockRepository.save(any(Meetup::class.java))).thenReturn(meetup)

        val result = service.save(meetup)
        assertEquals(1L, result.id)
    }
}