package com.example.invoice_project.controller;

import com.example.invoice_project.entity.InvoiceDetials;
import com.example.invoice_project.entity.InvoiceInfo;
import com.example.invoice_project.repository.InvoiceDetailsRepo;
import com.example.invoice_project.repository.InvoiceInfoRepo;
import com.example.invoice_project.service.InvoiceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class InvoiceListController {

    @Autowired
    InvoiceInfoService invoiceInfoService;

    @Autowired
    InvoiceInfoRepo invoiceInfoRepo;

    @GetMapping(path = "/invoicelist")
    public ModelAndView getAllInvoice() {

        ModelAndView mav = new ModelAndView("invoice_info_list");

        mav.addObject("invoicelists",invoiceInfoRepo.findAllByFilter());
        return mav;
    }
    @GetMapping("/showForUpdate/{invoice}")
    public String showForUpdate(@PathVariable(value = "invoice") String invoice, Model model) {

        InvoiceInfo invoiceInfo = invoiceInfoService.getInvoiceById(invoice);
        System.out.println(invoiceInfo.getInvoice()+":"+invoiceInfo.getInvoice_date()+":"+invoiceInfo.getBill_to());

        model.addAttribute("invoiceInfo", invoiceInfo);
        return "edit_invoice_info";
    }

    @RequestMapping("/deleteInvoice/{invoice}")
    public String deleteInvoice(@PathVariable(value = "invoice") String invoice, Model model) {

        invoiceInfoService.deleteInvoiceById(invoice);

        return "redirect:/invoicelist";
    }


}
