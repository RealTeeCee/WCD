package com.example.set05_upgrade.services;



import com.example.set05_upgrade.models.Product;
import com.example.set05_upgrade.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

public class ProductJPAServiceImpl implements ProductJPAService{
    private final EntityManager entityManager;


    public ProductJPAServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();


    }
    @Override
    public boolean deleteProduct(String id) {
        try {
            entityManager.getTransaction().begin();
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            entityManager.getTransaction().commit();

            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> searchProduct(String searchStr) {
        var query = entityManager.createQuery("Select p from Product p where p.productName like ?1 or p.price = ?2", Product.class);
        query.setParameter(1, "%" +searchStr + "%");
        query.setParameter(2, "%" +searchStr + "%");
        return query.getResultList();
    }

    @Override
    public List<Product> getAllProduct() {

        return entityManager.createQuery("select e from Product e", Product.class).getResultList();
    }

    @Override
    public Product getProductById(String id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }
    @Override
    public boolean updateProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            //merge = save()
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return  false;
        }
    }

    @Override
    public boolean Login(User user) {
        return entityManager.find(User.class, user) != null;
    }

    private String validateEntity(Product product) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        StringBuilder stringBuilder = new StringBuilder();

        for (ConstraintViolation<Product> violation : violations) {
            stringBuilder.append(violation.getMessageTemplate()).append("\n").append(violation.getMessageTemplate()).append("\n");

        }
        return stringBuilder.toString();
    }
}
