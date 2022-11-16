package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.services.ProductService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;


@Api(name="Controlador Product", description="Contiene todos los endpoints del Controlador de Products", group="Product")
@ApiVersion(since="1.0")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_PRODUCTS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.GET, value = EMPTY_URI)
    @ApiResponseObject
    @ResponseBody
    @GetMapping()
    public Object getAllProducts() {
        Object objectResult = null;

        try{
            objectResult = productService.getAllProducts();
        }catch (Exception e){
            objectResult = "Error en la consulta";
        }
        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_PRODUCT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_PRODUCT)
    @ApiHeaders(headers ={})
    @ApiResponseObject
    @ResponseBody
    public Object getProduct(HttpServletRequest request, HttpServletResponse response,
                             @ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = productService.getProductById(id);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }
        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_UPDATE_PRODUCT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.PUT, value = REQUEST_UPDATE_PRODUCT)
    @ApiResponseObject
    @ResponseBody
    public Object updateProduct(@RequestBody String json){
        Object objectResponse = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer idProduct = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : null;

                BigDecimal cost = (params.containsKey(COST) && params.get(COST) != null
                        && !params.get(COST).toString().isEmpty())
                        ? BigDecimal.valueOf(Double.valueOf(params.get(COST).toString().trim())): null;

                Integer minPrio = (params.containsKey(MIN_PRIO) && params.get(MIN_PRIO) != null
                        && !params.get(MIN_PRIO).toString().isEmpty())
                        ? Integer.valueOf(params.get(MIN_PRIO).toString().trim()) : null;

                objectResponse = productService.updateProduct(idProduct,name,cost,minPrio);

            } catch(IOException e){
                objectResponse = "Error en la solicitud de creacion";
            }catch (Exception e){
                objectResponse = "Error en la solicitud";
            }
        } else {
            objectResponse = "Json con error";
        }

        return objectResponse;

    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_CREATE_PRODUCT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_CREATE_PRODUCT)
    @ApiResponseObject
    @ResponseBody
    public Object saveProduct(HttpServletRequest request, HttpServletResponse response,
                              @ApiBodyObject(clazz = String.class) @RequestBody String json){
        Object objectResponse = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : null;

                BigDecimal cost = (params.containsKey(COST) && params.get(COST) != null
                        && !params.get(COST).toString().isEmpty())
                        ? BigDecimal.valueOf(Double.valueOf(params.get(COST).toString().trim())): null;

                Integer minPrio = (params.containsKey(MIN_PRIO) && params.get(MIN_PRIO) != null
                        && !params.get(MIN_PRIO).toString().isEmpty())
                        ? Integer.valueOf(params.get(MIN_PRIO).toString().trim()) : null;

                objectResponse = productService.saveProduct(name,cost,minPrio);

            } catch(IOException e){
                objectResponse = "Error en la solicitud de creacion";
            }catch (Exception e){
                objectResponse = "Error en la solicitud";
            }
        } else {
            objectResponse = "Json con error";
        }
        return objectResponse;

    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_DELETE_PRODUCT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.DELETE, value = REQUEST_DELETE_PRODUCT)
    @ApiResponseObject
    @ResponseBody
    public Object deleteProduct(@RequestBody String json){
        Object objectResult = null;
        if(json != null && !json.isEmpty()){
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = productService.deleteProduct(id);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else{
            return "Error en la data recibida para crear un cliente";
        }

        return objectResult;

    }
}
