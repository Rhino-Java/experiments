package test.example;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Service {

	private boolean service1;

	private boolean service2 = true;

	public boolean isService1() {
		return service1;
	}

	public void setService1(boolean service1) {
		this.service1 = service1;
	}

	public boolean isService2() {
		return service2;
	}

	public void setService2(boolean service2) {
		this.service2 = service2;
	}

	public String submit() {
		StringBuilder message = new StringBuilder();
		if (service1) {
			message.append("Service 1 is selected");
		} else {
			message.append("Service 1 is not selected");
		}
		message.append(" and ");
		if (service2) {
			message.append("Service 2 is selected");
		} else {
			message.append("Service 2 is not selected");
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message.toString()));

		return null;
	}
}
