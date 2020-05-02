package com.example.demo.service

import com.example.demo.repository.PersistentAccount
import org.springframework.stereotype.Service

@Service
class BalanceService {

    fun increase(persistentAccount: PersistentAccount, amount: Double): Double {
        return persistentAccount.balance + amount
    }

    fun withdraw(persistentAccount: PersistentAccount, amount: Double): Double {
        return persistentAccount.balance - amount
    }
}