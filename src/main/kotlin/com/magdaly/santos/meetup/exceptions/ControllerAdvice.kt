package com.magdaly.santos.meetup.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.stream.Collectors


@ControllerAdvice
class ControllerAdviceExceptions : ResponseEntityExceptionHandler() {

    @ExceptionHandler(MeetupNotFoundException::class)
    @ResponseBody
    fun meetupNotFoundException(ex: MeetupNotFoundException): ResponseEntity<Map<String, Any>>? {
        val response: MutableMap<String, Any> = HashMap()
        val className = ex.stackTrace[0].className
        val line = ex.stackTrace[0].lineNumber
        logger.error("Exception: " + ex.MESSAGE + " - Class: " + className.toString() + " - line: " + line)
        response["errors"] = ex.MESSAGE
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @Override
    @ResponseBody
    fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>>? {
        val response: MutableMap<String, Any> = HashMap()
        if (ex.bindingResult.hasErrors()) {
            val errors = ex.bindingResult.fieldErrors.stream()
                .map { err: FieldError -> "El campo  : '" + err.field + "' " + err.defaultMessage }
                .collect(Collectors.toList())
            response["errors"] = errors
        }
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

}