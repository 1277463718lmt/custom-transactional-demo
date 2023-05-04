package com.linmt.transaction.interceptor;

import com.linmt.transaction.context.TransactionStatusContext;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;


@Aspect
@Component
public class CustomTransactionalInterceptor {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    // 匹配所有方法上加上@CustomTransactional注解的方法
    @Pointcut(value = "@annotation(com.linmt.transaction.annocations.CustomTransactional)")
    public void transactionalPointCut() {
    }

    @Before(value = "transactionalPointCut()")
    // 开启事务
    public void beforeTransactionalHandle() {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        TransactionStatusContext.setTransactionStatus(transactionStatus);
    }

    @AfterReturning(value = "transactionalPointCut()")
    // 方法正常返回
    public void afterReturningTransactionalHandle() {
        TransactionStatus transactionStatus = TransactionStatusContext.getTransactionStatus();
        platformTransactionManager.commit(transactionStatus);
    }

    @AfterThrowing(value = "transactionalPointCut()", throwing = "e")
    // 方法异常
    public void afterThrowingTransactionalHandle(Throwable e) {
        TransactionStatus transactionStatus = TransactionStatusContext.getTransactionStatus();
        platformTransactionManager.rollback(transactionStatus);

        // 此处可以根据异常类型进行判断是否回滚
    }
}
