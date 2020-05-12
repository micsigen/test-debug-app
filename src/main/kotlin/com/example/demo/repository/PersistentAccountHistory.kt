package com.example.demo.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class PersistentAccountHistory(
        @Id val id: String? = null,
        val accountId: String,
        var amount: Double,
        var oldBalance: Double,
        var newBalance: Double
)