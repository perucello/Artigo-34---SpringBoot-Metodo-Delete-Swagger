package com.educaspring.EducaSpring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.educaspring.EducaSpring.model.entities.Pessoa;
import com.educaspring.EducaSpring.repository.PessoaRepository;

@RestController
@RequestMapping(path = "/api/educaciencia/pessoa")
public class PessoaController {

	private static final Pessoa Ok = null;

	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping
	public @ResponseBody Pessoa novaPessoa(@Validated Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return pessoa;
	}

	@GetMapping
	public @ResponseBody ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = (List<Pessoa>) pessoaRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Integer id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public @ResponseBody Pessoa UpdatePessoa(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return pessoa;
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public @ResponseBody Pessoa DeletePessoa(@PathVariable Integer id) throws Exception {
		try {
			pessoaRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return Ok;
	}

}