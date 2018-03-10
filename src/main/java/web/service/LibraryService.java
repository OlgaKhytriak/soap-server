package web.service;

import com.epam.model.Book;
import com.epam.web.model.LibraryWSResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LibraryService {
	
	@WebMethod()
	LibraryWSResponse getAllBooks();
	
	@WebMethod()
	LibraryWSResponse getBookByName(
            @WebParam(partName = "bookName") String name);

	@WebMethod()
	LibraryWSResponse getBookById(
            @WebParam(partName = "bookId") Integer id);

	@WebMethod()
	LibraryWSResponse getBooksByAuthor(
            @WebParam(partName = "bookAuthor") String author);

	@WebMethod()
	LibraryWSResponse giveBackBook(@WebParam(partName = "bookToGiveBack") Book book);

	@WebMethod()
	LibraryWSResponse changeBook(
            @WebParam(partName = "oldBook") Book oldBook,
            @WebParam(partName = "newBook") Book newBook);

	@WebMethod()
	LibraryWSResponse deleteBook(
            @WebParam(partName = "bookId") Integer id);
	
	
	

}
