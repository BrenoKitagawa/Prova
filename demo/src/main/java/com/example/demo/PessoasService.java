package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoasService {

	@Autowired
	private PessoasRepository pessoaRepository;

	public List<PessoasEntities> ListarPessoas() {
		return pessoaRepository.findAll();
	}
	
	public PessoasEntities salvar(PessoasEntities pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

	
	public PessoasEntities up (PessoasEntities entities, Long id) {
		PessoasEntities p = pessoaRepository.findById(id).get();
		p.setNome(entities.getNome());
		p.setEndreco(entities.getEndreco());
		return pessoaRepository.save(p);
	}
}
