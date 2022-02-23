package mainPackage;

public class SavingAccount extends BankAccount {
	private int days;
	private double feeEarnings;
	private boolean onSaving;
	
	public SavingAccount(String name, int age) {
		super(name, age);
		feeEarnings = 0.0;
		days = 0;
		onSaving = false;
	}
	
	@Override
	public void deposit(double amount) {
		if (!onSaving) {
			money += amount;
			onSaving = true;
		}
	}
	
	@Override
	public double withdraw(double amount) {
		
	}
	
	@Override
	public void updateBalance() {
		
	}
	
}
