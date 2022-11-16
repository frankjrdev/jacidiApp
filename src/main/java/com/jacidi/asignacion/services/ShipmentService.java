package com.jacidi.asignacion.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.entities.ShipmentProducts;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentProductsRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.jacidi.asignacion.constants.jacidiConstant.*;

@Service
public class ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentProductsRepository shipmentProductsRepository;


    //Get all shipments
    public Map<String, Object> getAllShipment(){
        Map<String, Object> response = new HashMap<>();
        List<Shipment> shipments = new ArrayList<>();
        try{
            shipments = shipmentRepository.findAll();
            if(shipments != null){
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, shipments);
            }else{
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_SHIPMENTS_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }


    //Get shipment
    public  Map<String, Object> getShipmentById(int id){
        Map<String, Object> response = new HashMap<>();
        Shipment shipment;
        try{
            shipment = shipmentRepository.findById(id);
            if (shipment != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, shipment);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_SHIPMENT_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    public Object removeProduct(Integer idProduct, Integer idShipment){
        Object objectResult = null;
        List<Shipment> productList = new ArrayList<>();
        try{
            Product product = productRepository.findById(idProduct);
            Shipment shipment = shipmentRepository.findById(idShipment);
            productList = shipmentRepository.findByIdProduct(idProduct);

            for(Shipment shipment1: productList){
                shipment1 = shipmentRepository.deleteByIdProduct(idProduct);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return objectResult;
    }



    //Create a shipment

    public Map<String, Object> saveShipment(Integer idClient,
                               List<Integer> idProducList,
                               Date deliverDate){
        Map<String, Object> response = new HashMap<>();
        Shipment shipment;
        try{

            BigDecimal totalCost = new BigDecimal("0");
            Date today = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            List<Product> products = new ArrayList<>();
            Client client;
            client = clientRepository.findById(idClient);

            if(client != null){
                if(!client.getNextRenewal().before(today)){
                    shipment = new Shipment();
                    for (Integer idProduct: idProducList){
                        Product product = productRepository.findById(idProduct);
                        if(product != null){
                            totalCost = totalCost.add(BigDecimal.valueOf(Double.valueOf(product.getCost().toString())));
                            if(product.getMinPrio() < 50){
                                calendar.add(Calendar.DATE, 1);
                                shipment.setDeliverDate(calendar.getTime());
                            }else{
                                calendar.add(Calendar.HOUR, 12);
                                shipment.setDeliverDate(calendar.getTime());
                            }
                        }
                    }

                    shipment.setClient(client);
                    shipment.setTotalCost(totalCost);
                    Shipment shipmentSaved = shipmentRepository.save(shipment);
                    response.put(MESSAGE, MESSAGE_SUCCESS);
                    response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                    response.put(RESPONSE_OBJECT, shipment);

                    //Proceso para agregar a shipmentProducts

                    for (Integer idProduct: idProducList){
                        Product product = productRepository.findById(idProduct);
                        if(product != null){
                            Integer memberShipPrio = client.getMembership().getPrio();
                            if(product.getMinPrio() > memberShipPrio){
                                ShipmentProducts shipmentProducts = new ShipmentProducts();
                                shipmentProducts.setId_product(product.getId());
                                shipmentProducts.setId_shipment(shipmentSaved.getId());
                            }
                        }
                    }


                }else{
                    response.put(RESPONSE_TEXT, RESPONSE_NEXT_RENEWAL_PAST);
                }

            }else{
                response.put(RESPONSE_TEXT, RESPONSE_GET_CLIENT_FAILED);
            }

        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);

        }
        return response;
    }

    //Delete a shipment
    public Map<String, Object> deleteShipment(Integer id){
        Map<String, Object> response = new HashMap<>();
        Shipment shipment;
        try{
            shipment = shipmentRepository.findById(id);
            if (shipment != null) {
                shipmentRepository.delete(shipment);
                //shipmentProductsRepository.deleteById_shipment(shipment.getId());
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Shipment eliminado correctamente");
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_SHIPMENT_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }


}
