package by.it.academy.foodorder.service;

import by.it.academy.foodorder.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void addNewProduct(Product product);
}
