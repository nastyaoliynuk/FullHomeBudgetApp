package com.example.homebudget.service;

import com.example.homebudget.model.Debt;
import com.example.homebudget.model.DebtPayment;
import com.example.homebudget.repository.DebtPaymentRepository;
import com.example.homebudget.repository.DebtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebtService {

    private final DebtRepository debtRepository;
    private final DebtPaymentRepository debtPaymentRepository;

    public DebtService(DebtRepository debtRepository, DebtPaymentRepository debtPaymentRepository) {
        this.debtRepository = debtRepository;
        this.debtPaymentRepository = debtPaymentRepository;
    }

    public List<Debt> getAllDebts() {
        return debtRepository.findAll();
    }

    public void saveDebt(Debt debt) {
        debtRepository.save(debt);
    }

    public List<DebtPayment> getAllPayments() {
        return debtPaymentRepository.findAll();
    }

    public void savePayment(DebtPayment payment) {
        debtPaymentRepository.save(payment);
    }
}
