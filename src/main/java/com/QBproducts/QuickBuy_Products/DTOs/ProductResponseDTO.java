package com.QBproducts.QuickBuy_Products.DTOs;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
public class ProductResponseDTO {
    private String name;
    private String description;
    private String sku; // (Stock Keeping Unit)
    private String brand;
    private List<String> images; //(list of Image objects)
    private String currency;
    private int productQty;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
