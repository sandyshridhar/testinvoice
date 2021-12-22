package com.example.invoice_project.repository;

import com.example.invoice_project.entity.Invoice_Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_Info_Repository extends CrudRepository<Invoice_Info,Integer> {
}
