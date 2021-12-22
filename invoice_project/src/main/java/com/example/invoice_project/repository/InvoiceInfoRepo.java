package com.example.invoice_project.repository;

import com.example.invoice_project.entity.InvoiceInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface InvoiceInfoRepo extends CrudRepository<InvoiceInfo,Integer> {

    @Query(value = "select * from INVOICE_INFO where invoice= ?1 ",nativeQuery = true)
    InvoiceInfo findByInvoiceId(String invoice);

    @Modifying
    @Query(value = "DELETE  FROM INVOICE_INFO  where INVOICE = ?1",nativeQuery = true)
    void deleteByInvoiceId(String invoice);

    @Query(value = "select * from INVOICE_INFO ORDER BY due_date",nativeQuery = true)
    List<InvoiceInfo> findAllByFilter();


    @Query(value = "SELECT * FROM INVOICE_INFO WHERE BILL_TO like  '%?1%';",nativeQuery = true)
    List<InvoiceInfo> findByKeyword(String keyword);
}
