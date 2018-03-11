package web.model;

public class Status {
    public final static String NO_SUCH_NEWS = "No such news";
    public final static String NO_NEWS = "No news";
    public final static String NO_SUCH_CATEGORY = "No such category";
    public final static String INCORRECT_ARGUMENTS = "Arguments incorrect";
    public final static String ALREADY_EXIST = "This news already exists";


    public final static String GET_ALL = "All news was got successfully";
    public final static String GET_BY_TITLE = "News was got successfully by title";
    public final static String GET_BY_CATEGORY = "News was got successfully by category";
    public final static String ADD_NEW = "News was added";
    public final static String UPDATE = "News was updated";
    public final static String GET_BY_ID = "News was got successfully by id";
    public final static String DELETE = "News was removed";
    public Status() {}

    public String getMessage() {
        return null;
    }
}
