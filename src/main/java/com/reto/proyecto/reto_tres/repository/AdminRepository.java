package com.reto.proyecto.reto_tres.repository;

import com.reto.proyecto.reto_tres.repository.crudRepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
}
