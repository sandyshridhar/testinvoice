package com.example.invoice_project.controller;

import com.example.invoice_project.entity.InvoiceDetials;
import com.example.invoice_project.entity.InvoiceInfo;
import com.example.invoice_project.service.InvoiceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class InvoiceInfoController {

    @Autowired
    InvoiceInfoService invoiceInfoService;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
    Date date = new Date();
    String date1=formatter.format(date);



    @GetMapping(path = {"/invoice"})
    private String getInvoiceForm(Model model) {

        model.addAttribute("invoice_date",date1 );
        return "invoice_information";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice_information") @Valid InvoiceInfo invoice_information,
                                     @ModelAttribute("invoice_details") @Valid InvoiceDetials invoice_details ,
                                     @RequestParam("myfile") MultipartFile myfile ) throws IOException {
        invoice_details.setFilename(myfile.getOriginalFilename());
        invoice_details.setFiletype(myfile.getContentType());
        invoice_details.setFileByte(myfile.getBytes());

        invoiceInfoService.saveInvoiceInfo(invoice_information);
        invoiceInfoService.saveInvoiceDetails(invoice_details);

        return "redirect:/invoice";
    }


}
