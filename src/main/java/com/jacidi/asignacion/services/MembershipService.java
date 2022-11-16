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
import java.util.*;

import static com.jacidi.asignacion.constants.jacidiConstant.*;

@Service
public class MembershipService {


    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;


    //Get all memberships
    public Map<String, Object> getAllMembership(){
        Map<String, Object> response = new HashMap<>();
        List<Membership> memberships;
        try{
            memberships = membershipRepository.findAll();
            if(memberships != null){
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, memberships);
            }else{
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_MEMBERSHIPS_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }


    //Get membership
    public Map<String, Object> getMemberShipById(Integer id){
        Map<String, Object> response = new HashMap<>();
        Membership membership;
        try{
            membership = membershipRepository.findById(id);
            if (membership != null) {
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, membership);
            } else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_MEMBERSHIP_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    //Create membership
    public Map<String, Object> createMembership(String key,
                                       String name,
                                       Integer prio,
                                       Long duration){

        Map<String, Object> response = new HashMap<>();
        Membership membership;
        try{
            membership = membershipRepository.findByKey(key);
            if(membership == null){
                membership = new Membership();
                membership.setKey(key);
                membership.setName(name);
                membership.setDuration(duration);
                membership.setPrio(prio);

                membershipRepository.save(membership);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_TEXT, RESPONSE_CREATE_MEMBERSHIP_SUCCESS);
                response.put(RESPONSE_OBJECT, membership);
            }else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_CREATE_MEMBERSHIP_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Update membership
    public Map<String, Object> updateMembership(Integer id,
                                                String key,
                                                String name,
                                                Integer prio,
                                                Long duration){

        Map<String, Object> response = new HashMap<>();
        Membership membership;
        try{
            membership = membershipRepository.findByKey(key);
            if(membership != null){
                membership.setKey(key);
                membership.setName(name);
                membership.setDuration(duration);
                membership.setPrio(prio);

                membershipRepository.save(membership);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_TEXT, RESPONSE_UPDATE_MEMBERSHIP_SUCCESS);
                response.put(RESPONSE_OBJECT, membership);
            }else {
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_UPDATE_MEMBERSHIP_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }

    //Delete membership
    public Map<String, Object> deleteMembership(Integer id){
        Map<String, Object> response = new HashMap<>();
        Membership membership;

        try{
            membership = membershipRepository.findById(id);
            if(membership != null){
                membershipRepository.delete(membership);
                response.put(MESSAGE, MESSAGE_SUCCESS);
                response.put(TYPE, MESSAGE_TYPE_SUCCESS);
                response.put(RESPONSE_OBJECT, "Cliente eliminado correctamente");
            }else{
                response.put(MESSAGE, MESSAGE_ERROR);
                response.put(TYPE, MESSAGE_TYPE_ERROR);
                response.put(RESPONSE_TEXT, RESPONSE_GET_MEMBERSHIP_FAILED);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }


        return response;
    }


    public Object renewMemberShipClient(Integer idClient, Integer idMembership){

        Object objectResponse = null;
        Membership membership;
        Client client;
        try{

            Date today = new Date();
            membership = membershipRepository.findById(idMembership);
            client = clientRepository.findById(idClient);

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
                client = clientRepository.findById(idClient);
            }

            for (Integer idProduct: idProducList){
                Product product = productRepository.findById(idProduct);
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
