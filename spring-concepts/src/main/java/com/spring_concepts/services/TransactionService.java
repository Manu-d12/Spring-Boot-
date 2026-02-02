package com.spring_concepts.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TransactionService {

    @Autowired
    private TransactionService_2 transactionService2;


    @Transactional
    public void fetchUserById(int userId) {
        System.out.println("SELECT * FROM USER WHERE ID =: userId");
        System.out.println("LINE_NUMBER_14:IS_TRANSACTION_ACTIVE: " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("LINE_NUMBER_15:TRANSACTION_NAME: " + TransactionSynchronizationManager.getCurrentTransactionName());
//        transactionService2.updateUserBy(userId);
        transactionService2.updateUserById2(userId);
    }

}
