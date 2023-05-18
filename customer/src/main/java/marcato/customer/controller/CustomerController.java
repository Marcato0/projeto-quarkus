package marcato.customer.controller;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import marcato.customer.dto.CustomerDTO;
import marcato.customer.service.CustomerService;

import java.awt.*;
import java.awt.geom.RectangularShape;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO findCustomerById(@PathParam("id") Long id){
        return customerService.findCustomerById(id);
    }


    @POST
    @Transactional
    public Response saveCustomers(CustomerDTO customerDTO){

        try {
            customerService.createNewCustomer(customerDTO);
            return Response.ok().build();
        }

        catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeCustomer(@PathParam("id")Long id, CustomerDTO customerDTO){

        try {
            customerService.changeCustomer(id, customerDTO);
            return Response.accepted().build();
        }

        catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id")Long id){

        try {
            customerService.deleteCustomer(id);
            return Response.accepted().build();
        }

        catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
