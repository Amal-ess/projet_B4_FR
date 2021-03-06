//package com.dummy.myerp.consumer.db;
//
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
///**
// * <p>Classe de gestion des Transactions de persistance</p>
// */
//public class TransactionManager {
//
//    // ==================== Attributs Static ====================
//    /** PlatformTransactionManager pour le DataSource MyERP */
//    private final PlatformTransactionManager ptmMyERP;
//
//
//    // ==================== Constructeurs ====================
//    /**
//     * Constructeur unique de la classe
//     *
//     * @param pPtmMyERP -
//     */
//    public TransactionManager(PlatformTransactionManager pPtmMyERP) {
//        ptmMyERP = pPtmMyERP;
//    }
//
//    // ==================== Méthodes ====================
//    /**
//     * Démarre une transaction sur le DataSource MyERP
//     *
//     * @return TransactionStatus à passer aux méthodes :
//     *      <ul>
//     *          <li>{@link #commitMyERP(TransactionStatus)}</li>
//     *              <li>{@link #rollbackMyERP(TransactionStatus)}</li>
//     *      </ul>
//     */
//    public TransactionStatus beginTransactionMyERP() {
//        DefaultTransactionDefinition vTDef = new DefaultTransactionDefinition();
//        vTDef.setName("Transaction_txManagerMyERP");
//        vTDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//
//        return ptmMyERP.getTransaction(vTDef);
//    }
//
//    /**
//     * Commit la transaction sur le DataSource MyERP
//     *
//     * @param pTStatus retrouné par la méthode {@link #beginTransactionMyERP()}
//     */
//    public void commitMyERP(TransactionStatus pTStatus) {
//        if (pTStatus != null) {
//            ptmMyERP.commit(pTStatus);
//        }
//    }
//
//    /**
//     * Rollback la transaction sur le DataSource MyERP
//     *
//     * @param pTStatus retrouné par la méthode {@link #beginTransactionMyERP()}
//     */
//    public void rollbackMyERP(TransactionStatus pTStatus) {
//        if (pTStatus != null) {
//            ptmMyERP.rollback(pTStatus);
//        }
//    }
//}
