package hackerhank;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Solution_formattedpayment {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String us = currencyFormatter.format(payment);
        currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = currencyFormatter.format(payment);
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = currencyFormatter.format(payment);
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = currencyFormatter.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
	}
}
