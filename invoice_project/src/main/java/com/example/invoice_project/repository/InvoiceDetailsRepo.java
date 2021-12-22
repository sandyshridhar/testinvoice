package com.example.invoice_project.repository;

import com.example.invoice_project.entity.InvoiceDetials;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface InvoiceDetailsRepo extends CrudRepository<InvoiceDetials,Integer> {
    @Modifying
    @Query(value = "DELETE  FROM INVOICE_DETIALS   where  INV_NO= ?1",nativeQuery = true)
    void deleteByInvoiceId(String invoice);
}
