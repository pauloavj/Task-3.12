package com.example.guitar.models.dto;

import org.springframework.stereotype.Component;

import java.util.Map;

//public class GuitarBrandDto {
////    @Autowired
//    private Map<String, Integer> guitarsForEachBrand;
//
//    public GuitarBrandDto(Map<String, Integer> duplicatedBrands) {
//        this.guitarsForEachBrand = duplicatedBrands;
//    }
//
//    public Map<String, Integer> getGuitarsForEachBrand() {
//        return guitarsForEachBrand;
//    }
//
//    public void setGuitarsForEachBrand(Map<String, Integer> guitarsForEachBrand) {
//        this.guitarsForEachBrand = guitarsForEachBrand;
//    }
//}
@Component
public class GuitarBrandDto {
//    @Component
    private Map<String, Integer> guitarsForEachBrand;

//    public GuitarBrandDto(Map<String, Integer> duplicatedBrands) {
//        this.guitarsForEachBrand = duplicatedBrands;
//    }

    public Map<String, Integer> getGuitarsForEachBrand() {
        return guitarsForEachBrand;
    }

    public void setGuitarsForEachBrand(Map<String, Integer> guitarsForEachBrand) {
        this.guitarsForEachBrand = guitarsForEachBrand;
    }
}

