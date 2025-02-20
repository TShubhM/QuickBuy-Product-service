package com.QBproducts.QuickBuy_Products.services;

import com.QBproducts.QuickBuy_Products.DTOs.UpdateRequestDTO;
import com.QBproducts.QuickBuy_Products.Entities.Product;
import com.QBproducts.QuickBuy_Products.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    // While saving change the availability status as well
    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public Product getProductData(Integer productId) {
        return repo.findById(productId).orElseThrow(() -> new RuntimeException("Product data not found for " + productId));
    }

    // Add images will be a Seperate functionality
//   Decide SKU will be seperate or will be added in this only
    public Product updateProduct(int productId, UpdateRequestDTO requestDTO) {
        Optional<Product> productFound = repo.findById(productId);
        if (productFound.isPresent()) {
            Product foundProduct = productFound.get();
            foundProduct.setProductQty(requestDTO.getProductQty());
            foundProduct.setBrand(requestDTO.getBrand());
            foundProduct.setDescription(requestDTO.getDescription());
//            update the category using the same or different apis
//            foundProduct.setCategory(requestDTO.getCategory());
            foundProduct.setCurrency(requestDTO.getCurrency());
            foundProduct.setName(requestDTO.getName());
            if (requestDTO.getProductQty() <= 0) foundProduct.setAvailability(false);
//            Images and price will be added at last stage
            return repo.save(foundProduct);
        } else {
            throw new RuntimeException("Product with this ID " + productId + " not found.");
        }
    }

    public List<Product> getAllProducts() {
        List<Product> productsFound = repo.findAll();
        if (productsFound.isEmpty()) {
            throw new RuntimeException("Requested list is empty.");
        } else {
            return productsFound;
        }
    }

    public String deleteProductById(Integer productId) {
        if (repo.existsById(productId)) {
            repo.deleteById(productId);
            return "Product With ProductId " + productId + " Deleted Successfully.";
        } else {
            throw new RuntimeException("No Item Present with this ID.");
        }
    }
}
