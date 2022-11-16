package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import com.jacidi.asignacion.services.ClientService;
import com.jacidi.asignacion.services.MembershipService;
import com.jacidi.asignacion.services.ProductService;
import com.jacidi.asignacion.services.ShipmentService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.io.IOException;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;
import static com.jacidi.asignacion.constants.jacidiConstant.REQUEST_DELETE_SHIPMENT;

@Api(name="Controlador Principal JacidiController", description="Contiene endPoint principales", group="Jacidi")
@ApiVersion(since="1.0")
@RestController
@RequestMapping("")
public class JacidiController {

    @Autowired
    MembershipService membershipService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_RENEWAL_SHIPMENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.PUT, value = URL_RENEW_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object renewMemberShipClient(@RequestBody String json){
        Object objectResult = null;

        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer idClient = (params.containsKey(ID_CLIENT) && params.get(ID_CLIENT) != null
                        && !params.get(ID_CLIENT).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_CLIENT).toString().trim()) : null;

                Integer idMembership = (params.containsKey(ID_MEMBERSHIP) && params.get(ID_MEMBERSHIP) != null
                        && !params.get(ID_MEMBERSHIP).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_MEMBERSHIP).toString().trim()) : null;

                objectResult = clientService.renewal(idClient,idMembership);
            }
            catch (IOException e){
                objectResult = "Json Error";
            }
        }else{
            objectResult = "Error en la data recibida para crear un cliente";
        }

        return objectResult;

    }


    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_REMOVE_PRODUCT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.PUT, value = URL_RENEW_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object  removeProduct(@RequestBody String json){
        Object objectResult = null;

        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer idProduct = (params.containsKey(ID_PRODUCT) && params.get(ID_PRODUCT) != null
                        && !params.get(ID_PRODUCT).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_PRODUCT).toString().trim()) : null;

                Integer idShipment = (params.containsKey(ID_SHIPMENT) && params.get(ID_SHIPMENT) != null
                        && !params.get(ID_SHIPMENT).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_SHIPMENT).toString().trim()) : null;

                objectResult = productService.removeProduct(idProduct,idShipment);
            }
            catch (IOException e){
                objectResult = "Json Error";
            }
        }else{
            objectResult = "Error en la data recibida para crear un cliente";
        }

        return objectResult;
    }
}
