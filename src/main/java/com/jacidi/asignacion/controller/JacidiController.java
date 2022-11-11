package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import com.jacidi.asignacion.services.MembershipService;
import com.jacidi.asignacion.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.io.IOException;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.URL_REMOVE_PRODUCT;
import static com.jacidi.asignacion.constants.jacidiConstant.URL_RENEW_MEMBERSHIP;


@RestController
@RequestMapping("/")
public class JacidiController {

    @Autowired
    MembershipService membershipService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;


    @PostMapping(URL_RENEW_MEMBERSHIP)
    public Object renewMemberShipClient(Integer idClient, Integer idMembership){
        Object objectResponse = null;

        try{
            if (idClient != null && idMembership != null){
                objectResponse = membershipService.renewMemberShipClient(idClient, idMembership);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return objectResponse;

    }


    @PostMapping(URL_REMOVE_PRODUCT)
    public Object  removeProduct(Integer idProduct, Integer idShipment){
        Object objectResponse = null;
        if (idProduct != null && idShipment != null ){
            try{
                objectResponse = shipmentService.removeProduct(idProduct, idShipment);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }else{
            return "El id del shipment o del producto no existe";
        }
        return objectResponse;
    }
}
