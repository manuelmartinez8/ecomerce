package com.example.demo.request;


import com.example.demo.model.Brand;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PricesRequest implements Serializable {

    private Long pricesid;
    private Brand brand;
    private Long product_id;
    private String priority;
    private Date start_date;
    private Date  end_date;
    private String curr;
    private String price_list;
}
