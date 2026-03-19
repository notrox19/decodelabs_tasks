package com.example.assignment_system.service;

import com.example.assignment_system.model.Complaint;
import com.example.assignment_system.model.Staff;
import com.example.assignment_system.repository.ComplaintRepository;
import com.example.assignment_system.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepo;
    private final StaffRepository staffRepo;

    public ComplaintService(ComplaintRepository complaintRepo, StaffRepository staffRepo) {
        this.complaintRepo = complaintRepo;
        this.staffRepo = staffRepo;
    }

    // SAVE COMPLAINT
    public Complaint save(Complaint complaint) {
        complaint.setStatus("Pending");
        return complaintRepo.save(complaint);
    }

    // GET ALL
    public List<Complaint> getAll() {
        return complaintRepo.findAll();
    }

    // ASSIGN STAFF
    public Complaint assign(Long complaintId, Long staffId) {
        Complaint c = complaintRepo.findById(complaintId).orElseThrow();
        Staff s = staffRepo.findById(staffId).orElseThrow();

        c.setStaff(s);
        c.setStatus("Assigned");

        return complaintRepo.save(c);
    }

    // DELETE
    public void delete(Long id) {
        complaintRepo.deleteById(id);
    }
}