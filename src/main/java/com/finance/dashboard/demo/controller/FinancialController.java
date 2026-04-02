package com.finance.dashboard.demo.controller;

import com.finance.dashboard.demo.model.FinancialRecord;
import com.finance.dashboard.demo.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/records")
public class FinancialController {

    @Autowired
    private FinancialService service;

    // CREATE
    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record) {
        return service.create(record);
    }

    // READ ALL
    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return service.update(id, record);
    }

    // ✅ SUMMARY API (🔥 NEW)
    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        return service.getSummary();
    }
}