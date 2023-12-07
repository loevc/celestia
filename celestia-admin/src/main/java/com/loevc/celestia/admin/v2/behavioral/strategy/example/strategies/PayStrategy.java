package com.loevc.celestia.admin.v2.behavioral.strategy.example.strategies;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:27
 * @Description TODO
 * @Version 1.0
 */
public interface PayStrategy {

    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
