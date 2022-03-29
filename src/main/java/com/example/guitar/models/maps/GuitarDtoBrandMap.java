package com.example.guitar.models.maps;

import com.example.guitar.models.domain.Guitar;
import com.example.guitar.models.dto.GuitarBrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Component
public class GuitarDtoBrandMap {

    public static GuitarBrandDto guitarBrandDtoCount(Map<Integer, Guitar> guitars) {
//
//        List<String> guitarBrandList = new ArrayList<>();
//
//        for (Map.Entry<Integer, Guitar> entry : guitars.entrySet()) {
//            guitarBrandList.add(entry.getValue().getBrand());
//        }
//        Map<String, Integer> duplicatedBrands = guitarBrandList
//                .stream()
//                .collect(
//                        Collectors.toMap(Function.identity(), brand -> 1, Math::addExact)
//                );
//        var guitarBrandDto = new GuitarBrandDto(duplicatedBrands);
//        return guitarBrandDto;
//    }
    //---------------------------------------------------------------------------------------------------------
//        @Autowired
        GuitarBrandDto guitarMap;

        List<String> guitarBrandList = new ArrayList<>();

        for (Map.Entry<Integer, Guitar> entry : guitars.entrySet()) {
            guitarBrandList.add(entry.getValue().getBrand());
        }

        guitarMap = (GuitarBrandDto) guitarBrandList
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), brand -> 1, Math::addExact)
                );
//        var guitarBrandDto = new GuitarBrandDto(duplicatedBrands);
        return guitarMap;

    }
}
