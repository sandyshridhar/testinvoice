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
        log.info("inside the saveInvoiceInfo Service. here saving values to db.");
        try {
            invoiceInfoRepo.save(invoiceInfo);
        }
        catch (Exception e)
        {
        }
    }

    public void saveInvoiceDetails(InvoiceDetials invoice_details) {
        log.info("inside the saveInvoiceDetails Service. here saving values to db.");
        invoiceDetailsRepo.save(invoice_details);
    }


    public InvoiceInfo getInvoiceById(String invoice) {
        log.info("inside the getInvoiceById Service. fetching particular details from db using invoice.");
        Optional<InvoiceInfo> optional= Optional.ofNullable(invoiceInfoRepo.findByInvoiceId(invoice));
        InvoiceInfo invoiceInfo=null;
        if (optional.isPresent()) {
            invoiceInfo = optional.get();
        } else {
            System.out.println("id not found");
//            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return invoiceInfo;

    }

    public InvoiceInfo updateInvoice(@Valid InvoiceInfo invoice_information, String invoice) {
        log.info("inside the updateInvoice Service. here updating d details of tht selected invoice.");
        InvoiceInfo invoiceInfo=invoiceInfoRepo.findByInvoiceId(invoice);
        invoiceInfo.setBill_to(invoice_information.getBill_to());
        invoiceInfo.setInvoice_date(invoice_information.getInvoice_date());
        invoiceInfo.setDue_date(invoice_information.getDue_date());
        invoiceInfo.setStatus(invoice_information.getStatus());
        return invoiceInfoRepo.save(invoiceInfo);
    }

    public void deleteInvoiceById(String invoice) {
        log.info("inside the deleteInvoiceById Service. here deleting d details of tht selected invoice.");
        log.info(invoice);
        invoiceInfoRepo.deleteByInvoiceId(invoice);
        invoiceDetailsRepo.deleteByInvoiceId(invoice);
    }

    public List<InvoiceInfo> getByKeyword(String keyword) {
        return invoiceInfoRepo.findByKeyword(keyword);
    }

    public List<InvoiceInfo> getAllInvoice() {
        return (List<InvoiceInfo>) invoiceInfoRepo.findAll();
    }
}
