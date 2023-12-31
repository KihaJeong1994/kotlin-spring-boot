package com.example.kotlinspringboot.controller

import com.example.kotlinspringboot.data.Message
import com.example.kotlinspringboot.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService){
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): List<Message> =
        service.findMessageById(id)

    @PostMapping("/")
    fun post(@RequestBody message: Message) = service.save(message)
}