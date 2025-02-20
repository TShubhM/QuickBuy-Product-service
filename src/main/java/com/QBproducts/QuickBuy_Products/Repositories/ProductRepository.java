package com.QBproducts.QuickBuy_Products.Repositories;

import com.QBproducts.QuickBuy_Products.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
