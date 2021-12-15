package com.usa.reto.uno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.usa.reto.uno.repository.crud.IClotheCrudRepository;
import com.usa.reto.uno.repository.crud.UserCrudRepository;

@SpringBootApplication
public class UnoApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository repo;
    
    @Autowired
    private IClotheCrudRepository repoClothe;

    public static void main(String[] args) {
        SpringApplication.run(UnoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repoClothe.deleteAll();
        repo.deleteAll();
    }

}
