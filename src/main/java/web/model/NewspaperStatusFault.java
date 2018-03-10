package web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="fault")
public class NewspaperStatusFault extends NewspaperStatus {
	
	private String message;
	
	public NewspaperStatusFault() {}
	
	public NewspaperStatusFault(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
