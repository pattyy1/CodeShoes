package com.crud.javashastra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crud.javashastra.entity.Shoes;

import com.crud.javashastra.repository.ShoesRepository;

@Service
public class ShoesService {
	@Autowired
	ShoesRepository repository;

	public List<Shoes> findallShoes() {
		return (List<Shoes>) repository.findAll();
	}

	public Shoes findShoesById(int id) {
		Optional<Shoes> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Shoes();
	}

	public Shoes addShoes(Shoes shoes) {
		return repository.save(shoes);
	}

	public Shoes updateShoes(Shoes shoes) {
		Optional<Shoes> result = repository.findById(shoes.getId());
		Shoes existing = result.get();
		existing.setName(shoes.getName());
		existing.setSize(shoes.getSize());
		existing.setColor(shoes.getColor());
		existing.setQuantity(shoes.getQuantity());
		return repository.save(existing);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
