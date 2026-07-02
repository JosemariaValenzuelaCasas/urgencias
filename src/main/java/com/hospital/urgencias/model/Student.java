package com.hospital.urgencias.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("Student")
public class Student {
    @Id
    private String id;

    private String dni;
    private String name;
    private String lastName;
    private String promotion;
    private LocalDateTime registerDate;
    private String status;
}
