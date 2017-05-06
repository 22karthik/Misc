package EngineeringSchool;

public class Person {

	//declare the variables
	private String name;
    private int age;
    private String gender;
    
   //constructor of person class
    public Person(String name,int age,String gender)
    {
    	this.name=setName(name);
    	this.age=setAge(age);
    	this.gender=setGender(gender);
    }

//getters and setters for all the fields
   
    public String setName(String name)
    {
    	//validate the string and then set to the varible
    	String regexp="[a-zA-Z]+";
    	if(name.matches(regexp))
    	{
    	    this.name=name;
    	     return name;
    	}
    
    	else
    	{
    		System.out.println("invalid name entered");
    	    return "0";
    	}
    
    
    }
    
    public int setAge(int age)
    {
    	String num="[0-9]+";
    String inputnum=age+"";
    
      if(inputnum.matches(num))
 {
	   this.age=age;
    	  return age;
 }
      else
      {
    	  System.out.println("invalid number");
          return 0;
      }
    
    }
    //validate the gender
   public String setGender(String gender)
   {
    String genderinp="[M]|[F]";
    if(gender.matches(genderinp))
    {
    	this.gender=gender;
       return gender;
    }
  
    else
    {
    	System.out.println("invalid gender entered");
        return null;
    }
   
   }    
   //implement the tostring
    public String toString(){
    	return "name:"+name+"age:"+age+"gender:"+gender;
    }
}
