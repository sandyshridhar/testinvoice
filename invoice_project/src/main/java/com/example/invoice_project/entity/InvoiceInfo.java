package com.example.invoice_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoice_Id;

    private String bill_to;

    private String invoice_date;
    private String invoice;
    private String due_date;
    private String status;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "invoiceInfo")
//    List<InvoiceDetials> invoiceDetials;

    private  String grand_total1;


}
