package com.example.demo.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : ReactiveMongoRepository<PersistentAccount, String> {
}