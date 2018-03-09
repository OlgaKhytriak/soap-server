package dao;

import model.Wallet;

public class WalletDao {
    private static Wallet wallet;
    private static double oldBalance;

    public WalletDao() {
        wallet = new Wallet();
    }

    public double getBalance() {
        return wallet.getBalance();
    }

    public double buyGood(double goodPrice) {
        oldBalance = wallet.getBalance();
        wallet.setBalance(oldBalance - goodPrice);
        return wallet.getBalance();
    }

    public double putMoneyOnWallet(double moneyQnt) {
        oldBalance = wallet.getBalance();
        wallet.setBalance(oldBalance + moneyQnt);
        return wallet.getBalance();
    }

    public double cancelTransaction() {
        wallet.setBalance(oldBalance);
        return wallet.getBalance();
    }
}
