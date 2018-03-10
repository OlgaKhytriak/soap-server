package web.service.implementation;

import dao.NewsPaperDao;
import model.SingleNews;
import web.hendler.NewspaperResponse;
import web.model.NewspaperStatus;
import web.service.NewspaperService;

import javax.jws.WebService;

@WebService(endpointInterface = "web.service.NewspaperService")
public class NewspaperServiceImpl implements NewspaperService {
	
	private NewsPaperDao dao = new NewsPaperDao();

	@Override
	public NewspaperResponse getAllNews() {
		Object[] results =  dao.getAll().toArray();
		if(results.length != 0){
			return NewspaperResponse.success(NewspaperStatus.GET_ALL_BOOKS_MSG,results);
		}
		return  NewspaperResponse.fault(NewspaperStatus.NO_BOOKS_MSG);
	}

	@Override
	public NewspaperResponse getNewsByTitle(String title) {
		SingleNews result = dao.getByTitle(title);

		if(result != null){
			return  NewspaperResponse.success(NewspaperStatus.GET_BOOK_BY_NAME_MSG, result);
		}

		return  NewspaperResponse.fault(NewspaperStatus.NO_SUCH_BOOK_MSG);
	}

	@Override
	public NewspaperResponse getNewsById(Integer id) {
		SingleNews result = dao.getById(id);

		if(result != null){
			return  NewspaperResponse.success(NewspaperStatus.GET_BOOK_BY_ID_MSG, result);
		}

		return  NewspaperResponse.fault(NewspaperStatus.NO_SUCH_BOOK_MSG);
	}

	@Override
	public NewspaperResponse getNewsByCategory(String category) {
		Object[] results = dao.getByCategory(category).toArray();
		if(results.length != 0){
			return NewspaperResponse.success(NewspaperStatus.GET_BOOKS_BY_AUTHOR_MSG,results);
		}
		return  NewspaperResponse.fault(NewspaperStatus.NO_SUCH_AUTHOR_MSG);
	}

	@Override
	public NewspaperResponse giveBackNews(SingleNews singleNews) {
		if(singleNews != null && isValidNews(singleNews)){
			if (!dao.contains(singleNews)) {
				dao.add(singleNews);
				return NewspaperResponse.success(NewspaperStatus.ADD_NEW_BOOK_MSG, singleNews);
			}else{
				return NewspaperResponse.fault(NewspaperStatus.THIS_EXISTS_ALREADY_MSG);
			}
		}
		return NewspaperResponse.fault(NewspaperStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public NewspaperResponse changeNews(SingleNews oldNews, SingleNews newNews) {
		if(oldNews != null && newNews != null && isValidNews(oldNews) && isValidNews(newNews)){
			SingleNews result = dao.getByTitle(oldNews.getTitle());
			if(result != null){
				dao.update(oldNews, newNews);
				return NewspaperResponse.success(NewspaperStatus.CHANGE_BOOK_MSG, result);
			}else{
				return NewspaperResponse.fault(NewspaperStatus.NO_SUCH_BOOK_MSG);
			}
		}
		return NewspaperResponse.fault(NewspaperStatus.NOT_CORRECT_ARGUMENTS_MSG);
	}

	@Override
	public NewspaperResponse deleteNews(Integer id) {
		boolean result = dao.delete(id);

		if(result){
			return  NewspaperResponse.success(NewspaperStatus.DELETE_BOOK_MSG, null);
		}

		return  NewspaperResponse.fault(NewspaperStatus.NO_SUCH_BOOK_MSG);
	}

	private boolean isValidNews(SingleNews singleNews){
		if(singleNews != null &&
				singleNews.getId()!= null &&
				singleNews.getId() > 0 &&
				!singleNews.getCategory().isEmpty()&&
				!singleNews.getTitle().isEmpty()&&
				!singleNews.getLink().isEmpty()&&
				!singleNews.getDescription().isEmpty()){
			return true;
		}
		return false;
	}
}
