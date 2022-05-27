package com.magdaly.santos.meetup.controllers


import com.magdaly.santos.meetup.models.Meetup
import com.magdaly.santos.meetup.services.MeetupService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
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

    private val meetup = Meetup("Hello World")

    @Test
    fun `get meetup by id and return meetup`() {
        Mockito.`when`(serviceMock.getById(1)).thenReturn(meetup)

        mockMvc.perform(get("/api/v1/meetup/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.text").value("Hello World"))
    }

    @Test
    fun `create meetup and status created`() {
        Mockito.`when`(serviceMock.save("Hello World")).thenReturn(meetup)

        mockMvc.perform(post("/api/v1/meetup") .param("meetup", "Hello World"))
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.text").value("Hello World"))
    }

    @Test
    fun `get all meetup and return meetups`() {
        Mockito.`when`(serviceMock.getAll()).thenReturn(listOf(meetup))

        mockMvc.perform(get("/api/v1/meetup"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].text").value("Hello World"))
    }
}
