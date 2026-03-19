package com.example.assignment_system.controller;

import com.example.assignment_system.model.Staff;
import com.example.assignment_system.repository.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin
public class StaffController {

    private final StaffRepository repo;

    public StaffController(StaffRepository repo) {
        this.repo = repo;
    }

    // CREATE STAFF
    @PostMapping
    public Staff create(@RequestBody Staff staff) {
        return repo.save(staff);
    }

    // GET ALL STAFF
    @GetMapping
    public List<Staff> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    
    }

    @PutMapping("/{id}")
public Staff update(@PathVariable Long id,
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String role) {

    Staff s = repo.findById(id).orElseThrow();

    s.setName(name);
    s.setEmail(email);
    s.setRole(role);

    return repo.save(s);
}
}