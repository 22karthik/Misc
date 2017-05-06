package Employee;

import java.util.Arrays;

public class Company {

public Employee[] e;
public String name;

public Company(String name,Employee[] e){
	this.name=name;
	this.e=e;
}

@Override
public String toString() {
	return "Company [e=" + Arrays.toString(e) + ", name=" + name + "]";
}

}

