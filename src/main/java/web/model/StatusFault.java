package web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fault")
public class StatusFault implements Status{
	
	private String message;
	
	public StatusFault() {}
	
	public StatusFault(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
