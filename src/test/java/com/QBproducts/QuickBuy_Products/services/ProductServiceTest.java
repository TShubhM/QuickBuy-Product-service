package com.QBproducts.QuickBuy_Products.services;

import com.QBproducts.QuickBuy_Products.DTOs.UpdateRequestDTO;
import com.QBproducts.QuickBuy_Products.Entities.Product;
import com.QBproducts.QuickBuy_Products.Repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repo;

    @InjectMocks
    private ProductService service;


    private Product product;
    private UpdateRequestDTO dto;

    @BeforeEach
    public void init() {
        product = new Product();
        product.setId(1);
        product.setName("Wireless Headphones");
        product.setDescription("High quality noise-cancelling headphones");
        product.setSku("ABCD1234");
        product.setPrice(99.99);
        product.setCurrency("USD");
        product.setCategory("Electronics");
        product.setBrand("SoundMagic");
        product.setImages(List.of("https://example.com/images/product1.jpg", "https://example.com/images/product2.jpg"));
        product.setAvailability(true);
        product.setProductQty(50);

        dto = new UpdateRequestDTO();
        dto.setBrand("SoundMagic");
        dto.setProductQty(12);
        dto.setCurrency("USD");
        dto.setDescription("High quality noise-cancelling headphones");
        dto.setName("Earphones");
        dto.setSku("ABCD1234");
    }

    @Test
    public void saveProductTest() {
        Mockito.when(repo.save(product)).thenReturn(product);
        Product savedProduct = service.saveProduct(product);
        Assertions.assertNotNull(savedProduct);
        Assertions.assertEquals("Electronics", product.getCategory());
    }

    @Test
    public void getProductDataTest() {
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(product));
        Product foundProduct = service.getProductData(1);
        Assertions.assertNotNull(foundProduct);
        Assertions.assertEquals(product.getCategory(), foundProduct.getCategory());
    }

    @Test
    public void updateProductTest() {
        Mockito.when(repo.findById(1)).thenReturn(Optional.of(product));
        Mockito.when(repo.save(Mockito.any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product product1 = service.updateProduct(1, dto);
        Assertions.assertNotNull(product1);
        Assertions.assertEquals(12, product1.getProductQty());
    }

    @Test
    public void updateProductExceptionTest() {
        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
                service.updateProduct(1, dto)
        );

        Assertions.assertEquals("Product with this ID 1 not found.", exception.getMessage());
    }

    @Test
    public void getAllProductsTest() {
        List<Product> prodList = new ArrayList<>();
        prodList.add(product);
        Mockito.when(repo.findAll()).thenReturn(prodList);
        List<Product> allProducts = service.getAllProducts();

        Assertions.assertNotNull(allProducts);
        Assertions.assertEquals(allProducts.size(), prodList.size());
    }

    @Test
    public void getAllProductsExceptionTest() {
        List<Product> prodList = new ArrayList<>();
        Mockito.when(repo.findAll()).thenReturn(prodList);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
                service.getAllProducts()
        );
        Assertions.assertEquals("Requested list is empty.", exception.getMessage());
    }

    @Test
    public void deleteProductByIdTest() {
        Mockito.when(repo.existsById(1)).thenReturn(true);
        String result = service.deleteProductById(1);
        Assertions.assertEquals("Product With ProductId " + 1 + " Deleted Successfully.", result);
    }

    @Test
    public void deleteProductByIdExceptionTest() {
        Mockito.when(repo.existsById(Mockito.any(Integer.class))).thenReturn(false);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () ->
                service.deleteProductById(1)
        );
        Assertions.assertEquals("No Item Present with this ID.", exception.getMessage());
    }
}
