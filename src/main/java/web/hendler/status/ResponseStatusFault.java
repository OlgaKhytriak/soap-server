package web.hendler.status;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fault")
public class ResponseStatusFault extends ResponseStatus {

    private String faultStatus;

    public ResponseStatusFault() {
    }

    public ResponseStatusFault(String faultStatus) {
        this.faultStatus = faultStatus;
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus;
    }
}
