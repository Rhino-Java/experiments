package test.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import test.example.model.Employee;
import test.example.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/createemp", method = RequestMethod.GET)
	public ModelAndView createTable() {
		employeeService.deleteOldTable();
		employeeService.createTable();
		ModelAndView modelAndView = new ModelAndView("displayStatus");
		modelAndView.getModelMap().put("msg", "Table with name Employee is created");
		return modelAndView;
	}

	@RequestMapping(value = "/getemps", method = RequestMethod.GET)
	public ModelAndView getEmployees() {
		List<Employee> emps = employeeService.getEmployees();
		ModelAndView modelAndView = new ModelAndView("displayEmployees");
		modelAndView.getModel().put("empList", emps);
		return modelAndView;
	}

	@RequestMapping(value = "insertemps", method = RequestMethod.GET)
	public ModelAndView insertEmployees() {
		List<Employee> emps = employeeService.insertData();
		ModelAndView modelAndView = new ModelAndView("insertEmployees");
		modelAndView.getModelMap().put("empList", emps);
		return modelAndView;
	}

	@RequestMapping(value = "deleteemps", method = RequestMethod.GET)
	public ModelAndView deleteEmployees() {
		int deletedRows = employeeService.deteteEmployees();
		ModelAndView modelAndView = new ModelAndView("displayStatus");
		modelAndView.getModelMap().put("msg", deletedRows + " rows are deleted from the database");
		return modelAndView;
	}

	@RequestMapping(value = "updateemps", method = RequestMethod.GET)
	public ModelAndView updateEmployees() {
		int updatedRows = employeeService.updateEmployees();
		ModelAndView modelAndView = new ModelAndView("displayStatus");
		modelAndView.getModelMap().put("msg",
				updatedRows + " rows are updated in the database and their department is set to student");
		return modelAndView;
	}
}