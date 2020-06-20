package util;

public class Gen_accountID {
	public static int Gen_ID() {
		return ((int) (Math.random()*(699999999 - 600000000))) + 600000000;
	}
}
