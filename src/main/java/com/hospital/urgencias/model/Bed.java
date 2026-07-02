package com.hospital.urgencias.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("bed")
public class Bed {
    @Id
    private String id;

    private String bedCode;

    private String bedState;

    private LocalDate bedRegister;
    
    private String status;
}
