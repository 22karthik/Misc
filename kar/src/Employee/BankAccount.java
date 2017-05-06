package Employee;
public class BankAccount {

	private int balance;

	BankAccount(int balance){
		this.balance=balance;
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}




}
