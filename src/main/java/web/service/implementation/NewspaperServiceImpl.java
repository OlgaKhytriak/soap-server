package web.service.implementation;

import com.epam.dao.BookDAO;
import com.epam.model.Book;
import com.epam.web.model.LibraryWSResponse;
import com.epam.web.model.LibraryWSStatus;
import web.hendler.NewspaperResponse;
import web.service.LibraryService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.web.service.LibraryService")
public class NewspaperServiceImpl implements NewspaperService {
	
	private BookDAO dao = new BookDAO();

	@Override
	public NewspaperResponse getAllBooks() {
		Object[] results =  dao.getAll().toArray();
		if(results.length != 0){
			return NewspaperResponse.success(LibraryWSStatus.GET_ALL_BOOKS_MSG,results);
		}
		return  NewspaperResponse.fault(LibraryWSStatus.NO_BOOKS_MSG);
	}

	@Override
	public NewspaperResponse getBookByName(String name) {
		Book result = dao.get(name);
		
		if(result != null){
			return  NewspaperResponse.success(LibraryWSStatus.GET_BOOK_BY_NAME_MSG, result);
		}
		
		return  NewspaperResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
	}

	
	@Override
	public NewspaperResponse getBooksByAuthor(String author) {
		Object[] results = dao.getAllByAuthor(author).toArray();
		if(results.length != 0){
			return NewspaperResponse.success(LibraryWSStatus.GET_BOOKS_BY_AUTHOR_MSG,results);
		}
		return  NewspaperResponse.fault(LibraryWSStatus.NO_SUCH_AUTHOR_MSG);
	}

	@Override
	public NewspaperResponse giveBackBook(Book book) {
		if(book != null && isValidBook(book)){
			if (!dao.contains(book)) {
				dao.add(book);
				return NewspaperResponse.success(LibraryWSStatus.ADD_NEW_BOOK_MSG, book);
			}else{
				return NewspaperResponse.fault(LibraryWSStatus.THIS_EXISTS_ALREADY_MSG);
			}
		}
		return NewspaperResponse.fault(LibraryWSStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public NewspaperResponse changeBook(Book oldBook, Book newBook) {
		if(oldBook != null && newBook != null && isValidBook(oldBook) && isValidBook(newBook)){
			Book result = dao.get(oldBook.getName());
			if(result != null){
				dao.update(oldBook, newBook);
				return NewspaperResponse.success(LibraryWSStatus.CHANGE_BOOK_MSG, result);
			}else{
				return NewspaperResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
			}
		}
		return NewspaperResponse.fault(LibraryWSStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public NewspaperResponse getBookById(Integer id) {
		Book result = dao.get(id);
		
		if(result != null){
			return  NewspaperResponse.success(LibraryWSStatus.GET_BOOK_BY_ID_MSG, result);
		}
		
		return  NewspaperResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
	}
	
	@Override
	public NewspaperResponse deleteBook(Integer id) {
		boolean result = dao.delete(id);
		
		if(result){
			return  NewspaperResponse.success(LibraryWSStatus.DELETE_BOOK_MSG, null);
		}
		
		return  NewspaperResponse.fault(LibraryWSStatus.NO_SUCH_BOOK_MSG);
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
