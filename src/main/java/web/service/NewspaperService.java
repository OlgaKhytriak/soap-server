package web.service;

import model.SingleNews;
import web.hendler.NewspaperResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface NewspaperService {

   @WebMethod()
    NewspaperResponse getAllNews();

    @WebMethod()
    NewspaperResponse getNewsByTitle(
            @WebParam(partName = "news-title") String title);

    @WebMethod()
    NewspaperResponse getNewsById(
            @WebParam(partName = "news-id") Integer id);

    @WebMethod()
    NewspaperResponse getNewsByCategory(
            @WebParam(partName = "news-category") String category);

    @WebMethod()
    NewspaperResponse addNews(@WebParam(partName = "news-to-add") SingleNews singleNews);

    @WebMethod()
    NewspaperResponse changeNews(
            @WebParam(partName = "old-news") SingleNews oldNews,
            @WebParam(partName = "new-news") SingleNews newNews);

    @WebMethod()
    NewspaperResponse deleteNews(
            @WebParam(partName = "news-id") Integer id);

}
