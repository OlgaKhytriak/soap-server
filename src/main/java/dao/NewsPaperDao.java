package dao;

import model.SingleNews;

import java.util.ArrayList;
import java.util.List;

public class NewsPaperDao {
    private List<SingleNews> newsList;

    public NewsPaperDao() {
        newsList = new ArrayList<>();
        init();
    }

    private void init() {
        newsList.add(new SingleNews(1, "Gold-medal", "Sport", "Gold medalist Abramenko carries Ukrainian flag at Winter Olympics 2018 closing ceremony", "https://24tv.ua"));
        newsList.add(new SingleNews(2, "Big-Bang", "Science", "At the time of the Big Bang, all the matter in the universe was smooshed into an incredibly hot, infinitely dense speck of matter.", "https://www.ukr.net"));
        newsList.add(new SingleNews(3, "Luxury-labels", "Society", "The luxury labels coming out of Africa", "http://www.bbc.com"));
        newsList.add(new SingleNews(4, "Box", "Sport", "Ukrainian Artem Dalakian becomes new WBA flyweight champion", "https://zik.ua"));
        newsList.add(new SingleNews(5, "Dark-Wave", "Science", "At the edge of life and death is a spreading dark wave", "https://newsone.ua"));
        newsList.add(new SingleNews(6, "Heart-attack", "Health", "Waist size bigger heart attack risk in women, report says", "https://www.telegraph.co.uk"));
        newsList.add(new SingleNews(7, "Olympics", "Sport", "Winter Olympics 2018 Schedule of Ukrainian team", "https://news.sky.com"));
        newsList.add(new SingleNews(8, "Religious-Mummies", "Science", "At least 40 limestone sarcophagi that held mummified burials were discovered in the cemetery.", "https://www.express.co.uk"));
        newsList.add(new SingleNews(9, "Penguin-colony", "Nature", "Penguin super-colony spotted from space", "http://www.bbc.com/news"));
        newsList.add(new SingleNews(10, "Shakhtar", "Sport", "Shakhtar Donetsk beats Roma", "https://www.theverge.com"));
    }

    public void add(SingleNews news) {
        newsList.add(news);
    }

    public List<SingleNews> getAll() {
        return newsList;
    }

    public SingleNews getById(Integer id) {
        for (SingleNews singleNews : newsList) {
            if (singleNews.getId().equals(id)) {
                return singleNews;
            }
        }
        return null;
    }

    public List<SingleNews> getByCategory(String category) {
        List<SingleNews> list = new ArrayList<>();
        for (SingleNews singleNews : newsList) {
            if (singleNews.getCategory().equals(category)) {
                list.add(singleNews);
            }
        }
        return list;
    }

    public SingleNews getByTitle(String title) {
        for (SingleNews singleNews : newsList) {
            if (singleNews.getTitle().equals(title)) {
                return singleNews;
            }
        }
        return null;
    }

    public boolean delete(Integer id) {
        int beforeDeleteSize=newsList.size();
        SingleNews newsToDelete = newsList.get(id);
        newsList.remove(newsToDelete);
        return (newsList.size()==beforeDeleteSize-1);
    }

    public void update(SingleNews oldSingleNews, SingleNews newSingleNews) {
        newsList.remove(oldSingleNews);
        newsList.add(newSingleNews);
    }
    public boolean contains(SingleNews singleNews){
        return newsList.contains(singleNews);
    }
}
