package com.example.demo.service

import com.example.demo.repository.PersistentAccount
import org.springframework.stereotype.Service

@Service
class BalanceService {

    fun increase(persistentAccount: PersistentAccount, amount: Double): Double {
        return persistentAccount.balance + amount + (amount * 0.005)
    }

    fun withdraw(persistentAccount: PersistentAccount, amount: Double): Double {
        val newBalance = persistentAccount.balance - amount
        if (newBalance < 0) throw BalanceOutException("New balance $newBalance is less than 0!")
        return newBalance
    }
}

class BalanceOutException(override val message: String?) : Exception(message)