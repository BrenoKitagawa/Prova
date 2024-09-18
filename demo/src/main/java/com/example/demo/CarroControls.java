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
@RequestMapping("/carros")
public class CarroControls {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@PostMapping
	public CarroEntities criarCarro(@RequestBody CarroEntities carroEntidade) {
		return carroRepository.save(carroEntidade);
	}
	
	@GetMapping
	public List<CarroEntities> listarCarros(){
		return carroRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public CarroEntities atualizarCarro(@PathVariable Long id,@RequestBody CarroEntities carroEntidades) {
		carroEntidades.setId(id);
		return carroRepository.save(carroEntidades);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCarro(@PathVariable Long id) {
		carroRepository.deleteById(id);
	}
	

}
