package com.anuncios.propagandas.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.anuncios.propagandas.entities.anuncios;
import com.anuncios.propagandas.services.anunciosService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("anuncios")
@CrossOrigin
public class anunciosController {

    @Autowired
    private anunciosService anunciosService;

    @GetMapping
    public ResponseEntity<List<anuncios>> getAnuncios(){
        List<anuncios> anuncios = anunciosService.getAnuncios();
        return ResponseEntity.ok().body(anuncios);
    }

    @PostMapping
    public ResponseEntity<anuncios> saveAnuncios(@RequestBody anuncios anuncios){
      anuncios newAnuncios = anunciosService.save(anuncios);

       URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(anuncios.getId())
        
        .toUri();
        return ResponseEntity.created(location).body(newAnuncios);
    }
    
}
