package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
public class ExpenseController {

    private final ExpenseRepository repo;

    public ExpenseController(ExpenseRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public Expense add(@RequestBody Expense e) {
        return repo.save(e);
    }

    // READ
    @GetMapping
    public List<Expense> getAll() {
        return repo.findAll();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
public Expense update(@PathVariable Long id, @RequestBody Expense e) {
    Expense old = repo.findById(id).orElseThrow();

    old.setTitle(e.getTitle());
    old.setAmount(e.getAmount());
    old.setType(e.getType());
    old.setCategory(e.getCategory());

    return repo.save(old);
}
}