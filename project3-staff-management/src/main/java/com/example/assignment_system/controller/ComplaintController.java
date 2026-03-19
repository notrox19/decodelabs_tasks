package com.example.assignment_system.controller;

import com.example.assignment_system.model.Complaint;
import com.example.assignment_system.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return service.save(complaint);
    }

    // GET ALL
    @GetMapping
    public List<Complaint> getAll() {
        return service.getAll();
    }

    // ASSIGN STAFF
    @PutMapping("/{id}/assign/{staffId}")
    public Complaint assign(@PathVariable Long id, @PathVariable Long staffId) {
        return service.assign(id, staffId);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}