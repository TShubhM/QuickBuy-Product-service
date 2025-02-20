package com.QBproducts.QuickBuy_Products.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
//Currency is deleted from this dto
//create dynamic query
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestDTO {
    private String name;
    private String description;
    private String sku; // (Stock Keeping Unit)
    private String brand;
    private List<String> images; //(list of Image objects)
    private String currency;
    private int productQty;
}
