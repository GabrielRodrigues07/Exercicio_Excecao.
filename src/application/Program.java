package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double iniBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withLimit = sc.nextDouble();
			Account acc = new Account(number, holder, iniBalance, withLimit);
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double valorSaque = sc.nextDouble();
			acc.withdraw(valorSaque);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}

}
