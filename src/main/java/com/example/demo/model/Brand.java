package com.example.demo.model;

import com.example.demo.entity.BrandEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {

    private Long brand_id;
    private String brand;

    public Brand(BrandEntity brand) {
        this.brand_id = brand.getBrand_id();
        this.brand = brand.getBrand();
    }
}
