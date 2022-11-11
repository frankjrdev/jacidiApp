package com.jacidi.asignacion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Membership;
import com.jacidi.asignacion.services.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.jacidi.asignacion.constants.jacidiConstant.*;
import static com.jacidi.asignacion.constants.jacidiConstant.DELIVER_DATE;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @GetMapping()
    public List<Membership> getAllClients() {
        List<Membership> objectResponse = new ArrayList<>();
        objectResponse = membershipService.getAllMembership();
        return objectResponse;
    }

    @GetMapping("/{id}")
    public Membership getMembership(Integer id) {
        Membership objectResponse = new Membership();
        objectResponse = membershipService.getMemberShipById(id);
        return objectResponse;
    }

    @PutMapping("/{id}")
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

    @PostMapping("/create")
    public Object saveClient(@RequestBody String json){
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
