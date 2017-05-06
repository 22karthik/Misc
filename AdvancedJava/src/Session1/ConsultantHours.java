package Session1;

public class ConsultantHours extends Saleable {

	public ConsultantHours(String description, int amount) {
		super(description, amount);
		// TODO Auto-generated constructor stub
	}

	public int hourPrice;
	
	public int getAmount() {
		return amount*hourPrice;
	}
	
	
	
}
