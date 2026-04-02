package com.finance.dashboard.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.dashboard.demo.model.FinancialRecord;
import com.finance.dashboard.demo.repository.FinancialRecordRepository;

@Service
public class FinancialService {

    @Autowired
    private FinancialRecordRepository repo;

    // ✅ CREATE
    public FinancialRecord create(FinancialRecord record) {

        // validation
        if (record.getAmount() <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        return repo.save(record);
    }

    // ✅ READ
    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    // ✅ UPDATE
    public FinancialRecord update(Long id, FinancialRecord record) {

        FinancialRecord existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));

        // update fields
        existing.setAmount(record.getAmount());
        existing.setDescription(record.getDescription());
        existing.setDate(record.getDate());

        return repo.save(existing);
    }

    // ✅ DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ✅ SUMMARY (🔥 NEW METHOD)
    public Map<String, Double> getSummary() {

        List<FinancialRecord> records = repo.findAll();

        double income = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("income"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("expense"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Map<String, Double> result = new HashMap<>();
        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netBalance", income - expense);

        return result;
    }
}