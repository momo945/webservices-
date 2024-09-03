package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<Page<Transaction>> getTransactions(@PathVariable Long accountId,
                                                             @RequestParam int page,
                                                             @RequestParam int size) {
        return ResponseEntity.ok(transactionService.getTransactions(accountId, page, size));
    }
}
