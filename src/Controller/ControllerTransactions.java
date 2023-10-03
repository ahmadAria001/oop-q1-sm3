package Controller;

import java.util.HashMap;
import java.util.List;

import ObjectInstances.Transaction;

public class ControllerTransactions {
    private HashMap <Integer,Transaction> listTransaction = new HashMap<>();
    private int idTransaction = 1;
    
    public void showMenuTransaction() {
        
    }

    public void Exec() {
        
    }

    public HashMap<Integer, Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(HashMap<Integer, Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void addBatchTransactions(List<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            listTransaction.put(idTransaction++, transactions.get(i));
        }
    }
    public void addTransactions(Transaction transactions) {
            listTransaction.put(idTransaction++, transactions);
    }
    
    public void removeTransaction(int id) {
        listTransaction.remove(id);
    }
}
