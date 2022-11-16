package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Client;

import com.jacidi.asignacion.entities.Membership;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.repositories.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.jacidi.asignacion.constants.jacidiConstant.*;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    MembershipRepository membershipRepository;

    //Get all clients
    public Map<String, Object> getAllClient(){
        Map<String, Object> response = new HashMap<>();
        List<Client> clients;
        try{
            clients = clientRepository.findAll();
            if(clients != null){
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, clients);
            }else{
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_CLIENTS_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Get client
    public Map<String, Object> getClientById(int id){
        Map<String, Object> response = new HashMap<>();
        Client client;
        try{
            client = clientRepository.findById(id);
            if (client != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, client);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_CLIENT_FAILED);
            }
        }catch (Exception e){
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Create clients

    public  Map<String, Object> createClient(String name,
                                             String lastName,
                                             String dni,
                                             String email,
                                             Date lastDelivery,
                                             Date nextRenewal,
                                             Integer idMembership){

        Map<String, Object> response = new HashMap<>();
        Client client;
        Membership membership;

        try {
            client = clientRepository.findByEmail(email);
            if (client == null) {
                client = new Client();
                client.setName(name);
                client.setLastName(lastName);
                client.setDni(dni);
                client.setEmail(email);
                client.setLastDelivery(lastDelivery);
                client.setNextRenewal(nextRenewal);
                membership = membershipRepository.findById(idMembership);
                if(membership != null){
                    client.setMembership(membership);

                    clientRepository.save(client);

                    response.put(MESSAGE, MESSAGE_SUCCESS);
                    response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                    response.put(RESPONSE_TEXT, RESPONSE_CREATE_CLIENT_SUCCESS);
                    response.put(RESPONSE_OBJECT, client);
                }else{
                    response.put(MESSAGE, MESSAGE_ERROR);
                    response.put(TYPE, MESSAGE_TYPE_ERROR);
                    response.put(RESPONSE_TEXT, "El membership no existe");
                }


            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_CREATE_CLIENT_FAILED);
            }
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }
        return response;

    }

    //Update Client
    public Map<String, Object> updateClient(Integer id,
                               String name,
                               String lastName,
                               String dni,
                               String email,
                               Date lastDelivery,
                               Date nextRenewal,
                               Integer idMembership){

        Map<String, Object> response = new HashMap<>();
        Client client;
        try{
            client = clientRepository.findById(id);
            if (client != null) {
                client.setName(name);
                client.setLastName(lastName);
                client.setDni(dni);
                client.setEmail(email);
                client.setLastDelivery(lastDelivery);
                client.setNextRenewal(nextRenewal);
                clientRepository.save(client);

                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_TEXT, RESPONSE_UPDATE_CLIENT_SUCCESS);
                response.put(RESPONSE_OBJECT, client);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_UPDATE_CLIENT_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return response;
    }

    //Delete client
    public Map<String, Object> deleteClient(Integer id){
        Map<String, Object> response = new HashMap<>();
        Client client;
        try{
            client = clientRepository.findById(id);
            if (client != null) {
                clientRepository.delete(client);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Cliente eliminado correctamente");
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_CLIENT_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Renewal
    public Map<String, Object> renewal(Integer idClient,
                                       Integer idMembership){

        Map<String, Object> response = new HashMap<>();
        Client client;
        Membership membership;
        Date today = new Date();
        try{
            client = clientRepository.findById(idClient);
            membership = membershipRepository.findById(idMembership);
            if (client != null && membership != null) {
                client.setMembership(membership);
                Date duration = new Date(membership.getDuration());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(today);
                calendar.add(Calendar.DATE, duration.getDay());//TODO: Se debe convertir las fechas a milisegundas sumarlas y devolverla a fecha
                client.setNextRenewal(calendar.getTime());
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Cliente actulizado su membership correctamente");
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, "No es posible actulizar los datos");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return  response;
    }
}
