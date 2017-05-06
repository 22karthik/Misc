package Employee;

public class Main {
 public static void main(String args[])
 {
	 /*BankAccount a1=new BankAccount(2800);
	 BankAccount a2=new BankAccount(5800);
     Company c1=new Company("amazon",{new Employee("kar",6400,a1),new Employee("vinod",6400,a2)});
	
	 //Employee e1=new Employee("kar",6400,a1);
     //System.out.println(e1);*/

	 BankAccount a1=new BankAccount(2800);
	 BankAccount a2=new BankAccount(5800);
     Employee[] e={new Employee("kar",6400,a1),new Employee("vinod",6400,a2)};
     Company c1=new Company("amazon",e);
     System.out.println(c1);
 }
 
 
}
