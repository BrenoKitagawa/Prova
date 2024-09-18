package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
		
	@Autowired
	private CarroRepository carroRepository;
	
	public	List<CarroEntities> ListarTodos() {
		 return carroRepository.findAll();
	}
	
	public CarroEntities salvar(CarroEntities carro) {
		return carroRepository.save(carro);
	}
	
	public void deletar(Long id) {
		carroRepository.deleteById(id);
	}
	
	public CarroEntities up (CarroEntities entities, Long id) {
		CarroEntities p = carroRepository.findById(id).get();
		p.setModelo(entities.getModelo());
		p.setMarca(entities.getMarca());
		return carroRepository.save(p);
	}
	
	
}
