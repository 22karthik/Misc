package Session1;

public class Saleable implements Taxable{

	public String description;
	public int amount;
	
	public Saleable(String description, int amount) {
		super();
		this.description = description;
		this.amount = amount;
	}
	
	
	
	public String getDescription() {
		return description;
	}

@Override
	public int tax() {
		int tax=0;
		System.out.println("the tax that has to be paid for"+this.description+"is"+.20*this.amount);
		
		
		return tax;
	}



}
