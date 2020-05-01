package com.example.demo.service

import com.example.demo.controller.Account
import com.example.demo.controller.AccountHistory
import com.example.demo.repository.AccountRepository
import com.example.demo.repository.PersistentAccount
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountService(
        private val accountRepository: AccountRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun increase(accountHistory: AccountHistory) {
        val persistentAccount: PersistentAccount? = accountRepository.findById(accountHistory.id).block()
        logger.info("Bank account: {}", persistentAccount)

        persistentAccount!!.balance += accountHistory.amount
        accountRepository.insert(persistentAccount!!).doOnSuccess {
            logger.info("Account with new balance: {}", it)
        }.onErrorResume {

        }.subscribe()
    }

    fun withdraw(accountHistory: AccountHistory) {
        val persistentAccount: PersistentAccount? = accountRepository.findById(accountHistory.id).block()
        logger.info("Bank account: {}", persistentAccount)

        persistentAccount!!.balance -= accountHistory.amount
        logger.info("Account with new balance: {}", persistentAccount)

        accountRepository.save(persistentAccount!!)
    }

    fun findById(id: String): Account {
        val persistentAccount: PersistentAccount? = accountRepository.findById(id).block()
        return Account(persistentAccount!!.id!!, persistentAccount!!.name, persistentAccount!!.balance)
    }

    fun put(account: Account) {
        val persistentAccount: PersistentAccount? = accountRepository.save(PersistentAccount(account.id, account.name, account.balance)).block()
        logger.info("Bank account saved: {}", persistentAccount)
    }


}