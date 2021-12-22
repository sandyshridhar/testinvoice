package com.example.invoice_project.controller;

import com.example.invoice_project.entity.Invoice_Info;
import com.example.invoice_project.repository.Invoice_Info_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller

public class Invoice_Info_Controller {

    @Autowired
    Invoice_Info_Repository invoice_info_repository;


    @GetMapping("/invoice")
    public ModelAndView addEmployeeForm() {

        ModelAndView mav = new ModelAndView("invoice_information");

        return mav;
    }
    @PostMapping("/saveInvoice")
    public String saveEmployee(@ModelAttribute Invoice_Info invoice_info) {

        invoice_info_repository.save(invoice_info);
        return "invoice_information";
    }

}
