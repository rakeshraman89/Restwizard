package com.restwizard.rest.controller;

import com.restwizard.rest.dao.EmployeeDAO;
import com.restwizard.rest.representations.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
        LOG.info("getting employees controller");
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
}
