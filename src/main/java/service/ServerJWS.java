package service;

import javax.xml.ws.Endpoint;

public class ServerJWS {

    public static void main(String[] args) {

        String url = "http://localhost:8089/";
        Endpoint.publish(url, new EmploiService());
        System.out.println("Service SOAP publié à l'adresse : " + url);
    }
}
