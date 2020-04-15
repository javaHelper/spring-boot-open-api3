package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Office;

public interface OfficeRepository extends JpaRepository<Office, Long>{

	Page<Office> findAll(Pageable pageable);
}
