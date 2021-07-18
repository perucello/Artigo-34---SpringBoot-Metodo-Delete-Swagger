package com.educaspring.EducaSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaspring.EducaSpring.model.entities.Pessoa;



@Service
public class PessoaService {
	@Autowired
	private PessoaService service;
	
	//metodo - select all
	public List<Pessoa> findAll(){
		return service.findAll();
	}	
}
