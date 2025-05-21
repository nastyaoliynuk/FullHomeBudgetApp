package com.example.homebudget.service;

import com.example.homebudget.model.Debt;
import com.example.homebudget.repository.DebtRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulerService {

    private final DebtRepository debtRepository;

    public SchedulerService(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

    @Scheduled(cron = "0 0 9 * * ?") // щодня о 9:00
    public void remindUpcomingPayments() {
        List<Debt> debts = debtRepository.findAll();
        LocalDate today = LocalDate.now();

        debts.stream()
                .filter(Debt::isReminder)
                .filter(debt -> !debt.getEndDate().isBefore(today))
                .forEach(debt -> System.out.println("🔔 Нагадування: борг \"" + debt.getCategory() + "\" до " + debt.getEndDate()));
    }
}
