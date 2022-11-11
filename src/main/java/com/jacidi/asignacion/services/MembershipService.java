package com.jacidi.asignacion.services;


import com.jacidi.asignacion.entities.Client;
import com.jacidi.asignacion.entities.Membership;
import com.jacidi.asignacion.entities.Product;
import com.jacidi.asignacion.entities.Shipment;
import com.jacidi.asignacion.repositories.ClientRepository;
import com.jacidi.asignacion.repositories.MembershipRepository;
import com.jacidi.asignacion.repositories.ProductRepository;
import com.jacidi.asignacion.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MembershipService {


    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Membership> getAllMembership(){
        List<Membership> memberships = new ArrayList<>();
        try{
            memberships = membershipRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }

        return memberships;
    }

    public Membership getMemberShipById(int id){
        Membership membership = new Membership();
        try{
            membership = membershipRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
        }

        return membership;
    }


    public Object renewMemberShipClient(Integer idClient, Integer idMembership){

        Object objectResponse = null;
        Membership membership = new Membership();
        Client client = new Client();
        try{

            Date today = new Date();
            membership = membershipRepository.findById(idMembership).get();
            client = clientRepository.findById(idClient).get();

            client.setMembership(membership);

            //Duda con duration (esa duracion es segundos .. en caso de serlo hay que converstirlos en fecha y sumar con today)
            //client.setNextRenewal(today.add);
        }catch (Exception e){
            e.printStackTrace();
        }

        return objectResponse;
    }

    //Create a shipment

    public Object saveShipment(Integer idClient, List<Integer> idProducList, Date deliverDate){
        Shipment shipment = new Shipment();
        try{
            BigDecimal totalCost = new BigDecimal("0");
            Date today = new Date();
            List<Product> products = new ArrayList<>();
            Client client = new Client();
            if(clientRepository.findById(idClient) != null){
                client = clientRepository.findById(idClient).get();
            }

            for (Integer idProduct: idProducList){
                Product product = productRepository.findById(idProduct).get();
                totalCost.add(BigDecimal.valueOf(Double.valueOf(product.getCost().toString())));
            }


            if(today.after(client.getNextRenewal())){
                return "No se pude crear el shipment ya que la fecha de proxima renovacion ya expiro";
            }

            shipment.setClient(client);
            shipment.setDeliverDate(deliverDate);



        }catch (Exception e){
            e.printStackTrace();

        }
        return shipment;
    }

}
