package test.example;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Service {

	private String services1 = "4";

	private String services2;

	public String getServices1() {
		return services1;
	}

	public void setServices1(String services1) {
		this.services1 = services1;
	}

	public String getServices2() {
		return services2;
	}

	public void setServices2(String services2) {
		this.services2 = services2;
	}

	public String submit() {
		StringBuilder message = new StringBuilder();
		if (services1 != null && !services1.isEmpty()) {
			message.append("Numeric service " + services1 + " is selected");
		} else {
			message.append("No numeric service is selected");
		}
		message.append(" and ");
		if (services2 != null && !services2.isEmpty()) {
			message.append("Alphabet service " + services2 + " is selected");
		} else {
			message.append("No alphabet service is selected");
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message.toString()));

		return null;
	}
}
