package web.service.impl;

import dao.NewsPaperDao;
import model.SingleNews;
import web.model.NewspaperResponse;
import web.service.NewspaperService;

import javax.jws.WebService;

import static web.model.Status.*;

@WebService(endpointInterface = "web.service.NewspaperService")
public class NewspaperServiceImpl implements NewspaperService {

    private NewsPaperDao dao = new NewsPaperDao();

    @Override
    public NewspaperResponse getAllNews() {
        Object[] results = dao.getAll().toArray();
        if (results.length != 0) {
            return NewspaperResponse.success(GET_ALL, results);
        }
        return NewspaperResponse.fault(NO_NEWS);
    }

    @Override
    public NewspaperResponse getNewsByTitle(String title) {
        SingleNews result = dao.getByTitle(title);
        if (result != null) {
            return NewspaperResponse.success(GET_BY_TITLE, result);
        }
        return NewspaperResponse.fault(NO_SUCH_NEWS);
    }

    @Override
    public NewspaperResponse getNewsById(Integer id) {
        SingleNews result = dao.getById(id);
        if (result != null) {
            return NewspaperResponse.success(GET_BY_ID, result);
        }
        return NewspaperResponse.fault(NO_SUCH_NEWS);
    }

    @Override
    public NewspaperResponse getNewsByCategory(String category) {
        Object[] results = dao.getByCategory(category).toArray();
        if (results.length != 0) {
            return NewspaperResponse.success(GET_BY_CATEGORY, results);
        }
        return NewspaperResponse.fault(NO_SUCH_CATEGORY);
    }

    @Override
    public NewspaperResponse addNews(SingleNews singleNews) {
        if (singleNews != null && isValidNews(singleNews)) {
            if (!dao.contains(singleNews)) {
                dao.add(singleNews);
                return NewspaperResponse.success(ADD_NEW, singleNews);
            } else {
                return NewspaperResponse.fault(ALREADY_EXIST);
            }
        }
        return NewspaperResponse.fault(INCORRECT_ARGUMENTS);
    }

    @Override
    public NewspaperResponse updateNews(SingleNews oldNews, SingleNews newNews) {
        if (oldNews != null && newNews != null && isValidNews(oldNews) && isValidNews(newNews)) {
            SingleNews result = dao.getByTitle(oldNews.getTitle());
            if (result != null) {
                dao.update(oldNews, newNews);
                return NewspaperResponse.success(UPDATE, result);
            } else {
                return NewspaperResponse.fault(NO_SUCH_NEWS);
            }
        }
        return NewspaperResponse.fault(INCORRECT_ARGUMENTS);
    }

    @Override
    public NewspaperResponse deleteNews(Integer id) {
        boolean result = dao.delete(id);
        if (result) {
            return NewspaperResponse.success(DELETE, null);
        }

        return NewspaperResponse.fault(NO_SUCH_NEWS);
    }

    private boolean isValidNews(SingleNews singleNews) {
        if (singleNews != null &&
                singleNews.getId() != null &&
                singleNews.getId() > 0 &&
                !singleNews.getCategory().isEmpty() &&
                !singleNews.getTitle().isEmpty() &&
                !singleNews.getLink( ).isEmpty() &&
                !singleNews.getDescription().isEmpty()) {
            return true;
        }
        return false;
    }
}
