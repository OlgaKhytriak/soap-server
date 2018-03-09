package model;

import javax.xml.bind.annotation.XmlElement;


public class Wallet {

    @XmlElement(name = "walletBalance")
    private double balance;

    public Wallet() {
        this.balance = 100.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
