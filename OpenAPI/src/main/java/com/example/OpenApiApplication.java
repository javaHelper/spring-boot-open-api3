package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Contact;
import com.example.repository.ContactRepository;

@SpringBootApplication
public class OpenApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OpenApiApplication.class, args);
	}
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void run(String... args) throws Exception {
		contactRepository.save(Contact.builder().id(1L).address1("Address 1").address2("Address2").address3("Address3").build());
	}

}
