package com.example.demo.controller

import com.example.demo.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/account")
class AccountController(
    val accountService: AccountService
) {
    @PostMapping("/deposit")
    fun deposit(@RequestBody accountHistory: AccountHistory) {
        try {
            accountService.deposit(accountHistory)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestBody accountHistory: AccountHistory) {
        try {
            accountService.withdraw(accountHistory)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{id}")
    fun account(@PathVariable id: String): ResponseEntity<Account> {
        try {
            return ResponseEntity(accountService.findById(id), HttpStatus.OK)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }

    @PutMapping()
    fun put(@RequestBody account: Account) {
        accountService.put(account)
    }
}