package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Shipment> getAllShipment(){
        List<Shipment> shipments = new ArrayList<>();
        try{
            shipments = shipmentRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return shipments;
    }

    public Shipment getShipmentById(int id){
        Shipment shipment = new Shipment();
        try{
            shipment = shipmentRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return shipment;
    }

    public Object removeProduct(Integer idProduct, Integer idShipment){
        Object objectResult = null;
        List<Shipment> productList = new ArrayList<>();
        try{
            Product product = productRepository.findById(idProduct).get();
            Shipment shipment = shipmentRepository.findById(idShipment).get();
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

    public Object saveShipment(Integer idClient, List<Integer> idProducList, Date deliverDate){
        Shipment shipment = new Shipment();
        try{
            BigDecimal totalCost = new BigDecimal("0");
            Date today = new Date();
            List<Product> products = new ArrayList<>();
            Client client = new Client();
            if(clientRepository.findById(idClient) != null){
                client = clientRepository.findById(idClient).get();
            }

            for (Integer idProduct: idProducList){
                Product product = productRepository.findById(idProduct).get();
                totalCost.add(BigDecimal.valueOf(Double.valueOf(product.getCost().toString())));
            }


            if(today.after(client.getNextRenewal())){
                return "No se pude crear el shipment ya que la fecha de proxima renovacion ya expiro";
            }

            shipment.setClient(client);
            shipment.setDeliverDate(deliverDate);



        }catch (Exception e){
            e.printStackTrace();

        }
        return shipment;
    }


}
