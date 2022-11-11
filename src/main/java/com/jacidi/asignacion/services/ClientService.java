package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Client;

import com.jacidi.asignacion.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient(){
        List<Client> clients = new ArrayList<>();
        try{
            clients = clientRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return clients;
    }


    public Client getClientById(int id){
        Client clients = new Client();
        try{
            clients = clientRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return clients;
    }

    //Update Client
    public Client updateClient(int id){

        Client client = new Client();
        try{
            if(clientRepository.findById(id) != null){
                client = clientRepository.findById(id);
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        return client;
    }
}
