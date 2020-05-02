package com.example.demo.service

import com.example.demo.repository.PersistentAccount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BalanceServiceTest {

    private val balanceService: BalanceService = BalanceService()

    @Test
    fun testIncrease() {
        // given
        val persistentAccount: PersistentAccount = PersistentAccount("1", "John", 1500.0)
        val amount: Double = 100.0
        // when
        val newBalance: Double = balanceService.increase(persistentAccount, amount)
        // then
        Assertions.assertEquals(1600.0, newBalance)
    }

    @Test
    fun testWithdraw() {

    }
}