package test.example.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import test.example.model.Employee;

@Path("/jerseyjackon")
public class JerseyJackonResource {

	@GET
	@Path("/getEmp/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("name") String name) {

		Employee emp = new Employee(121, name, "Engineer", "male", "Technical", new Date());

		return emp;

	}

	@POST
	@Path("/addEmp")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) {

		System.out.println("Employee added\n" + emp);

		return Response.status(200).entity(emp.toString()).build();
	}

}
