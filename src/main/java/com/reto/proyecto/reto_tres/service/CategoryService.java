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
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){                    
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        
        return category;
    }
    
    public boolean delete(int id) {
        boolean flag=false;
        Optional<Category> c= categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            flag=true;
        }
        
        return flag;
    }
    
}