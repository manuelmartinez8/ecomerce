package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;
    private String brand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Price> precios = new ArrayList<>();
}
