package com.example.guitar.controllers;

import com.example.guitar.dataaccess.IGuitarRepository;
import com.example.guitar.models.domain.Guitar;
import com.example.guitar.models.dto.guitarBrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/guitars")
public class GuitarController {

//    private IGuitarRepository guitarRepository = new GuitarRepository();
    @Autowired
    private IGuitarRepository guitarRepository;

    @GetMapping()
    public ResponseEntity<Map<Integer, Guitar>> getAllGuitars(){
        return new ResponseEntity<>(guitarRepository.getAllGuitars(),HttpStatus.OK);
//        return guitarRepository.getAllGuitars();
    }

    //Get the targeted id.
    @GetMapping("/{id}") //Same here, the root is always /guitar as above.
    public ResponseEntity<Guitar> getGuitar(@PathVariable int id) {
        //int convertedId = Integer.parseInt(id); - Is not needed, it reads!
        if(!guitarRepository.guitarExists(id))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(guitarRepository.getGuitar(id), HttpStatus.OK);
        //Testing out http status.
    }

    @GetMapping("/brands")
    public ResponseEntity<guitarBrandDto> getGuitarsFromBrand(){
        if(guitarRepository.isGuitarsEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(guitarRepository.getGuitarsForEachBrand(), HttpStatus.OK);
    }

    //Saved in memory, volatile, needs to be saved somewhere!
    @PostMapping
    public ResponseEntity<Guitar> createCreateGuitar(@RequestBody Guitar guitar) {
//        return guitarRepository.addGuitar(guitar);
        if(guitarRepository.isGuitarValid(guitar))
            return new ResponseEntity<>(guitarRepository.addGuitar(guitar), HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    //Put, linked to the replaceGuitar with the body.
    @PutMapping("/{id}")
    public ResponseEntity<Guitar> replaceGuitar(@PathVariable int id, @RequestBody Guitar guitar) {
        if(!guitarRepository.isGuitarValid(guitar))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        if(!guitarRepository.guitarExists(id))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(guitarRepository.replaceGuitar(id,guitar), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Guitar> modifyGuitar(@PathVariable int id, @RequestBody Guitar guitar) {
        if(!guitarRepository.isGuitarValid(guitar))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        if(!guitarRepository.guitarExists(id))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(guitarRepository.modifyGuitar(id, guitar), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuitar(@PathVariable int id) {
        if(!guitarRepository.guitarExists(id))
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        guitarRepository.deleteGuitar(id);
        return new ResponseEntity<>("Guitar with id " + id + " has been removed!", HttpStatus.OK);
    }


}

