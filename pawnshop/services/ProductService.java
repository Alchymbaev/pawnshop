package Lesson26.pawnshop.services;

import Lesson26.pawnshop.models.Product;
import Lesson26.pawnshop.services.impl.ProductServiceImpl;

public interface ProductService {
    ProductService INSTANCE = new ProductServiceImpl();

    void createProduct(String name, double price);

    Product findProduct(String name);

}
