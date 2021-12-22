package com.example.invoice_project.service;


import com.example.invoice_project.entity.InvoiceDetials;
import com.example.invoice_project.entity.InvoiceInfo;
import com.example.invoice_project.repository.InvoiceDetailsRepo;
import com.example.invoice_project.repository.InvoiceInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InvoiceInfoService {

    @Autowired
    InvoiceInfoRepo invoiceInfoRepo;
    @Autowired
    InvoiceDetailsRepo invoiceDetailsRepo;

    public void saveInvoiceInfo( InvoiceInfo invoiceInfo) {
            invoiceInfoRepo.save(invoiceInfo);

    }

    public void saveInvoiceDetails(InvoiceDetials invoice_details) {
        invoiceDetailsRepo.save(invoice_details);
    }


    public InvoiceInfo getInvoiceById(String invoice) {

        Optional<InvoiceInfo> optional= Optional.ofNullable(invoiceInfoRepo.findByInvoiceId(invoice));
        InvoiceInfo invoiceInfo=null;
        if (optional.isPresent()) {
            invoiceInfo = optional.get();
        } else {

        }
        return invoiceInfo;

    }

    public void deleteInvoiceById(String invoice) {
        log.info("inside the deleteInvoiceById Service. here deleting d details of tht selected invoice.");
        log.info(invoice);
        invoiceInfoRepo.deleteByInvoiceId(invoice);
        invoiceDetailsRepo.deleteByInvoiceId(invoice);
    }


}
