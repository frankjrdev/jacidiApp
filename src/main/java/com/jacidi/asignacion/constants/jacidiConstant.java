package com.jacidi.asignacion.constants;

public interface jacidiConstant {

    static final String URL_REMOVE_PRODUCT = "/ship/removeProduct";
    static final String URL_RENEW_MEMBERSHIP = "/client/renewMembership";
    static final String RESPONSE_GET_CLIENTS_FAILED =  "No se encontraron clientes";
    static final String RESPONSE_GET_CLIENT_FAILED =  "El cliente no existe";
    static final String RESPONSE_GET_SHIPMENTS_FAILED =  "No se encontraron shipments";
    static final String RESPONSE_GET_SHIPMENT_FAILED =  "El shipment no existe";
    static final String RESPONSE_GET_MEMBERSHIPS_FAILED =  "No se encontraron memberships";
    static final String RESPONSE_GET_MEMBERSHIP_FAILED =  "El membership no existe";
    static final String RESPONSE_GET_PRODUCTS_FAILED =  "No se encontraron productos";
    static final String RESPONSE_GET_PRODUCT_FAILED =  "El producto no existe";
    static final String ERROR_CREATE_PRODUCT =  "El producto ya existe o el valor del minPrio esta fuera de rango";
    static final String ERROR_UPDATE_PRODUCT =  "El producto NO existe o el valor del minPrio esta fuera de rango";
    static final String RESPONSE_NEXT_RENEWAL_PAST = "El nextRenewal del cliente tiene una fecha pasada a hoy";

    static final String DATETIME_FORMAT = "yyyy/MM/dd";
    static final String TAG_YYYY_MM_DD = "yyyy-MM-dd";

    //Atributes
    static final String ID_CLIENT = "idClient";
    static final String ID_MEMBERSHIP = "idMembership";
    static final String ID_PRODUCT = "idProduct";
    static final String ID_SHIPMENT = "idShipment";
    static final String LIST_PRODUCT_ID = "listProductId";
    static final String TOTAL_COST = "totalCost";
    static final String DELIVER_DATE = "deliverDate";

    //Request and Responses
    String TEXT_JSON 				         = "text/json";
    String APPLICATION_JSON 		         = "application/json";
    String TYPE 					         = "type";
    String MESSAGE_TYPE_ERROR 		         = "error";
    String MESSAGE 					         = "message";
    String RESPONSE_TEXT                     = "responseText";
    String RESPONSE_OBJECT                   = "responseObject";
    String MESSAGE_ERROR			         = "Ocurrió un error durante el proceso.";
    String MESSAGE_TYPE_SUCCESS 	         = "success";
    String MESSAGE_SUCCESS			         = "Operación exitosa";
    String RESPONSE_CREATE_CLIENT_SUCCESS    = "Cliente creado exitosamente";
    String RESPONSE_UPDATE_CLIENT_SUCCESS    = "Cliente actualizado exitosamente";
    String RESPONSE_UPDATE_CLIENT_FAILED     = "Cliente no pudo ser actualizado";
    String RESPONSE_CREATE_CLIENT_FAILED     = "Cliente no se ha podido crear";
    String RESPONSE_CREATE_MEMBERSHIP_SUCCESS = "Membership creado exitosamente";
    String RESPONSE_UPDATE_MEMBERSHIP_SUCCESS = "Membership actualizado exitosamente";
    String RESPONSE_UPDATE_MEMBERSHIP_FAILED  = "Membership no pudo ser actualizado";
    String RESPONSE_CREATE_MEMBERSHIP_FAILED  = "Membership no se ha podido crear";


    //Params
    String ID = "id";
    String NAME                     = "name";
    String KEY                      = "key";
    String PRIO                     = "prio";
    String DURATION                 = "duration";
    String LASTNAME                 = "lastName";
    String DNI                      = "dni";
    String LAST_DELIVERY            = "lastDelivery";
    String NEXT_RENEWAL             = "nextRenewal";
    String EMAIL                    = "email";
    String COST                     = "cost";
    String MIN_PRIO                  = "minPrio";

    //Uris
    static final String EMPTY_URI = "";

    static final  String REQUEST_GET_MEMBERSHIP = "/getMembership";
    static  final String REQUEST_CREATE_MEMBERSHIP = "/createMembership";
    static  final String REQUEST_UPDATE_MEMBERSHIP = "/updateMembership";
    static  final String REQUEST_DELETE_MEMBERSHIP = "/deleteMembership";
    static final  String REQUEST_GET_PRODUCT = "/getProduct";
    static  final String REQUEST_CREATE_PRODUCT = "/createProduct";
    static  final String REQUEST_UPDATE_PRODUCT = "/updateProduct";
    static  final String REQUEST_DELETE_PRODUCT = "/deleteProduct";
    static final  String REQUEST_GET_CLIENT = "/getClient";
    static  final String REQUEST_CREATE_CLIENT = "/createClient";
    static  final String REQUEST_UPDATE_CLIENT = "/updateClient";
    static  final String REQUEST_DELETE_CLIENT = "/deleteClient";
    static final  String REQUEST_GET_SHIPMENT = "/getShipment";
    static  final String REQUEST_CREATE_SHIPMENT = "/createShipment";
    static  final String REQUEST_UPDATE_SHIPMENT = "/updateShipment";
    static  final String REQUEST_DELETE_SHIPMENT = "/deleteShipment";



