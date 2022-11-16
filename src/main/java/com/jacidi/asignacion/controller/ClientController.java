package com.jacidi.asignacion.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.services.ClientService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;

@Api(name="Controlador Client", description="Contiene todos los endpoints del Controlador de Clients", group="Client")
@ApiVersion(since="1.0")
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_CLIENTS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.GET, value = EMPTY_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getAllClients(HttpServletRequest request, HttpServletResponse response) {
        Object objectResult = null;

        try{
            objectResult = clientService.getAllClient();
        }catch (Exception e){
            objectResult = "Error en la consulta";
        }
        return objectResult;
    }


    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_MEMBERSHIP_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_CLIENT)
    @ApiResponseObject
    @ResponseBody
    public Object getClient(HttpServletRequest request, HttpServletResponse response,
                            @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = clientService.getClientById(id);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;

    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_CREATE_CLIENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_CREATE_CLIENT)
    @ApiResponseObject
    @ResponseBody
    public Object saveClient(HttpServletRequest request, HttpServletResponse response,
                               @ApiBodyObject(clazz = String.class) @RequestBody String json){
        Object objectResponse = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : null;

                String lastName = (params.containsKey(LASTNAME) && params.get(LASTNAME) != null
                        && !params.get(LASTNAME).toString().isEmpty())
                        ? params.get(LASTNAME).toString().trim() : null;

                String dni = (params.containsKey(DNI) && params.get(DNI) != null
                        && !params.get(DNI).toString().isEmpty())
                        ? params.get(DNI).toString().trim() : null;

                String email = (params.containsKey(EMAIL) && params.get(EMAIL) != null
                        && !params.get(EMAIL).toString().isEmpty())
                        ? params.get(EMAIL).toString().trim() : null;

                Date lastDelivery = (params.containsKey(LAST_DELIVERY) && params.get(LAST_DELIVERY) != null
                        && !params.get(LAST_DELIVERY).toString().isEmpty())
                        ?  new SimpleDateFormat(TAG_YYYY_MM_DD).parse(params.get(LAST_DELIVERY).toString()) : null;

                Date nextRenewal = (params.containsKey(NEXT_RENEWAL) && params.get(NEXT_RENEWAL) != null
                        && !params.get(NEXT_RENEWAL).toString().isEmpty())
                        ?  new SimpleDateFormat(TAG_YYYY_MM_DD).parse(params.get(NEXT_RENEWAL).toString()) : null;

                Integer idMembership = (params.containsKey(ID_MEMBERSHIP) && params.get(ID_MEMBERSHIP) != null
                        && !params.get(ID_MEMBERSHIP).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_MEMBERSHIP).toString().trim()) : null;

                objectResponse = clientService.createClient(name,lastName,dni,email,lastDelivery,nextRenewal,idMembership);

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

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_UPDATE_CLIENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.PUT, value = REQUEST_UPDATE_CLIENT)
    @ApiResponseObject
    @ResponseBody
    public Object updateClient(@RequestBody String json){
        Object objectResponse = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer idClient = (params.containsKey(ID_CLIENT) && params.get(ID_CLIENT) != null
                        && !params.get(ID_CLIENT).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_CLIENT).toString().trim()) : null;

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : null;

                String lastName = (params.containsKey(LASTNAME) && params.get(LASTNAME) != null
                        && !params.get(LASTNAME).toString().isEmpty())
                        ? params.get(LASTNAME).toString().trim() : null;

                String dni = (params.containsKey(DNI) && params.get(DNI) != null
                        && !params.get(DNI).toString().isEmpty())
                        ? params.get(DNI).toString().trim() : null;

                String email = (params.containsKey(EMAIL) && params.get(EMAIL) != null
                        && !params.get(EMAIL).toString().isEmpty())
                        ? params.get(EMAIL).toString().trim() : null;

                Date lastDelivery = (params.containsKey(LAST_DELIVERY) && params.get(LAST_DELIVERY) != null
                        && !params.get(LAST_DELIVERY).toString().isEmpty())
                        ?  new SimpleDateFormat(DATETIME_FORMAT).parse(params.get(LAST_DELIVERY).toString().trim()) : null;

                Date nextRenewal = (params.containsKey(NEXT_RENEWAL) && params.get(NEXT_RENEWAL) != null
                        && !params.get(NEXT_RENEWAL).toString().isEmpty())
                        ?  new SimpleDateFormat(DATETIME_FORMAT).parse(params.get(NEXT_RENEWAL).toString().trim()) : null;

                Integer idMembership = (params.containsKey(ID_MEMBERSHIP) && params.get(ID_MEMBERSHIP) != null
                        && !params.get(ID_MEMBERSHIP).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID_MEMBERSHIP).toString().trim()) : null;

                objectResponse = clientService.updateClient(idClient, name,lastName,dni,email,lastDelivery,nextRenewal,idMembership);

            } catch(IOException e){
                objectResponse = "Error en la solicitud de actualizacion";
            }catch (Exception e){
                objectResponse = "Error en la solicitud";
            }
        } else {
            objectResponse = "Json con error";
        }
        return objectResponse;

    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_DELETE_CLIENT_DESCRIPTION)
    @RequestMapping(method = RequestMethod.DELETE, value = REQUEST_DELETE_CLIENT)
    @ApiResponseObject
    @ResponseBody
    public Object deleteClient(@RequestBody String json){
        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = clientService.deleteClient(id);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;

    }


}
