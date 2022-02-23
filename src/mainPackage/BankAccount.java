package mainPackage;

public abstract class BankAccount {
	protected double money;
	private double tax;
	private String ownerName;
	private int ownerAge;
	
	public BankAccount(String name, int age) {
		ownerName = name;
		ownerAge = age;
		money = 0.0;
		tax = 0.005;
	}
	
	public void deposit(double amount) {
		if (amount > 0.0) {
			money += amount;
		}
	}
	
	public double withdraw(double amount) {
		if (amount > 0.0 && amount <= money) {
			money -= amount;
			return amount;
		}
		else {
			return 0.0;
		}
	}
	
	public void updateBalance() {
		deposit(money * tax);
	}
	
	public double getBalance() {
		return money;
	}
	
	public double getTax() {
		return tax;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public int getOwnerAge() {
		return ownerAge;
	}
	
	protected void setTax(double tax) {
		this.tax = tax;
	}
}
