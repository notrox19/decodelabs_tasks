package com.example.assignment_system.repository;

import com.example.assignment_system.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}