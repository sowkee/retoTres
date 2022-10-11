package com.reto.proyecto.reto_tres.repository;

import com.reto.proyecto.reto_tres.entities.Category;
import com.reto.proyecto.reto_tres.repository.crudRepository.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }


}