package Lesson26.pawnshop.services.impl;

import Lesson26.pawnshop.exeptions.MyExepcions;
import Lesson26.pawnshop.models.Product;
import Lesson26.pawnshop.services.ProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void createProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    @Override
    public Product findProduct(String name) {
        for (Product prd : products) {
            if (prd.getName().equals(name)){
                return prd;
            }
        }
        throw new MyExepcions("Продукт не найден");
    }
}
