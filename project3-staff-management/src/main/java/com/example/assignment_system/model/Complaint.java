package com.example.assignment_system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String issue;
    private String status;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}