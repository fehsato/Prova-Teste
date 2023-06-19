package com.anuncios.propagandas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anuncios.propagandas.entities.anuncios;
import com.anuncios.propagandas.repositories.anuncioRepository;
import jakarta.persistence.EntityNotFoundException;


@Service

public class anunciosService {
    
    @Autowired
    private anuncioRepository anunciosRepository;

    public anuncios getAnunciosById(int id){
        return anunciosRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Erro 404")
        );
    }
        

public List<anuncios> getAnuncios(){
    return anunciosRepository.findAll();

}

public anuncios save(anuncios anuncios){
    return anunciosRepository.save(anuncios);
}

    
}