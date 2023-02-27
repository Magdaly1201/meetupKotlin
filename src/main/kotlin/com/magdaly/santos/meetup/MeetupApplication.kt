package com.magdaly.santos.meetup

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MeetupApplication

fun main(args: Array<String>) {
	runApplication<MeetupApplication>(*args)
}
