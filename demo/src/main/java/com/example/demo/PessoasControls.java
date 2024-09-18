package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoasControls {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	
	@PostMapping
	public PessoasEntities criarPessoas(@RequestBody PessoasEntities pessoasEntidade) {
		return pessoasRepository.save(pessoasEntidade);
	}
	
	@GetMapping
	public List<PessoasEntities> ListarPessoas(){
		return pessoasRepository.findAll();
	}
	
	
	@PutMapping("/{id}")
	public PessoasEntities atualizarPesoas(@PathVariable Long id,@RequestBody PessoasEntities pessoasEntidades) {
		pessoasEntidades.setId(id);
		return pessoasRepository.save(pessoasEntidades);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		pessoasRepository.deleteById(id);
	}

}
