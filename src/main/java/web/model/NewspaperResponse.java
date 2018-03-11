package web.model;

import model.SingleNews;

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

    @XmlElementRefs({@XmlElementRef(type = StatusSuccess.class), @XmlElementRef(type = StatusFault.class)})
    private Status status;

    public NewspaperResponse() {
    }

    private NewspaperResponse(Status status, Object result) {
        this.result = result;
        this.status = status;
    }

    private NewspaperResponse(Status status, Object[] results) {
        this.results = results;
        this.status = status;
    }

    private NewspaperResponse(Status status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static NewspaperResponse success(String status, Object result) {
        return new NewspaperResponse(new StatusSuccess(status), result);
    }

    public static NewspaperResponse success(String status, Object[] results) {
        return new NewspaperResponse(new StatusSuccess(status), results);
    }

    public static NewspaperResponse fault(String status) {
        return new NewspaperResponse(new StatusFault(status));
    }






}
