package com.spring_concepts.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TransactionService_2 {

    /*
        This is the default value.
        If parent transaction exits use it, else will create a new transaction
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserBy(int userId) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

        System.out.println("UPDATING USER WITH ID " + userId);
    }


    /*
       This will create a new transaction every time, irrespective whether parent transaction exists or not.
       It will suspend the parent transaction, continue the current transaction and then resume the parent transaction
    */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserById2(int userId) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

        System.out.println("UPDATING USER WITH ID " + userId);
    }

//    If parent transaction exists use it,
//    else execute the method without any transaction
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateUserById3(String userId) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

        System.out.println("UPDATING USER WITH ID " + userId);
    }


    /*
    * Other values
        * 1.  @Transactional(propagation = Propagation.REQUIRED)
        * 2.  @Transactional(propagation = Propagation.REQUIRES_NEW)
        * 3.  @Transactional(propagation = Propagation.SUPPORTS)
        * 4.  @Transactional(propagation = Propagation.NOT_SUPPORTED)
        *      -> If the parent transaction exists, suspend it execute the method without any transaction, then continue once it got finish
        *      -> execute normally without creating any transactions.
        * 5. @Transactional(propagation = Propagation.MANDATORY)
        *      -> if parent transaction is there, use it else throw exception
        * 6. @Transactional(propagation = Propagation.NEVER)
        *
    * */
}
