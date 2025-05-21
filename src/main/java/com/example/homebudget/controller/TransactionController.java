package com.example.homebudget.controller;

import com.example.homebudget.model.Transaction;
import com.example.homebudget.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String listTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transactions";
    }

    @GetMapping("/new")
    public String newTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction_form";
    }

    @PostMapping
    public String saveTransaction(@ModelAttribute Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions"; // перенаправляє на головну
    }
    // Відображення форми редагування транзакції
    @GetMapping("/edit/{id}")
    public String editTransactionForm(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        return "transaction_form"; // Використовуємо ту ж форму, що і для створення
    }

    // Збереження зміненої транзакції
    @PostMapping("/update/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute Transaction transaction) {
        transaction.setId(id); // важливо: встановлюємо ID, щоб оновлення було коректним
        transactionService.updateTransaction(transaction);
        return "redirect:/transactions";
    }
    @PostMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransactionById(id);
        return "redirect:/transactions"; // <--- Це правильно!
    }


}
