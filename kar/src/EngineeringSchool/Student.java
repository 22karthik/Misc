
package EngineeringSchool;

public class Student extends Person {

	private int idNumber;
	public Student(String name, int age, String gender,int idNumber) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	this.idNumber=idNumber;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public  String toString() {
		return "Student [idNumber=" + idNumber + "]"+super.toString();
	}



}
