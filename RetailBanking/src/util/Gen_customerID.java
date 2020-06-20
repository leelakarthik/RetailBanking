package util;

public class Gen_customerID {
	public static int Gen_ID() {
		return ((int) (Math.random()*(199999999 - 100000000))) + 100000000;
	}
}
