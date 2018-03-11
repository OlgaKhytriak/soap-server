package web.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fault")
public class StatusFault extends Status {

    private String message;

    public StatusFault() {
    }

    public StatusFault(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
