package com.example.guitar.dataaccess;

import com.example.guitar.models.domain.Guitar;
import com.example.guitar.models.dto.guitarBrandDto;

import java.util.Map;

public interface IGuitarRepository {
    Map<Integer, Guitar> getAllGuitars();
    Guitar getGuitar (int id);
    Guitar addGuitar(Guitar guitar);
    Guitar replaceGuitar(int id, Guitar guitar);
    Guitar modifyGuitar(int id, Guitar guitar);
    void deleteGuitar(int id);
    boolean guitarExists(int id);
    boolean isGuitarValid(Guitar guitar);
    guitarBrandDto getGuitarsForEachBrand();
    boolean isGuitarsEmpty();
}
