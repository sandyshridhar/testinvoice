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
        log.info("inside getAllInvoice Controller, here getting all the InvoiceInfo and displaying.");
        ModelAndView mav = new ModelAndView("invoice_info_list");
//        mav.addObject("invoicelists", invoiceInfoRepo.findAll());
        mav.addObject("invoicelists",invoiceInfoRepo.findAllByFilter());
        return mav;
    }
    @GetMapping("/showForUpdate/{invoice}")
    public String showForUpdate(@PathVariable(value = "invoice") String invoice, Model model) {
        log.info("inside showForUpdate Controller, here fetching particular data and given to edit_invoice HTML page. ");
        // get Invoice from the service
        InvoiceInfo invoiceInfo = invoiceInfoService.getInvoiceById(invoice);
        System.out.println(invoiceInfo.getInvoice()+":"+invoiceInfo.getInvoice_date()+":"+invoiceInfo.getBill_to());
        // set Invoice as a model attribute to the form
        model.addAttribute("invoiceInfo", invoiceInfo);
        return "edit_invoice_info";
    }
    @PostMapping("/updateInvoice")
    public String updateInvoice(@ModelAttribute("invoice_information") @Valid InvoiceInfo invoice_information) throws IOException {
        log.info("inside updateInvoice Controller, here updating the data. ");

        String invoice=invoice_information.getInvoice();
        invoiceInfoService.updateInvoice(invoice_information,invoice);
        return "redirect:/invoicelist";
    }
    @RequestMapping("/deleteInvoice/{invoice}")
    public String deleteInvoice(@PathVariable(value = "invoice") String invoice, Model model) {
        log.info("inside deleteInvoice Controller, deleting the Invoice info using invoice.");

        invoiceInfoService.deleteInvoiceById(invoice);

        return "redirect:/invoicelist";
    }
    @RequestMapping("/search")
    public void search(Model model, @Param("keyword") String keyword)
    {
        log.info("inside d search Controller.");
        if(keyword!=null) {
            List<InvoiceInfo> list = invoiceInfoService.getByKeyword(keyword);
            model.addAttribute("invoicelists", list);
        }else {
            List<InvoiceInfo> list = invoiceInfoService.getAllInvoice();
            model.addAttribute("invoicelists", list);}

    }

}
