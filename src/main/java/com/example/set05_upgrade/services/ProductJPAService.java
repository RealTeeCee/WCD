package com.example.set05_upgrade.services;




import com.example.set05_upgrade.models.Product;
import com.example.set05_upgrade.models.User;

import java.util.List;

public interface ProductJPAService {
    public List<Product> getAllProduct();
    public Product getProductById(String id);
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(String id);
    public List<Product> searchProduct(String searchStr);
    public boolean Login(User user);
}
