/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto.uno.repository;

import com.usa.reto.uno.model.User;
import com.usa.reto.uno.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andres Gomez
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudInterface;

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }
    
    public User update(User user) {
        return crudInterface.save(user);
    }
    
    
    public void delete(User user) {
        crudInterface.delete(user);
    }
}

