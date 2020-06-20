package service;

import util.Gen_transactionID;

public class TransactionService {
	public int get_TransID() {
    	return Gen_transactionID.Gen_ID();
    }
}
