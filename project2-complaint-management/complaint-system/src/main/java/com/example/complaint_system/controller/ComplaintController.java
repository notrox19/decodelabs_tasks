package com.example.complaint_system.controller;

import com.example.complaint_system.model.Complaint;
import com.example.complaint_system.service.ComplaintService;
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

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return service.save(complaint);
    }

    @GetMapping
    public List<Complaint> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Complaint updateStatus(@PathVariable Long id,
                                 @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}