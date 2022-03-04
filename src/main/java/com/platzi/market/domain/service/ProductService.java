package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoy productRepositoy;

    public List<Product> getAll(){
        return productRepositoy.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepositoy.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepositoy.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepositoy.save(product);
    }

    public boolean delete(int productId){
        if(getProduct(productId).isPresent()){
            productRepositoy.delete(productId);
            return true;
        } else{
            return false;
        }
    }
}
