package web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="success")
public class StatusSuccess implements Status {
	
	private String message;
	
	public StatusSuccess() {
	}
	
	public StatusSuccess(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
