package com.linmt.transaction.context;

import org.springframework.transaction.TransactionStatus;

public class TransactionStatusContext {
    private static ThreadLocal<TransactionStatus> threadLocal = new ThreadLocal<>();

    public static void setTransactionStatus(TransactionStatus transactionStatus) {
        threadLocal.set(transactionStatus);
    }

    public static TransactionStatus getTransactionStatus() {
        return threadLocal.get();
    }

    public static void clearTransactionStatus() {
        threadLocal.remove();
    }
}
