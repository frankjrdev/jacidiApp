package com.jacidi.asignacion.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping()
    public List<Client> getAllClients() {
        List<Client> objectResponse = new ArrayList<>();
        objectResponse = clientService.getAllClient();
        return objectResponse;
    }

    @GetMapping("/{id}")
    public Client getClient(Integer id) {
        Client objectResponse = new Client();
        objectResponse = clientService.getClientById(id);
        return objectResponse;
    }

    @PutMapping("/{id}")
    public Object createClient(@RequestBody String json){
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
