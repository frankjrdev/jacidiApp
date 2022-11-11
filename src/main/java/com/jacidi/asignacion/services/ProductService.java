package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        try{
            products = productRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(int id){
        Product product = new Product();
        try{
            product = productRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
        }

        return product;
    }


}
