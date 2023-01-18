package com.demo.service;

import com.demo.entity.Account;
import com.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public boolean isAccountExist(String username) {
        Optional<Account> account = accountRepository.findByUsername(username);
        if (account.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkAccountFormat(Account account) {
        if (!checkUsernameFormat(account.getUsername()))
            return false;
        if (!checkPasswordFormat(account.getPassword()))
            return false;
        return true;
    }

    private boolean checkUsernameFormat(String username) {
        Pattern REX = Pattern.compile("^[A-Za-z1-9]{3,32}$");
        Matcher matcher = REX.matcher(username);
        if (matcher.find())
            return true;
        return false;
    }

    private boolean checkPasswordFormat(String password) {
        Pattern[] inputRegexes = new Pattern[4];
        inputRegexes[0] = Pattern.compile(".*[A-Z].*");
        inputRegexes[1] = Pattern.compile(".*[a-z].*");
        inputRegexes[2] = Pattern.compile(".*[1-9].*");
        inputRegexes[3] = Pattern.compile("^[A-Za-z1-9]{3,32}$");

        boolean inputMatches = true;
        for (Pattern inputRegex : inputRegexes) {
            if (!inputRegex.matcher(password).matches()) {
                inputMatches = false;
            }
        }
        return inputMatches;
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public boolean validateAccount(Account account) {
        Optional<Account> entity = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (entity.isPresent())
            return true;
        else
            return false;
    }
}
