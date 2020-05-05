package com.example.demo.controller

import com.example.demo.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(
        val accountService: AccountService
) {
    @PostMapping("/increase")
    fun increase(@RequestBody accountHistory: AccountHistory) {
        accountService.increase(accountHistory)
    }

    @PostMapping("/withdraw")
    fun withdraw(@RequestBody accountHistory: AccountHistory) {
        accountService.withdraw(accountHistory)
    }

    @GetMapping("/{id}")
    fun account(@PathVariable id: String): Account {
        return accountService.findById(id)
    }

    @PutMapping()
    fun put(@RequestBody account: Account) {
        accountService.put(account)
    }
}