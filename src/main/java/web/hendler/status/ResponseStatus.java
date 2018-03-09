package web.hendler.status;

public class ResponseStatus {
    //success
    public static final String GET_BALANCE = "balance is received successfully";
    public static final String BUY_GOOD = "product was purchased successfully";
    public static final String REFILL_BALANCE = "balance was refill successfully";

    //fault
    public static final String NO_SUCH_MONEY = "there is no such money";
    public static final String CREDIT_LIMIT_EXCEEDED = "you have exceeded your credit limit";
    public static final String MAX_LIMIT_EXCEEDED = "you have exceeded your maximum limit";
}
