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
@Document("patient")
public class Patient {
    
    @Id
    private String id;

    private String names;

    private Integer age;

    private String sintoms;

    private String urgency;

    private LocalDateTime registerDate;

    private String patientState;

    private String status;
}
