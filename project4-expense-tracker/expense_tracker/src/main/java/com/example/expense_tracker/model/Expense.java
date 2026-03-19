package com.example.expense_tracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;     // Food, Travel, etc.
    private double amount;
    private String type;      // Income or Expense
    private String category;  // Food, Bills, etc.
}