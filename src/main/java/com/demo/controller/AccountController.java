package com.demo.controller;

import com.demo.entity.Account;
import com.demo.repository.AccountRepository;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Map> createAccount(@RequestBody Account account) {
        if (accountService.isAccountExist(account.getUsername()) && accountService.checkAccountFormat(account)) {
            accountService.save(account);
            return new ResponseEntity<>(Collections.singletonMap("success", true), HttpStatus.OK);
        }

        return new ResponseEntity<>(Collections.singletonMap("success", false), HttpStatus.OK);
    }

    @PutMapping("/validation")
    public ResponseEntity<Map> validateAccount(@RequestBody Account account) {
        if (accountService.validateAccount(account))
            return new ResponseEntity<>(Collections.singletonMap("success", true), HttpStatus.OK);
        return new ResponseEntity<>(Collections.singletonMap("success", false), HttpStatus.OK);
    }

}
