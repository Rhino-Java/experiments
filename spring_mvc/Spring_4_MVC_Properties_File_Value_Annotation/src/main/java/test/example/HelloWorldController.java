package test.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@Autowired
	private ConfigParams configParams;

	@RequestMapping(value = { "/", "/hello" })
	public String hello(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);

		model.addAttribute("driverClassName",
				configParams.getDbDriverClassName());
		model.addAttribute("url", configParams.getDbUrl());
		model.addAttribute("username", configParams.getDbUsername());
		model.addAttribute("password", configParams.getDbPassword());
		
		return "helloworld";
		/**
		 * It will look for the jsp file with name helloworld.jsp inside folder
		 * /WEB-INF/views/
		 */
	}
}
