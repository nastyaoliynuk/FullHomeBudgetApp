package com.example.homebudget.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class DebtPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "debt_id")
    private Debt debt;

    private LocalDate paymentDate;
    private BigDecimal amount;
    private String comment;

    // Getters and setters
}
