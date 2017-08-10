package com.restwizard.resources;

import com.restwizard.core.EmployeeDAO;
import com.restwizard.api.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRestController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeRestController.class);
    private Validator validator;

    public EmployeeRestController (Validator validator) {
        this.validator = validator;
    }

    @GET
    public Response getEmployees() {
        LOG.info("getting employees resources");
        return Response.ok (EmployeeDAO.getEmployees()).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Integer id) {
        Employee employee = EmployeeDAO.getEmployeeById(id);
        if (employee != null) {
            return Response.ok (employee).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @POST
    //POST can only be executed via client
    public Response createEmployee (Employee employee) throws Exception {
        if (employee == null) {
            return Response.serverError().entity("Employee object is empty").build();
        } else if (EmployeeDAO.getEmployeeById(employee.getId()) != null) {
            return Response.serverError().entity("Employee already exist. Call the update API to modify the employee details").build();
        } else {
            EmployeeDAO.updateEmployee(employee.getId(), employee);
            return Response.created(new URI("/employees/" + employee.getId())).build();
        }
    }

    @PUT
    @Path("/modify/{id}")
    //PUT can only be executed via client
    public Response updateEmployee (@PathParam("id") Integer id, Employee employee) {
        if (employee != null) {
            EmployeeDAO.updateEmployee(id, employee);
            return Response.ok().build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}
