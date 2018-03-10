package web.service;

import model.SingleNews;
import web.hendler.NewspaperResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WalletService {

   @WebMethod()
    NewspaperResponse getAllNews();

    @WebMethod()
    NewspaperResponse getNewskByTitle(
            @WebParam(partName = "bookTitle") String title);

    @WebMethod()
    NewspaperResponse getNewsById(
            @WebParam(partName = "newsId") Integer id);

    @WebMethod()
    NewspaperResponse getNewsByCategory(
            @WebParam(partName = "bookCategory") String category);

    @WebMethod()
    NewspaperResponse giveBackNews(@WebParam(partName = "newsToGiveBack") SingleNews singleNews);

    @WebMethod()
    NewspaperResponse changeNews(
            @WebParam(partName = "oldNews") SingleNews oldNews,
            @WebParam(partName = "newNews") SingleNews newNews);

    @WebMethod()
    NewspaperResponse deleteNews(
            @WebParam(partName = "newsId") Integer id);

}
