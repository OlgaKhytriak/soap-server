package web.hendler;

import model.SingleNews;
import web.model.NewspaperStatus;
import web.model.NewspaperStatusFault;
import web.model.NewspaperStatusSuccess;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;

@XmlAccessorType(XmlAccessType.FIELD)
public class NewspaperResponse {

    @XmlElementRef(type = SingleNews.class)
    private Object result;

    @XmlElementRef(type = SingleNews.class)
    private Object[] results;

    @XmlElementRefs({@XmlElementRef(type = NewspaperStatusSuccess.class), @XmlElementRef(type = NewspaperStatusFault.class)})
    private NewspaperStatus status;

    public NewspaperResponse() {
    }

    private NewspaperResponse(NewspaperStatus status, Object result) {
        this.result = result;
        this.status = status;
    }

    private NewspaperResponse(NewspaperStatus status, Object[] results) {
        this.results = results;
        this.status = status;
    }

    private NewspaperResponse(NewspaperStatus status) {
        this.status = status;
    }

    public static NewspaperResponse success(String status, Object result) {
        return new NewspaperResponse(new NewspaperStatusSuccess(status), result);
    }

    public static NewspaperResponse success(String status, Object[] results) {
        return new NewspaperResponse(new NewspaperStatusSuccess(status), results);
    }

    public static NewspaperResponse fault(String status) {
        return new NewspaperResponse(new NewspaperStatusFault(status));
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


}
