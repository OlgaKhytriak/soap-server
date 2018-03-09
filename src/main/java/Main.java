import dao.WalletDao;

public class Main {
    public static void main(String[] args) {
        WalletDao walletDao = new WalletDao();
        System.out.println(walletDao.getBalance());
        System.out.println(walletDao.buyGood(452.0));
        System.out.println(walletDao.cancelTransaction());
        System.out.println(walletDao.getBalance());
    }
}
