package com.example.homebudget.controller;

import com.example.homebudget.service.DebtService;
import com.example.homebudget.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final DebtService debtService;
    private final TransactionService transactionService;

    public MainController(DebtService debtService, TransactionService transactionService) {
        this.debtService = debtService;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("debts", debtService.getAllDebts());
        model.addAttribute("balance", transactionService.getCurrentBalance());
        return "home";
    }

    @GetMapping("/charts")
    public String charts() {
        return "charts";
    }

}
