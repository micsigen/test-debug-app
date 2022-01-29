package com.example.demo.service

import com.example.demo.controller.Account
import com.example.demo.controller.AccountHistory
import com.example.demo.repository.AccountHistoryRepository
import com.example.demo.repository.AccountRepository
import com.example.demo.repository.PersistentAccount
import com.example.demo.repository.PersistentAccountHistory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val accountHistoryRepository: AccountHistoryRepository,
    private val balanceService: BalanceService
) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun deposit(accountHistory: AccountHistory) {
        val persistentAccount: PersistentAccount? = accountRepository.findById(accountHistory.id).block()
        logger.info("---------Increase process started-----------")
        logger.info("Current Bank account: {}", persistentAccount)

        // Call business logic
        val newBalance: Double = balanceService.increase(persistentAccount!!, accountHistory.amount)

        val persistentAccountHistory: PersistentAccountHistory = PersistentAccountHistory(null, persistentAccount.id!!, accountHistory.amount, persistentAccount.balance, newBalance)
        accountHistoryRepository.save(persistentAccountHistory)
                .subscribe()

        accountRepository.deleteById(persistentAccount.id!!)
        accountRepository.save(PersistentAccount(persistentAccount.id!!, persistentAccount.name, newBalance))
                .doOnSuccess {
                    logger.info("Bank account saved with new balance: {}", it)
                }
                .doOnError {
                    logger.error(it.localizedMessage)
                }
                .subscribe()
    }

    fun withdraw(accountHistory: AccountHistory) {
        val persistentAccount: PersistentAccount? = accountRepository.findById(accountHistory.id).block()
        logger.info("---------Withdraw process started-----------")
        logger.info("Bank account: {}", persistentAccount)

        val newBalance: Double = balanceService.withdraw(persistentAccount!!, accountHistory.amount)

        val persistentAccountHistory: PersistentAccountHistory = PersistentAccountHistory(null, persistentAccount.id!!, accountHistory.amount, persistentAccount.balance, newBalance)
        accountHistoryRepository.save(persistentAccountHistory)
                .subscribe()

        accountRepository.deleteById(persistentAccount.id!!)
        accountRepository.save(PersistentAccount(persistentAccount.id, persistentAccount.name, newBalance))
                .doOnSuccess {
                    logger.info("Bank account saved with new balance: {}", it)
                }
                .doOnError {
                    logger.error(it.localizedMessage)
                }
                .subscribe()
    }

    fun findById(id: String): Account {
        val persistentAccount: PersistentAccount? = accountRepository.findById(id).block()
        return Account(persistentAccount!!.id!!, persistentAccount!!.name, persistentAccount!!.balance)
    }

    fun put(account: Account) {
        accountRepository.save(PersistentAccount(account.id, account.name, account.balance))
                .doOnSuccess {
                    logger.info("Bank account saved: {}", it)
                }
                .doOnError {
                    logger.error(it.localizedMessage)
                }
                .subscribe()
    }


}