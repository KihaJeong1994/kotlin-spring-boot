package com.example.kotlinspringboot.repository;

import com.example.kotlinspringboot.data.Message
import org.springframework.data.repository.CrudRepository


interface MessageRepository : CrudRepository<Message, String>
