package com.example.resources;

import javax.ws.rs.*;

@Path("/hello")
public class HelloResource {
    @GET
    public String hello(){
        return "Hello!";
    }
}
