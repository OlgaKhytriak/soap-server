package web.service.implementation;

import com.epam.dao.BookDAO;
import com.epam.model.Book;
import com.epam.web.model.LibraryWSResponse;
import com.epam.web.model.LibraryWSStatus;
import web.service.LibraryService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.web.service.LibraryService")
public class NewspaperServiceImpl implements LibraryService {
	
	private BookDAO dao = new BookDAO();

	@Override
	public LibraryWSResponse getAllBooks() {
		Object[] results =  dao.getAll().toArray();
		if(results.length != 0){
			return LibraryWSResponse.success(LibraryWSStatus.GET_ALL_BOOKS_MSG,results);
		}
		return  LibraryWSResponse.fault(LibraryWSStatus.NO_BOOKS_MSG);
	}

	@Override
	public LibraryWSResponse getBookByName(String name) {
		Book result = dao.get(name);
		
		if(result != null){
			return  LibraryWSResponse.success(LibraryWSStatus.GET_BOOK_BY_NAME_MSG, result);
		}
		
		return  LibraryWSResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
	}

	
	@Override
	public LibraryWSResponse getBooksByAuthor(String author) {
		Object[] results = dao.getAllByAuthor(author).toArray();
		if(results.length != 0){
			return LibraryWSResponse.success(LibraryWSStatus.GET_BOOKS_BY_AUTHOR_MSG,results);
		}
		return  LibraryWSResponse.fault(LibraryWSStatus.NO_SUCH_AUTHOR_MSG);
	}

	@Override
	public LibraryWSResponse giveBackBook(Book book) {
		if(book != null && isValidBook(book)){
			if (!dao.contains(book)) {
				dao.add(book);
				return LibraryWSResponse.success(LibraryWSStatus.ADD_NEW_BOOK_MSG, book);
			}else{
				return LibraryWSResponse.fault(LibraryWSStatus.THIS_EXISTS_ALREADY_MSG);
			}
		}
		return LibraryWSResponse.fault(LibraryWSStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public LibraryWSResponse changeBook(Book oldBook, Book newBook) {
		if(oldBook != null && newBook != null && isValidBook(oldBook) && isValidBook(newBook)){
			Book result = dao.get(oldBook.getName());
			if(result != null){
				dao.update(oldBook, newBook);
				return LibraryWSResponse.success(LibraryWSStatus.CHANGE_BOOK_MSG, result);
			}else{
				return LibraryWSResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
			}
		}
		return LibraryWSResponse.fault(LibraryWSStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public LibraryWSResponse getBookById(Integer id) {
		Book result = dao.get(id);
		
		if(result != null){
			return  LibraryWSResponse.success(LibraryWSStatus.GET_BOOK_BY_ID_MSG, result);
		}
		
		return  LibraryWSResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
	}
	
	@Override
	public LibraryWSResponse deleteBook(Integer id) {
		boolean result = dao.delete(id);
		
		if(result){
			return  LibraryWSResponse.success(LibraryWSStatus.DELETE_BOOK_MSG, null);
		}
		
		return  LibraryWSResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
	}
	
	private boolean isValidBook(Book book){
		if(book != null &&
				book.getId()!= null &&
				book.getId() > 0 &&
				!book.getAuthor().isEmpty()&&
				!book.getName().isEmpty()&&
				!book.getGenre().isEmpty()){
			return true;
		}
		return false;
	}
	
	

}
