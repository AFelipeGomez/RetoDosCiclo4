/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto.uno.repository.crud;

import com.usa.reto.uno.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Andres Gomez
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
}