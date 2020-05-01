package com.example.demo.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PersistentAccount(
        @Id val id: String? = null,
        val name: String,
        var balance: Double
)