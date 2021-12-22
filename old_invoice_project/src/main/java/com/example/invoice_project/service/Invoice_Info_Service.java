package com.example.invoice_project.service;

import com.example.invoice_project.entity.Invoice_Info;
import com.example.invoice_project.repository.Invoice_Info_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Invoice_Info_Service {

    @Autowired
    Invoice_Info_Repository invoice_info_repository;

    public Invoice_Info save(Invoice_Info invoice_info) {
        return invoice_info_repository.save(invoice_info);
    }
}
