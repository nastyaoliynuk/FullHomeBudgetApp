package com.example.homebudget.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
    private BigDecimal receivedAmount;
    private BigDecimal totalReturnAmount;
    private String paymentFrequency;
    private BigDecimal paymentAmount;
    private boolean reminder;

    // --- Геттери ---
    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }

    public BigDecimal getTotalReturnAmount() {
        return totalReturnAmount;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public boolean isReminder() {
        return reminder;
    }

    // --- Сеттери ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public void setTotalReturnAmount(BigDecimal totalReturnAmount) {
        this.totalReturnAmount = totalReturnAmount;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }
}
