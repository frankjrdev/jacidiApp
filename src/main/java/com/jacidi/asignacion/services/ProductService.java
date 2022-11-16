package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentProductsRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    ShipmentProductsRepository shipmentProductsRepository;

    //Get all products
    public Map<String, Object> getAllProducts(){
        Map<String, Object> response = new HashMap<>();
        List<Product> products;
        try{
            products = productRepository.findAll();
            if(products != null){
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, products);
            }else{
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_PRODUCTS_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //get product
    public Map<String, Object> getProductById(Integer id){
        Map<String, Object> response = new HashMap<>();
        Product product = new Product();
        try{
            product = productRepository.findById(id);
            if (product != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, product);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_PRODUCT_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //save product
    public Map<String, Object> saveProduct(String name,
                                           BigDecimal cost,
                                           Integer minPrio){
        Map<String, Object> response = new HashMap<>();
        Product product;
        try{
            product = productRepository.findByName(name);
            if (product == null && 0 <= minPrio && minPrio <= 100 ) {
                product = new Product();
                product.setName(name);
                product.setCost(cost);
                product.setMinPrio(minPrio);
                productRepository.save(product);


                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, product);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, ERROR_CREATE_PRODUCT);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //update product
    public Map<String, Object> updateProduct(Integer id,
                                             String name,
                                           BigDecimal cost,
                                           Integer minPrio){
        Map<String, Object> response = new HashMap<>();
        Product product;
        try{
            product = productRepository.findById(id);
            if (product != null && 0 <= minPrio && minPrio <= 100 ) {
                product.setName(name);
                product.setCost(cost);
                product.setMinPrio(minPrio);
                productRepository.save(product);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, product);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, ERROR_UPDATE_PRODUCT);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }


    //Delete product
    public Map<String, Object> deleteProduct(Integer id){
        Map<String, Object> response = new HashMap<>();
        Product product;
        try{
            product = productRepository.findById(id);
            if (product != null) {
                productRepository.delete(product);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Producto eliminado correctamente");
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_PRODUCT_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Delete product
    public Map<String, Object> removeProduct(Integer idProduct,
                                             Integer idShipment){
        Map<String, Object> response = new HashMap<>();
        Product product;
        Shipment shipment;
        try{
            product = productRepository.findById(idProduct);
            shipment = shipmentRepository.findById(idShipment);
            if (product != null) {
                shipmentProductsRepository.removeById_productAndId_shipment(idShipment, idProduct);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Productos eliminado correctamente");
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_PRODUCT_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }




}
