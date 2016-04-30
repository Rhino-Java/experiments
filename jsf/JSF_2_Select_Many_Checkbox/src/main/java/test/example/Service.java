package test.example;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Service {

	public String[] services = new String[] { "1", "5" };

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

	public String submit() {
		StringBuilder message = new StringBuilder();

		boolean isFirst = true;
		for (String str : services) {
			if (isFirst) {
				message.append("Services selected - ");
				message.append(str);
				isFirst = false;
			} else {
				message.append(", ");
				message.append(str);
			}
		}
		if (message.toString().isEmpty()) {
			message.append("No service is selected.");
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message.toString()));

		return null;

	}

}
