package EngineeringSchool;

public class Teacher extends Person {

	private String speciality;
	public Teacher(String name, int age, String gender,String speciality) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	this.speciality=speciality;
	}
	@Override
	public String toString() {
		return "Teacher [speciality=" + speciality + "]"+super.toString();
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}





}