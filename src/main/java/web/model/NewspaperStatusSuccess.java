package web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="success")
public class NewspaperStatusSuccess extends NewspaperStatus {
	
	private String message;
	
	public NewspaperStatusSuccess() {
	}
	
	public NewspaperStatusSuccess(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
