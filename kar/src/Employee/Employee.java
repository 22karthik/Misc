package Employee;

public class Employee {
private String name;
private int salary;
public BankAccount a;
public Employee(String name,int salary,BankAccount a){
	this.name=name;
	this.salary=salary;
	this.a=a;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", salary=" + salary + ", a=" + a + "]";
}

}
