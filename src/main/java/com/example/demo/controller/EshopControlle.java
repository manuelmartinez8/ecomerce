package com.example.demo.controller;


import com.example.demo.dto.PricesDto;
import com.example.demo.entity.BrandEntity;
import com.example.demo.entity.Price;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.request.PricesRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EshopControlle {

    @Autowired
    private PriceRepository  repository;

    @Autowired
    private BrandRepository brandRepository;

/*
* Acepte como parámetros de entrada:
*  fecha de aplicación,
*  identificador de producto, identificador de cadena.
* */
    @GetMapping
    public List<PricesDto> getPrices(){
        List<PricesDto> listado = new ArrayList<>();
        List<Price> listadoprices = new ArrayList<>();

        listadoprices = this.repository.findAll();

        return listado;
    }
    @PostMapping
    public ResponseEntity<Price> createPrices(@RequestBody PricesRequest prices){
        try {
           // List<Brand> brand = this.brandRepository.findAll();
            BrandEntity br = this.brandRepository.findById(
                    prices.getBrand().getBrand_id()).orElseThrow(
                    ()-> new ResourceNotFoundException("Brand no existe"));
    //usar un modelMapper

            ModelMapper  modelMapper = new ModelMapper();
            Price pri = modelMapper.map(prices, Price.class);
            pri.setBrand(br);

            Price p = this.repository.save(pri);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }






    /*
    * Devuelva como datos de salida:
    *  identificador de producto(product_id),
    *  identificador de cadena(brand_id),
    *  tarifa a aplicar(priority),
    *  fechas de aplicación(start_date)
    *  precio final a aplicar(price_List).
    * */


    //crear un funcion que convierta PricesRequest a pricesEntity

}
