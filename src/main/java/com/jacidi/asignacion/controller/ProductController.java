package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        List<Product> objectResponse = new ArrayList<>();
        objectResponse = productService.getAllProducts();
        return objectResponse;
    }

    @GetMapping("/{id}")
    public Product getProduct(Integer id) {
        Product objectResponse = new Product();
        objectResponse = productService.getProductById(id);
        return objectResponse;
    }

    @PutMapping("/{id}")
    public Object apdateProduct(@RequestBody String json){
        Object objectResponse = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else{
            return "Error en la data recibida para crear un cliente";
        }

        return objectResponse;

    }

    @PostMapping("/create")
    public Object saveProduct(@RequestBody String json){
        Object objectResponse = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else{
            return "Error en la data recibida para crear un cliente";
        }

        return objectResponse;

    }

    @DeleteMapping("/delete")
    public Object deleteProduct(@RequestBody String json){
        Object objectResponse = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else{
            return "Error en la data recibida para crear un cliente";
        }

        return objectResponse;

    }
}
