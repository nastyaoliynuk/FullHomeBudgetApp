package com.example.homebudget.repository;

import com.example.homebudget.model.DebtPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtPaymentRepository extends JpaRepository<DebtPayment, Long> {
}
