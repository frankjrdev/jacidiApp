package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Membership;
import com.jacidi.asignacion.services.MembershipService;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;
import static com.jacidi.asignacion.constants.jacidiConstant.DELIVER_DATE;

@Api(name="Controlador MemberShip", description="Contiene todos los endpoints del Controlador de MemberShip", group="MemberShip")
@ApiVersion(since="1.0")
@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_MEMBERSHIPS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.GET, value = EMPTY_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getAllMemberships() {
        Object objectResult = null;

        try{
            objectResult = membershipService.getAllMembership();
        }catch (Exception e){
            objectResult = "Error en la consulta";
        }
        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_MEMBERSHIP_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object getMembership(HttpServletRequest request, HttpServletResponse response,
                                    @ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = membershipService.getMemberShipById(id);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_CREATE_MEMBERSHIP_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_CREATE_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object saveMembership(HttpServletRequest request, HttpServletResponse response,
                                @ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String key = (params.containsKey(KEY) && params.get(KEY) != null
                        && !params.get(KEY).toString().isEmpty())
                        ? params.get(KEY).toString().trim() : null;

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : "";

                Integer prio = (params.containsKey(PRIO) && params.get(PRIO) != null
                        && !params.get(PRIO).toString().isEmpty())
                        ? Integer.valueOf(params.get(PRIO).toString().trim()) : null;

                Long duration = (params.containsKey(DURATION) && params.get(DURATION) != null
                        && !params.get(DURATION).toString().isEmpty())
                        ? Long.valueOf(params.get(DURATION).toString().trim()) : null;

                objectResult = membershipService.createMembership(key, name, prio, duration);

            } catch(IOException e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_UPDATE_MEMBERSHIP_DESCRIPTION)
    @RequestMapping(method = RequestMethod.PUT, value = REQUEST_UPDATE_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object updateMembership(HttpServletRequest request, HttpServletResponse response,
                                 @ApiBodyObject(clazz = String.class) @RequestBody String json) {
        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                String key = (params.containsKey(KEY) && params.get(KEY) != null
                        && !params.get(KEY).toString().isEmpty())
                        ? params.get(KEY).toString().trim() : null;

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                        && !params.get(NAME).toString().isEmpty())
                        ? params.get(NAME).toString().trim() : null;

                Integer prio = (params.containsKey(PRIO) && params.get(PRIO) != null
                        && !params.get(PRIO).toString().isEmpty())
                        ? Integer.valueOf(params.get(PRIO).toString().trim()) : null;

                Long duration = (params.containsKey(DURATION) && params.get(DURATION) != null
                        && !params.get(DURATION).toString().isEmpty())
                        ? Long.valueOf(params.get(DURATION).toString().trim()) : null;

                objectResult = membershipService.updateMembership(id, key, name, prio, duration);

            } catch(Exception e){
                objectResult = "Json Error";
            }
        }else {
            objectResult = "Error en la consulta";
        }

        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_DELETE_MEMBERSHIP_DESCRIPTION)
    @RequestMapping(method = RequestMethod.DELETE, value = REQUEST_DELETE_MEMBERSHIP)
    @ApiResponseObject
    @ResponseBody
    public Object deleteMembership(@RequestBody String json){
        Object objectResult = null;
        if (json != null && !json.isEmpty()) {
            try {
                Map<String, Object> params = new ObjectMapper().readerFor(Map.class).readValue(json);

                Integer id = (params.containsKey(ID) && params.get(ID) != null
                        && !params.get(ID).toString().isEmpty())
                        ? Integer.valueOf(params.get(ID).toString().trim()) : null;

                objectResult = membershipService.deleteMembership(id);
            } catch (IOException e) {
                objectResult = "Json Error";
            }
        }else{
            objectResult = "Error en la consulta";
        }

        return objectResult;
    }

}
