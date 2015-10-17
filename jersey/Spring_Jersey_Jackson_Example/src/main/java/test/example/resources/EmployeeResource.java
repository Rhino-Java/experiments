package test.example.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import test.example.model.Employee;
import test.example.services.EmployeeService;

@Path("/employee")
public class EmployeeResource {

	@Autowired
	private EmployeeService service;

	@GET
	@Path("/getEmp/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("name") String name) {
		return service.getEmployee(name);
	}

	@POST
	@Path("/addEmp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {

		Employee employeeAdded = service.addEmployee(emp);

		return Response.status(200).entity(employeeAdded.toString()).build();
	}

}
