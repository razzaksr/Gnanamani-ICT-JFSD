package org.persistence.lock;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LockExecution {
    public static void debit(int required, String app){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            System.out.println(app+" trying to debit ");
            SavingsAccount exists = session.find(SavingsAccount.class,1L, LockMode.PESSIMISTIC_WRITE);
            System.out.println(app+" account to be holded ");
            if(exists.getAccountBalance()>=required){
                exists.setAccountBalance(exists.getAccountBalance()-required);
                System.out.println("Cash "+required+" debited successfully "+app);
            }
            tx.commit();
            System.out.println(app+" account released");
        }
        catch (Exception e){
            tx.rollback();
            System.out.println("Transaction rolled back");
        }
        session.close();
    }
    public static void main(String[] args) {
        Thread t1 =  new Thread(()->debit(400,"gpay"));
        Thread t2 =  new Thread(()->debit(50,"phonepe"));
        t1.start();
        try {
            t2.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
