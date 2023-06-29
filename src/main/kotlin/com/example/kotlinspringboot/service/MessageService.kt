package com.example.kotlinspringboot.service

import com.example.kotlinspringboot.data.Message
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageService(val db : JdbcTemplate){
    fun findMessages():List<Message> = db.query("SELECT * FROM messages"){
        response,_ ->
        Message(response.getString("id"), response.getString("text"))
    }

    fun findMessageById(id: String): List<Message> = db.query("select * from messages where id = ?", id) { response, _ ->
        Message(response.getString("id"), response.getString("text"))
    }


    fun save(message: Message){
        val id = message.id ?: UUID.randomUUID().toString()
        db.update("INSERT INTO messages values (?,?)",id, message.text)
    }
}