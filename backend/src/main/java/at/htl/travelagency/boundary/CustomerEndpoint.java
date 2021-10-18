package at.htl.travelagency.boundary;

import at.htl.travelagency.control.BookingRepository;
import at.htl.travelagency.control.CustomerRepository;
import at.htl.travelagency.entity.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@RequestScoped
@Path("/customer")
public class CustomerEndpoint {


    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(customerRepository.findAll()).build();
    }


    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        return Response.ok(customerRepository.findById(id)).build();
    }

    @POST
    @Path("/create")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Customer customer, @Context UriInfo info) {
        customerRepository.persist(customer);
        return Response.created(URI.create(info.getPath() + "/"+ customer.getId())).build();
    }



}
