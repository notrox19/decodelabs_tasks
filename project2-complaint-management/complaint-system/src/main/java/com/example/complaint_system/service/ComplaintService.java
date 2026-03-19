package com.example.complaint_system.service;

import com.example.complaint_system.model.Complaint;
import com.example.complaint_system.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repo;

    public ComplaintService(ComplaintRepository repo) {
        this.repo = repo;
    }

    public Complaint save(Complaint complaint) {
        complaint.setStatus("Pending");
        return repo.save(complaint);
    }

    public List<Complaint> getAll() {
        return repo.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = repo.findById(id).orElseThrow();
        c.setStatus(status);
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}