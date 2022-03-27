package com.example.guitar.models.maps;

import com.example.guitar.models.domain.Guitar;
import com.example.guitar.models.dto.guitarBrandDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class guitarDtoBrandMap {
    public static guitarBrandDto guitarBrandDtoCount(Map<Integer, Guitar> guitars){

        List<String> guitarBrandList = new ArrayList<>();
        for (Map.Entry<Integer, Guitar> entry : guitars.entrySet()) {
            guitarBrandList.add(entry.getValue().getBrand());
        }
        Map<String, Integer> duplicatedBrands = guitarBrandList
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), brand -> 1, Math::addExact)
                );
        var guitarBrandDto = new guitarBrandDto(duplicatedBrands);
        return guitarBrandDto;
    }
}
