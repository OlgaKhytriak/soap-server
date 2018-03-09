package web.hendler.status;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "success")
public class ResponseStatusSuccess extends ResponseStatus {

    private String successStatus;

    public ResponseStatusSuccess() {
    }

    public ResponseStatusSuccess(String successStatus) {
        this.successStatus = successStatus;
    }

    public String getMessage() {
        return successStatus;
    }

    public void setMessage(String successStatus) {
        this.successStatus = successStatus;
    }
}
