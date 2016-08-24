package com.github.yingzhuo.kuruma.user.controller

import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.common.exception.BadRequestException
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
open class ExceptionHandlers {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ExceptionHandlers::class.java)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    open fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<Json> {

        val messages =
                if (ex.message != null)
                    arrayOf(ex.message!!)
                else
                    arrayOf()

        LOGGER.debug("messages: {}", messages)

        return Json.create(HttpStatus.NOT_FOUND, messages).asResponseEntity()
    }

    @ExceptionHandler(BadRequestException::class)
    open fun handleBadRequestException(ex: BadRequestException): ResponseEntity<Json> {

        val messages =
                if (ex.message != null)
                    arrayOf(ex.message!!)
                else
                    arrayOf()

        LOGGER.debug("messages: {}", messages)

        return Json.create(HttpStatus.BAD_REQUEST, messages).asResponseEntity()
    }

}