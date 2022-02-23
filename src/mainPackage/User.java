package mainPackage;

public class User {
	private String name;
	private int age;
	private double walletMoney;
	
	public User() {
		this.name = "";
		this.age = 0;
		this.walletMoney = 0.0;
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
		this.walletMoney = 0.0;
	}
	
	public User(String name, int age, double money) {
		this.name = name;
		this.age = age;
		this.walletMoney = money;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWalletMoney() {
		return walletMoney;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWalletMoney(double walletMoney) {
		this.walletMoney = walletMoney;
	}
}
