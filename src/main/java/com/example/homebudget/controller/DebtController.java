package com.example.homebudget.controller;

import com.example.homebudget.model.Debt;
import com.example.homebudget.model.DebtPayment;
import com.example.homebudget.service.DebtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/debts")
public class DebtController {

    private final DebtService debtService;

    public DebtController(DebtService debtService) {
        this.debtService = debtService;
    }

    @GetMapping
    public String listDebts(Model model) {
        model.addAttribute("debts", debtService.getAllDebts());
        return "debts";
    }

    @GetMapping("/new")
    public String newDebtForm(Model model) {
        model.addAttribute("debt", new Debt());
        return "debt_form";
    }

    @PostMapping
    public String saveDebt(@ModelAttribute Debt debt) {
        debtService.saveDebt(debt);
        return "redirect:/debts";
    }

    @GetMapping("/payments")
    public String listPayments(Model model) {
        model.addAttribute("payments", debtService.getAllPayments());
        return "payments";
    }

    @GetMapping("/payments/new")
    public String newPaymentForm(Model model) {
        model.addAttribute("payment", new DebtPayment());
        return "payment_form";
    }

    @PostMapping("/payments")
    public String savePayment(@ModelAttribute DebtPayment payment) {
        debtService.savePayment(payment);
        return "redirect:/debts/payments";
    }
}
