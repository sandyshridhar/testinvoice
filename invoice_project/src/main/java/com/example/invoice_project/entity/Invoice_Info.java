package com.example.invoice_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoice_Id;

    private String bill_To;

    private String invoice;

    private String invoice_Date;

    private String due_Date;

//    private String status;


}