    //Templates jsonDoc
    static final String REQUEST_GET_CLIENTS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve todos los clientes existentes. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_CLIENT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_CREATE_CLIENT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>name</b>\" : <em>\"cliente1\"</em>,<br/>"
            +	"    \"<b>lastName</b>\" : <em>\"apellido\"</em>,<br/>"
            +	"    \"<b>dni</b>\" : <em>\"156154\"</em>,<br/>"
            +	"    \"<b>email</b>\" : <em>\"email@prueba.com\"</em>,<br/>"
            +	"    \"<b>lastDelivery</b>\" : <em>\"2022-01-01\"</em>,<br/>"
            +	"    \"<b>nextRenewal</b>\" : <em>\"2022-12-01\"</em>,<br/>"
            +	"    \"<b>idMembership</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_UPDATE_CLIENT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que ACTUALIZA un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/updateClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>name</b>\" : <em>\"cliente1\"</em>,<br/>"
            +	"    \"<b>lastName</b>\" : <em>\"apellido\"</em>,<br/>"
            +	"    \"<b>dni</b>\" : <em>\"156154\"</em>,<br/>"
            +	"    \"<b>email</b>\" : <em>\"email@prueba.com\"</em>,<br/>"
            +	"    \"<b>lastDelivery</b>\" : <em>\"2022-01-01\"</em>,<br/>"
            +	"    \"<b>nextRenewal</b>\" : <em>\"2022-12-01\"</em>,<br/>"
            +	"    \"<b>idMembership</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_DELETE_CLIENT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que elimina un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/deleteClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_MEMBERSHIPS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Memberships Api Param </span></u></h3>"
            + "Método que devuelve todos los memberships existentes. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_MEMBERSHIP_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve un membership. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_CREATE_MEMBERSHIP_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que crea un membership. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>key</b>\" : <em>\"key\"</em>,<br/>"
            +	"    \"<b>name</b>\" : <em>\"membership1\"</em>,<br/>"
            +	"    \"<b>prio</b>\" : <em>25</em>,<br/>"
            +	"    \"<b>duration</b>\" : <em>45465461</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_UPDATE_MEMBERSHIP_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que ACTUALIZA un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/updateClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>name</b>\" : <em>\"cliente1\"</em>,<br/>"
            +	"    \"<b>lastName</b>\" : <em>\"apellido\"</em>,<br/>"
            +	"    \"<b>dni</b>\" : <em>\"156154\"</em>,<br/>"
            +	"    \"<b>email</b>\" : <em>\"email@prueba.com\"</em>,<br/>"
            +	"    \"<b>lastDelivery</b>\" : <em>\"2022-01-01\"</em>,<br/>"
            +	"    \"<b>nextRenewal</b>\" : <em>\"2022-12-01\"</em>,<br/>"
            +	"    \"<b>idMembership</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_DELETE_MEMBERSHIP_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que elimina un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/deleteClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_GET_PRODUCTS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve todos los clientes existentes. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/product </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_PRODUCT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve un producto. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/product/getProduct </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_CREATE_PRODUCT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que crea un producto. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/createProduct. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>name</b>\" : <em>\"producto1\"</em>,<br/>"
            +	"    \"<b>cost</b>\" : <em>10.0</em>,<br/>"
            +	"    \"<b>minPrio</b>\" : <em>54</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_UPDATE_PRODUCT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que actualiza un producto. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/updateProduct. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>name</b>\" : <em>\"producto1\"</em>,<br/>"
            +	"    \"<b>cost</b>\" : <em>10.0</em>,<br/>"
            +	"    \"<b>minPrio</b>\" : <em>54</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_DELETE_PRODUCT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que elimina un producto. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/deleteProduct </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_GET_SHIPMENTS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve todos los clientes existentes. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/shipment </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_SHIPMENT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que devuelve un producto. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/product/getShipment </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_CREATE_SHIPMENT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que crea un shipment. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/createShipment </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id_client</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>deliverDate</b>\" : <em>\"2022-11-01\"</em>,<br/>"
            +	"    \"<b>listProductId</b>\" : <em>[1,2]</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";


    static final String REQUEST_UPDATE_SHIPMENT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que actualiza un shipment. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/updateShipment </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>name</b>\" : <em>\"shipment1\"</em>,<br/>"
            +	"    \"<b>cost</b>\" : <em>10.0</em>,<br/>"
            +	"    \"<b>minPrio</b>\" : <em>54</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_DELETE_SHIPMENT_DESCRIPTION ="<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que elimina un shipment. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/deleteShipment </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>id</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_RENEWAL_SHIPMENT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que renueva el shipment de un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>idClient</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>idMembership</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_REMOVE_PRODUCT_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Clients Api Param </span></u></h3>"
            + "Método que renueva el shipment de un cliente. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> http://localhost:8080/client/getClient. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>idClient</b>\" : <em>1</em>,<br/>"
            +	"    \"<b>idMembership</b>\" : <em>1</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";
}
