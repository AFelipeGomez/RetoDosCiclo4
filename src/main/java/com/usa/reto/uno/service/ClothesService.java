package com.usa.reto.uno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.reto.uno.model.Clothe;
import com.usa.reto.uno.repository.ClotheRepository;


@Service
public class ClothesService {

	 @Autowired
	 private ClotheRepository clothRepository;
	 
         /**
          * Metodo para listar todos los clothes
          * @return 
          */
	 public List<Clothe> listAll() {
	        return clothRepository.listAll();
	    }

	    public Optional<Clothe> getClothe(String reference) {
	        return clothRepository.getClothe(reference);
	    }

            /*
            Metodo para registrar prendas
            */
	    public Clothe create(Clothe clothe) {
	        if (clothe.getReference() == null) {
	            return clothe;
	        } else {
	            return clothRepository.create(clothe);
	        }
	    }

	    public Clothe update(Clothe clothe) {

	        if (clothe.getReference() != null) {
	            Optional<Clothe> supplementDb = clothRepository.getClothe(clothe.getReference());
	            if (!supplementDb.isEmpty()) {
	                if (clothe.getSize()!= null) {
	                    supplementDb.get().setSize(clothe.getSize());
	                }
	                if (clothe.getCategory() != null) {
	                    supplementDb.get().setCategory(clothe.getCategory());
	                }

	                if (clothe.getDescription() != null) {
	                    supplementDb.get().setDescription(clothe.getDescription());
	                }
	                if (clothe.getPrice() != 0.0) {
	                    supplementDb.get().setPrice(clothe.getPrice());
	                }
	                if (clothe.getQuantity() != 0) {
	                    supplementDb.get().setQuantity(clothe.getQuantity());
	                }
	                if (clothe.getPhotography() != null) {
	                    supplementDb.get().setPhotography(clothe.getPhotography());
	                }
	                supplementDb.get().setAvailability(clothe.isAvailability());
	                clothRepository.update(supplementDb.get());
	                return supplementDb.get();
	            } else {
	                return clothe;
	            }
	        } else {
	            return clothe;
	        }
	    }

	    public boolean delete(String reference) {
	        Boolean aBoolean = getClothe(reference).map(supplement -> {
	            clothRepository.delete(supplement);
	            return true;
	        }).orElse(false);
	        return aBoolean;
	    }
}
