package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public BigDecimal getBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        return account.getBalance();
    }

    public void transfer(Long accountId, BigDecimal amount, String toAccountNumber) {
        Account fromAccount = accountRepository.findById(accountId)
            .orElseThrow(() -> new ResourceNotFoundException("Source account not found"));
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
            .orElseThrow(() -> new ResourceNotFoundException("Destination account not found"));

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
