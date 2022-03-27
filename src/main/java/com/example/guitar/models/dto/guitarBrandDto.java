package com.example.guitar.models.dto;

import java.util.Map;

public class guitarBrandDto {

    private Map<String, Integer> guitarsForEachBrand;

    public guitarBrandDto(Map<String, Integer> duplicatedBrands) {
        this.guitarsForEachBrand = duplicatedBrands;
    }

    public Map<String, Integer> getGuitarsForEachBrand() {
        return guitarsForEachBrand;
    }

    public void setGuitarsForEachBrand(Map<String, Integer> guitarsForEachBrand) {
        this.guitarsForEachBrand = guitarsForEachBrand;
    }
}
