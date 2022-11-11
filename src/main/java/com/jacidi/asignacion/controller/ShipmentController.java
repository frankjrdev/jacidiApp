package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;
import static com.jacidi.asignacion.constants.jacidiConstant.TOTAL_COST;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @GetMapping()
    public List<Shipment> getAllClients() {
        List<Shipment> objectResponse = new ArrayList<>();
        objectResponse = shipmentService.getAllShipment();
        return objectResponse;
    }

    @GetMapping("/{id}")
    public Shipment getShipment(Integer id) {
        Shipment objectResponse = new Shipment();
        objectResponse = shipmentService.getShipmentById(id);
        return objectResponse;
    }

    @PostMapping("/create")
    public Object createShipment(@RequestBody String json){
        Object objectResponse = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);
                for( Object key : params.keySet() ) params.put( String.valueOf(key) , (params.get(key) != null) ? String.valueOf(params.get(key)) : null );


                Integer idClient = (params.containsKey(ID_CLIENT) &&
                        params.get(ID_CLIENT) != null &&
                        !params.get(ID_CLIENT).toString().isEmpty() )
                        ? Integer.valueOf(params.get(ID_CLIENT).toString()) : null;
                ArrayList<Integer> productList = (params.containsKey(LIST_PRODUCT_ID) &&
                        params.get(LIST_PRODUCT_ID) != null) ?
                        (ArrayList<Integer>) params.get(LIST_PRODUCT_ID) : null;
                Double totalCost = (params.containsKey(TOTAL_COST) &&
                        params.get(TOTAL_COST) != null &&
                        !params.get(TOTAL_COST).toString().isEmpty() )
                        ? Double.valueOf(params.get(TOTAL_COST).toString()) : null;
                String deliverDate = (params.containsKey(DELIVER_DATE) &&
                        params.get(DELIVER_DATE) != null &&
                        !params.get(DELIVER_DATE).toString().isEmpty() )
                        ? params.get(DELIVER_DATE).toString() : null;

            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else{
            return "La data recibida para crear un shipment no es correcta o esta vacia";
        }

        return objectResponse;

    }

    @DeleteMapping("/delete")
    public Object deleteClient(@RequestBody String json){
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
