package test.example;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * If following error occurred while setting up the Spring MVC project -
 * 
 *  Cannot change version of project facet Dynamic Web Module to 3.1
 *  
 *  Change the dynamic web module version to 3.1 in org.eclipse.wst.common.project.facet.core file present in .settings folder -
 *  
 *  <installed facet="jst.web" version="3.1"/>
 *  
 *  And then update Maven project.
 */

@Controller
public class HelloWorldController {

	@RequestMapping(value = { "/", "/hello" })
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "helloworld";
		/**
		 * It will look for the jsp file with name helloworld.jsp inside folder
		 * /WEB-INF/views/
		 */
	}
}
