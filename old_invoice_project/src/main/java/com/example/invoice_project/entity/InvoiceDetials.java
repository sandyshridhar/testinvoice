package com.example.invoice_project.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceDetials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String inv_no;
    private String product;
    private String description;
    private String price;
    private String qty;
    private String tax;
    private String grand_total1;

//    @ManyToOne
//    InvoiceInfo invoiceInfo;
    private String invoice_note;
    private String filename;
    private String filetype;
    @Lob
    private byte[] fileByte;



}
