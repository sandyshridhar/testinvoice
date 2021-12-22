package com.example.invoice_project.repository;

import com.example.invoice_project.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File,Integer> {
}
