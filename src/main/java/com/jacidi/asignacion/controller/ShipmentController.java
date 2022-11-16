package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.services.ShipmentService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.jacidi.asignacion.constants.jacidiConstant.*;
import static com.jacidi.asignacion.constants.jacidiConstant.TOTAL_COST;


@Api(name="Controlador Shipment", description="Contiene todos los endpoints del Controlador de Shipment", group="Shipment")
@ApiVersion(since="1.0")
@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_SHIPMENTS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.GET, value = EMPTY_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getAllClients(HttpServletRequest request, HttpServletResponse response) {
        Object objectResult = null;
        try{
            objectResult = shipmentService.getAllShipment();
        }catch (Exception e){
            objectResult = "Error en la consulta";
        }
        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_SHIPMENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_SHIPMENT)
    @ApiResponseObject
    @ResponseBody
    public Object getShipment(HttpServletRequest request, HttpServletResponse response,
                                @ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Object objectResult = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = shipmentService.getShipmentById(id);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_CREATE_SHIPMENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_CREATE_SHIPMENT)
    @ApiResponseObject
    @ResponseBody
    public Object saveShipment(@RequestBody String json){
        Object objectResult= null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer idClient = (params.containsKey(ID_CLIENT) &&
                        params.get(ID_CLIENT) != null &&
                        !params.get(ID_CLIENT).toString().isEmpty() )
                        ? Integer.valueOf(params.get(ID_CLIENT).toString()) : null;
                ArrayList<Integer> productList = (params.containsKey(LIST_PRODUCT_ID) &&
                        params.get(LIST_PRODUCT_ID) != null) ?
                        (ArrayList<Integer>) params.get(LIST_PRODUCT_ID) : null;
                Date deliverDate = (params.containsKey(DELIVER_DATE) &&
                        params.get(DELIVER_DATE) != null &&
                        !params.get(DELIVER_DATE).toString().isEmpty() )
                        ? new SimpleDateFormat(TAG_YYYY_MM_DD).parse(params.get(DELIVER_DATE).toString().trim()) : null;

                objectResult = shipmentService.saveShipment(idClient, productList, deliverDate);

            }
            catch (IOException e){
                e.printStackTrace();
            }catch (Exception e){
                objectResult = "Error en la solicitud";
            }

        }else{
            return "La data recibida para crear un shipment no es correcta o esta vacia";
        }

        return objectResult;

    }


    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_DELETE_SHIPMENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.DELETE, value = REQUEST_DELETE_SHIPMENT)
    @ApiResponseObject
    @ResponseBody
    public Object deleteShipment(@RequestBody String json){
        Object objectResult = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = shipmentService.deleteShipment(id);
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
