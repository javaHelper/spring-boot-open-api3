package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.model.Office;
import com.example.repository.OfficeRepository;

@Service
public class OfficeService {
	@Autowired
	private OfficeRepository officeRepository;
	
	public List<Office> findAll(){
		return officeRepository.findAll();
	}
	
	public Office findByOfficeCode(Long officeCode) {
		Optional<Office> optional = officeRepository.findById(officeCode);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Page<Office> findAll(Pageable pageable){
		return officeRepository.findAll(pageable);
	}
}
