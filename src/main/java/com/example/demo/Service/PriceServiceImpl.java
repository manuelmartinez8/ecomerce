package com.example.demo.Service;


import com.example.demo.dto.PricesDto;
import com.example.demo.entity.Price;
import com.example.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl {


    @Autowired
    private PriceRepository repository;


    public List<PricesDto> all(){
        /*List<CustomerDTO> customers = new ArrayList<>();
		List<Customer> cList = this.customerRepository.findAll();
        * */
        List<PricesDto> all = new ArrayList<>();

        List<Price> allPrices = this.repository.findAll();

        return all;
    }
}
