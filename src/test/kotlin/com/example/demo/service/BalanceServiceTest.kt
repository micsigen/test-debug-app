package com.example.demo.service

import com.example.demo.repository.PersistentAccount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
        // given
        val persistentAccount: PersistentAccount = PersistentAccount("1", "John", 1500.0)
        val amount: Double = 100.0
        // when
        val newBalance: Double = balanceService.withdraw(persistentAccount, amount)
        // then
        Assertions.assertEquals(1400.0, newBalance)
    }

    @Test
    fun testWithdrawNoBalance() {
        // given
        val persistentAccount: PersistentAccount = PersistentAccount("1", "John", 1500.0)
        val amount: Double = 1600.0
        // when // then
        val exception: BalanceOutException = assertThrows<BalanceOutException>{
            balanceService.withdraw(persistentAccount, amount)
        }
        Assertions.assertEquals("New balance -100.0 is less than 0!", exception.message)
    }
}