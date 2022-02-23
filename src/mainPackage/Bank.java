package mainPackage;

import java.util.ArrayList;

public class Bank {
	private int currentDay;
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public Bank() {
		currentDay = 1;
	}
	
	public void endDay() {
		for (BankAccount acc : accounts) {
			acc.updateBalance();
		}
		currentDay++;
	}
	
	public void createAccount(String name, int age) {
		accounts.add(new CheckingAccount(name, age));
	}
	
	public int getCurrentDay() {
		return currentDay;
	}
	
	public BankAccount getAccount(User user) {
		for (BankAccount acc : accounts) {
			if (acc.getOwnerName().equals(user.getName())) {
				return acc;
			}
		}
		return null;
	}
	
	public void makeDeposit(User user, double amount) {
		double userWalletMoney = user.getWalletMoney();
		if (amount <= userWalletMoney) {
			getAccount(user).deposit(amount);
			user.setWalletMoney(userWalletMoney - amount);
		}
		else {
			// NotEnoughMoneyExcepetion
		}
	}
	
	public void makeWithdraw(User user, double amount) {
		BankAccount acc = getAccount(user);
		if (amount <= acc.getBalance()) {
			double userWallet = user.getWalletMoney();
			user.setWalletMoney(userWallet + acc.withdraw(amount));
		}
		else {
			// NotEnoughBalanceException
		}
	}
}
