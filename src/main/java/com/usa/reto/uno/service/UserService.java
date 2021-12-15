/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.reto.uno.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.reto.uno.model.User;
import com.usa.reto.uno.repository.UserRepository;

/**
 *
 * @author Andres Gomez
 */
@Service
public class UserService {

     @Autowired
    private UserRepository repositorio;
    
     /**
      * Metodo para obtener un usuario por id
      * @param id
      * @return 
      */
     
    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }

    /**
     * Metodo para obtener todos los usuarios registrados
     * @return 
     */
    public List<User> listAll() {
        return repositorio.listAll();
    }

    /**
     * Metodo para validar si existe ya registrado un email
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }

    /**
     * Metodo para validar la autenticacion por parte del usuario
     * @param email
     * @param password
     * @return 
     */
    public User autenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.autenticateUser(email, password);

        if (usuario.isEmpty()) {
            System.out.println("Entro empty");
            return new User();
        } else {
              System.out.println("Entro y encontro");
            return usuario.get();
        }
    }
    /**
     * Metodo para crear usuarios nuevos
     * @param user
     * @return 
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = repositorio.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return repositorio.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    /**
     * Metodo para actualziar los usuarios registrados
     * @param user
     * @return 
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Metodo para eliminar usuarios por id
     * @param userId
     * @return 
     */
    public boolean delete(int userId) {
        Optional<User> usuario = getUser(userId);
        
        if (usuario.isEmpty()){
            return false;
        }else{
            repositorio.delete(usuario.get());
            return true;
        }
        /*
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;

        */
    }
}
