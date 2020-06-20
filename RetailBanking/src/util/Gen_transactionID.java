package util;

public class Gen_transactionID {
	public static int Gen_ID() {
		return ((int) (Math.random()*(599999999 - 200000000))) + 200000000;
	}
}
