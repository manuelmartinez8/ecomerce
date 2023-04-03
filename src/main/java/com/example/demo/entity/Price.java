package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "prices")
public class Price implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pricesid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="brand_id")
    private BrandEntity brand;
    
    private Long product_id;
    private String priority;
    private Date start_date;
    private Date  end_date;
    private String curr;
    private String price_list;
}
