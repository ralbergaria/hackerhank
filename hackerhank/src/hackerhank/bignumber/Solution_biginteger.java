package hackerhank.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_biginteger {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a = in.nextBigInteger();
		BigInteger b = in.nextBigInteger();
		System.out.println(a.add(b) + "\n" + a.multiply(b));
	}
}
