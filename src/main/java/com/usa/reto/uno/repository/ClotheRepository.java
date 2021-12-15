package com.usa.reto.uno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.reto.uno.model.Clothe;
import com.usa.reto.uno.repository.crud.IClotheCrudRepository;



@Repository
public class ClotheRepository {

	   @Autowired
	    private IClotheCrudRepository clotheCrudRepository;

	  

	    public List<Clothe> listAll() {
	        return (List<Clothe>) clotheCrudRepository.findAll();
	    }

	    public Optional<Clothe> getClothe(String reference) {
	        return clotheCrudRepository.findById(reference);
	    }

	    public Clothe create(Clothe clothe) {
	        return clotheCrudRepository.save(clothe);
	    }

	    public void update(Clothe clothe) {
	    	clotheCrudRepository.save(clothe);
	    }

	    public void delete(Clothe clothe) {
	    	clotheCrudRepository.delete(clothe);
	    }
}
