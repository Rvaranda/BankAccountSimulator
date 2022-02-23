package mainPackage;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		
		Bank bank = new Bank();
		User user = new User();
		user.setWalletMoney(50.0);
		
		while (running) {
			UI.clearScreen();
			UI.mainMenu(bank, user);
			
			int menuChoice = scan.nextInt();
			scan.nextLine();
			
			switch(menuChoice) {
				case 1:
					UI.clearScreen();
					System.out.print("Nome: ");
					user.setName(scan.nextLine());
					BankAccount acc = bank.getAccount(user);
					if (acc != null) {
						UI.clearScreen();
						UI.accessAccountMenu(acc);
						
						int accountMenuChoice = scan.nextInt();
						scan.nextLine();
						
						switch(accountMenuChoice) {
							case 1:
								UI.clearScreen();
								System.out.println("DEPOSITAR");
								System.out.print("\nQuantia: ");
								
								double depositValue = scan.nextDouble();
								scan.nextLine();
								
								if (depositValue > user.getWalletMoney()) {
									System.out.println("Dinheiro insuficiente!");
								}
								else {
									user.setWalletMoney(user.getWalletMoney() - depositValue);
									acc.deposit(depositValue);
									System.out.println("Deposito de R$" + depositValue + " realizado com sucesso.");
								}
								scan.nextLine();
								break;
							case 2:
								UI.clearScreen();
								System.out.println("SACAR");
								System.out.print("\nQuantia: ");
								double withdrawValue = acc.withdraw(scan.nextDouble());
								user.setWalletMoney(user.getWalletMoney() + withdrawValue);
								System.out.println("Saque de R$" + withdrawValue + " realizado com sucesso.");
								scan.nextLine();
								break;
							case 3:
							default:
								break;
						}
					}
					else {
						System.out.println("Não há contas nesse nome. Crie uma conta primeiro.");
						scan.nextLine();
					}
					break;
				case 2:
					UI.clearScreen();
					
					System.out.println("Qual conta quer criar?");
					System.out.println("\n1 - Conta corrente");
					
					System.out.print("\nEscolha: ");
					
					int accountChoice = scan.nextInt();
					scan.nextLine();
					
					if (accountChoice == 1) {
						UI.clearScreen();
						System.out.println("CADASTRO CONTA CORRENTE\n");
						
						System.out.print("Nome: ");
						user.setName(scan.nextLine());
						
						System.out.print("Idade: ");
						user.setAge(scan.nextInt());
						scan.nextLine();
						
						if (bank.getAccount(user.getName()) == null) {
							bank.createAccount(user.getName(), user.getAge());
							System.out.println("\nConta corrente criada com sucesso!");
						}
						else
							System.out.println("\nJá existe uma conta nesse nome.");
						scan.nextLine();
					}
					break;
				case 3:
					bank.endDay();
					break;
				case 4:
				default:
					running = false;
					break;
			}
		}
		
		scan.close();

	}
}
