package org.persistence.lock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SavingsAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;
    private String accountHolder;
    private double accountBalance;

    public SavingsAccount() {
    }

    public SavingsAccount(String accountHolder, double accountBalance) {
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
