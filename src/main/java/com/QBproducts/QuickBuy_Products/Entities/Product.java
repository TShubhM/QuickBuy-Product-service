package com.QBproducts.QuickBuy_Products.Entities;


import com.QBproducts.QuickBuy_Products.utilities.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String sku; // (Stock Keeping Unit) 8 digit alphanumeric
    private double price;
    private String currency;
    private String category; // decide whether to make seperate or group
    private String brand;
    @Convert(converter = StringListConverter.class)
    private List<String> images; //(list of Image objects)
    private boolean availability; //(in stock, out of stock)
    @CreatedDate
    private LocalDateTime createdAt; //(timestamp)
    @UpdateTimestamp
    private LocalDateTime updatedAt; //(timestamp)
    private int productQty;
}
