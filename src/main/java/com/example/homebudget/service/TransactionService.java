package com.example.homebudget.service;

import com.example.homebudget.model.Transaction;
import com.example.homebudget.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction); // save() працює як оновлення, якщо ID вже існує
    }
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }
    public BigDecimal getCurrentBalance() {
        BigDecimal income = transactionRepository.getTotalIncome();
        BigDecimal expense = transactionRepository.getTotalExpense();

        if (income == null) income = BigDecimal.ZERO;
        if (expense == null) expense = BigDecimal.ZERO;

        return income.subtract(expense);
    }

}
