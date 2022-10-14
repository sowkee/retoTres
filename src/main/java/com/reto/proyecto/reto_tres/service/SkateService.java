package com.reto.proyecto.reto_tres.service;

import com.reto.proyecto.reto_tres.entities.Skate;
import com.reto.proyecto.reto_tres.repository.SkateRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkateService {
    
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate skate){
        if(skate.getId()==null){
            return skateRepository.save(skate);
        }else {
            Optional<Skate> e = skateRepository.getSkate(skate.getId());
            if (e.isEmpty()){
                return skateRepository.save(skate);
            }else {
                return skate;
            }
        }
    }
    
    public Skate update(Skate skate){
        if(skate.getId()!=null){
            Optional<Skate>g= skateRepository.getSkate(skate.getId());
            if(!g.isEmpty()){
                if(skate.getDescription()!=null){                    
                    g.get().setDescription(skate.getDescription());
                }
                if(skate.getName()!=null){
                    g.get().setName(skate.getName());
                }
                return skateRepository.save(g.get());
            }
        }
        return skate;
    }
    
    public boolean delete(int id) {
        boolean flag=false;
        Optional<Skate> c= skateRepository.getSkate(id);
        if(c.isPresent()){
            skateRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }

      

}
     