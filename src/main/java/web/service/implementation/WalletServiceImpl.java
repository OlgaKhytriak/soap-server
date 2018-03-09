package web.service.implementation;

import dao.WalletDao;
import web.hendler.WalletResponse;
import web.hendler.status.ResponseStatus;
import web.service.WalletService;

import javax.jws.WebService;

@WebService(endpointInterface = "web.service.WalletService")
public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao = new WalletDao();

    public WalletResponse getBalance() {
        double result = walletDao.getBalance();
        if (result == 0) {
            return WalletResponse.fault(ResponseStatus.NO_SUCH_MONEY);
        }
        return WalletResponse.success(ResponseStatus.GET_BALANCE, result);
    }

    public WalletResponse buyGood(double goodPrice) {
        walletDao.buyGood(goodPrice);
        double balance = walletDao.getBalance();
        if (balance < -50.0) {
            walletDao.cancelTransaction();
            return WalletResponse.fault(ResponseStatus.CREDIT_LIMIT_EXCEEDED);
        }
        return WalletResponse.success(ResponseStatus.BUY_GOOD, balance);
    }

    public WalletResponse putMoneyOnBalance(double moneyQnt) {
        walletDao.putMoneyOnWallet(moneyQnt);
        double balance = walletDao.getBalance();
        if (balance > 1000.0) {
            walletDao.cancelTransaction();
            return WalletResponse.fault(ResponseStatus.MAX_LIMIT_EXCEEDED);
        }
        return WalletResponse.success(ResponseStatus.REFILL_BALANCE, balance);
    }
}
