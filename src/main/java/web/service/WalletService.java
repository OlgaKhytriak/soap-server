package web.service;

import web.hendler.WalletResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WalletService {

    @WebMethod()
    WalletResponse getBalance();

    @WebMethod()
    WalletResponse buyGood(
            @WebParam(partName = "goodPrice") double goodPrice);

    @WebMethod()
    WalletResponse putMoneyOnBalance(
            @WebParam(partName = "moneyQnt") double moneyQnt);
}
