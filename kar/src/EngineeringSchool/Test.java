package EngineeringSchool;

import java.util.ArrayList;

public class Test {

	public static void main(String args[])
	{
		ArrayList<Student> s1=new ArrayList<Student>();
		s1.add(new Student("kar",24,"M",5));
		s1.add(new Student("poo",23,"F",6));
		
		ArrayList<Teacher> t=new ArrayList<Teacher>();
		t.add(new Teacher("syl",42,"M","java"));
		t.add(new Teacher("rou",32,"F","dbms"));
		
		
		School s=new School("holy","jaya 7th",s1,t);
	
		 System.out.println(s);
	   
	
	
	
	}
}
