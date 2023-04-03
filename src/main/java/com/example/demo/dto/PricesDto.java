package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PricesDto {

    @JsonProperty(value = "id")
    private long id;

    @JsonProperty(value = "brand_id")
    private Long brand_id;

    @JsonProperty(value = "brand")
    private String brand;

    @JsonProperty(value = "precio")
    private int precio;

}
