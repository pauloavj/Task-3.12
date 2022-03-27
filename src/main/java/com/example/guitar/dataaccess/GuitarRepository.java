package com.example.guitar.dataaccess;

import com.example.guitar.models.domain.Guitar;
import com.example.guitar.models.dto.guitarBrandDto;
import com.example.guitar.models.maps.guitarDtoBrandMap;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GuitarRepository implements IGuitarRepository {
//    private List<Guitar> guitars = seedGuitars();
    private Map<Integer, Guitar> guitars = seedGuitars();

    private Map<Integer, Guitar> seedGuitars() {
        var guitars = new HashMap<Integer, Guitar>();
        guitars.put(1,new Guitar("Fender", "Telecaster"));
        guitars.put(2,new Guitar("Jackson", "Kelly"));
        return guitars;
    }

    @Override
    public Map<Integer, Guitar> getAllGuitars() {
        return guitars;
    }

    @Override
    public Guitar getGuitar(int id) {
        return guitars.get(id);
    }

    @Override
    public Guitar addGuitar(Guitar guitar){
        Integer maxValueInMap = Collections.max(guitars.keySet());
        guitars.put(maxValueInMap+1, guitar);
        return guitars.get(maxValueInMap+1);
    }
    //Replaces a guitar with a new object/guitar.
    @Override
    public Guitar replaceGuitar(int id, Guitar guitar) {
        guitars.replace(id, guitar);
        return guitars.get(id);
    }

    @Override
    public Guitar modifyGuitar(int id, Guitar guitar) {
        var guitarToModify = guitars.get(id);
        guitarToModify.setBrand(guitar.getBrand());
        guitarToModify.setModel(guitar.getModel());
        return guitars.get(id);
    }

    @Override
    public void deleteGuitar(int id) {
        guitars.remove(id);
    }

    @Override
    public boolean guitarExists(int id) {
        var numberMatchingGuitars = guitars
                .entrySet()
                .stream()
                .filter(g -> g.getKey() == id)
                .count();
        return numberMatchingGuitars > 0;
    }

    @Override
    public boolean isGuitarValid(Guitar guitar) {
        if (guitar.getBrand() == null || guitar.getModel() == null)
            return false;
        return true;
    }

//    public Map<String, Integer> getGuitarsForEachBrand(){
//        List<Guitar> guitarList = new ArrayList<Guitar>(guitars.values());
////        List<String> guitarBrandList = new ArrayList<String>(guitarList.)
//
//
//        for (Map.Entry<Integer, Guitar> entry:guitars.entrySet()) {
//            Guitar guitar = entry.getValue();
//        }
//        return
//    }
    @Override
    public guitarBrandDto getGuitarsForEachBrand() {
        var guitarBranches = guitarDtoBrandMap.guitarBrandDtoCount(guitars);
        return guitarBranches;
    }

    public boolean isGuitarsEmpty(){
        return  guitars.isEmpty();
    }

}
