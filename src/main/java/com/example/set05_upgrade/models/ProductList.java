package com.example.set05_upgrade.models;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static List<Product> productList = new ArrayList<>();
    public  List<Product> getProductList() {
        return productList;
    }
}
