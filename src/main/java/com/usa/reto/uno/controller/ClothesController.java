package com.usa.reto.uno.controller;

import com.usa.reto.uno.model.Clothe;
import com.usa.reto.uno.model.User;
import com.usa.reto.uno.service.ClothesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ClothesController {
    
    @Autowired
    private ClothesService servicio;
    
    @GetMapping("/all")
    public List<Clothe>listAll(){
        return servicio.listAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe clothe){
        return servicio.create(clothe);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe updtate(@RequestBody Clothe clothe){
        return servicio.update(clothe);
    }
    
    @DeleteMapping("{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return servicio.delete(reference);
    }
    
  @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference") String reference){
        return servicio.getClothe(reference);
    }

}
