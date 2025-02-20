package com.QBproducts.QuickBuy_Products.utilities;

import com.QBproducts.QuickBuy_Products.DTOs.ProductResponseDTO;
import com.QBproducts.QuickBuy_Products.Entities.Product;

public class DTOConverter {
    public static ProductResponseDTO productToProductDTO(Product product) {
        ProductResponseDTO prodResponseDTO = new ProductResponseDTO();
        prodResponseDTO.setName(product.getName());
        prodResponseDTO.setDescription(product.getDescription());
        prodResponseDTO.setBrand(product.getBrand());
        prodResponseDTO.setProductQty(product.getProductQty());
        prodResponseDTO.setCurrency(product.getCurrency());
        // Later will have to change image after UI updates
        prodResponseDTO.setImages(product.getImages());
        prodResponseDTO.setSku(product.getSku());
        prodResponseDTO.setCreatedAt(product.getCreatedAt());
        prodResponseDTO.setUpdatedAt(product.getUpdatedAt());
        return prodResponseDTO;
    }

    // check createdAt and updatedAt after creation
    public static Product productDTOToProduct(ProductResponseDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setBrand(dto.getBrand());
        product.setProductQty(dto.getProductQty());
        product.setCurrency(dto.getCurrency());
        product.setImages(dto.getImages());
        product.setSku(dto.getSku());
        return product;
    }
}
