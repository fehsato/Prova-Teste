package com.anuncios.propagandas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anuncios.propagandas.entities.anuncios;

public interface anuncioRepository extends JpaRepository <anuncios, Integer> {
    
}
