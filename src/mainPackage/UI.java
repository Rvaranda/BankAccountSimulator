package mainPackage;

import java.io.IOException;

public class UI {
	public static void mainMenu(Bank bank, User user) {
		System.out.println("Bem vindo ao BACKYARD BANK!\n");
		System.out.println("1 - Acessar conta");
		System.out.println("2 - Criar conta");
		System.out.println("3 - Finalizar dia");
		System.out.println("4 - Sair");
		
		System.out.println("\nDia " + bank.getCurrentDay());
		System.out.println("\nCarteira: R$" + user.getWalletMoney());
		
		System.out.print("\nEscolha: ");
	}
	
	public static void accessAccountMenu(BankAccount acc) {
		System.out.println("Nome do dono: " + acc.getOwnerName());
		System.out.println("Balanço: R$" + acc.getBalance());
		System.out.println("\n1 - Depositar");
		System.out.println("2 - Sacar");
		System.out.println("3 - Sair");
		
		System.out.print("\nEscolha: ");
	}
	
	public static void clearScreen() throws InterruptedException, IOException{
	    //Clears Screen in java
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
	}
}
