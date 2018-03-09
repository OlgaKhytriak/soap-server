package web.hendler;

import model.Wallet;
import web.hendler.status.ResponseStatus;
import web.hendler.status.ResponseStatusFault;
import web.hendler.status.ResponseStatusSuccess;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "wallet")
public class WalletResponse {

    @XmlElement(name = "value")
    private Object result;

    @XmlElementRefs({
            @XmlElementRef(type = ResponseStatusSuccess.class),
            @XmlElementRef(type = ResponseStatusFault.class)
    })
    private ResponseStatus status;

    private WalletResponse(Object result, ResponseStatus status) {
        this.result = result;
        this.status = status;
    }

    public WalletResponse() {
    }

    private WalletResponse(ResponseStatus status) {
        this.status = status;
    }

    public static WalletResponse success(String status, Object result) {
        return new WalletResponse(result, new ResponseStatusSuccess(status));
    }

    public static WalletResponse fault(String status) {
        return new WalletResponse(new ResponseStatusFault(status));
    }
}
