package com.reto.proyecto.reto_tres.service;

import com.reto.proyecto.reto_tres.entities.Category;
import com.reto.proyecto.reto_tres.entities.Skate;
import com.reto.proyecto.reto_tres.repository.CategoryRepository;
import com.reto.proyecto.reto_tres.repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if (e.isEmpty()){
                return categoryRepository.save(category);
            }else {
                return category;
            }
        }
    }

    
}