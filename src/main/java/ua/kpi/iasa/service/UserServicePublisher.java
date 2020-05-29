package ua.kpi.iasa.service;

import ua.kpi.iasa.service.impl.UserServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class UserServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/user", new UserServiceImpl());
    }

}
