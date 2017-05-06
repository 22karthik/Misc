package EngineeringSchool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School extends ArrayList{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  String name;
private String address;

//school consist of list of teachers and students 

ArrayList<Student> listofstud=new ArrayList<Student>(); 
ArrayList<Teacher> listofteachers=new ArrayList<Teacher>(); 

//generate the constructors
public School(String name,String address,ArrayList<Student> s,ArrayList<Teacher> t)
{
	this.name=name;
	this.address=address;
	this.listofstud=s;
	this.listofteachers=t;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public ArrayList<Student> getListofstud() {
	return listofstud;
}

public void setListofstud(ArrayList<Student> listofstud) {
	this.listofstud = listofstud;
}

public ArrayList<Teacher> getListofteachers() {
	return listofteachers;
}

public void setListofteachers(ArrayList<Teacher> listofteachers) {
	this.listofteachers = listofteachers;
}

//implement tostring for school

public String toString()
{
	for(Student s22:listofstud)
    {
    	System.out.println("list of students"+s22);
    	
    }
	
	for(Teacher t22:listofteachers)
    {
    	System.out.println("list of teachers"+t22);
    	
    }
	
	
	return "school name:"+name+"address:"+address;
}


}
