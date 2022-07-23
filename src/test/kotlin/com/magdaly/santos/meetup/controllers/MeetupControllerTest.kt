package com.magdaly.santos.meetup.controllers


import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.models.MeetupStatus
import com.magdaly.santos.meetup.services.MeetupService
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class MeetupControllerTest (
    @Autowired val mockMvc: MockMvc
){
    @MockBean
    private lateinit var serviceMock: MeetupService

    private val meetupResponse = Meetup(
        id = 1,
        reason = "Hello World",
        description= "hello world description",
        status = MeetupStatus.ACTIVED
    )

    @Test
    fun `get meetup by id and return meetup`() {
       `when`(serviceMock.getById(any(Int::class.java))).thenReturn(meetupResponse)

        mockMvc.perform(get("/api/v1/meetup/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.reason").value("Hello World"))
    }

    @Test
    fun `create meetup and status created`() {
       `when`(serviceMock.save(any(Meetup::class.java))).thenReturn(meetupResponse)

        mockMvc.perform(post("/api/v1/meetup") .param("meetup", "Hello World"))
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.reason").value("Hello World"))
    }

 /*   @Test
    fun `get all meetup and return meetups`() {
        Mockito.`when`(serviceMock.getAll()).thenReturn(listOf(meetup))

        mockMvc.perform(get("/api/v1/meetup"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].text").value("Hello World"))
    }*/
}
