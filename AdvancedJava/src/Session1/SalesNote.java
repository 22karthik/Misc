package Session1;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesNote extends Saleable    {

	//intialize the vairables
	public String date;
	//public String description;
	//public int amount;
	
	//define constructor
	public SalesNote(String date,String description,int amount)
	{
		super(description,amount);
		this.date=date;
		
	}

	public SalesNote(SalesNote sn) {
		// TODO Auto-generated constructor stub
		super(sn.description,sn.amount);
		this.date=sn.date;
		
}

	@Override
	public String toString() {
		return ""+date+description+amount+"EUR";
	}

	/*@Override
	public int compareTo(Object s) {
   SalesNote s1=(SalesNote)s;
   SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
  
try {
	Date date1 = (Date) dateFormat.parse(this.date);
	 Date date2=(Date) dateFormat.parse(s1.date);
	 if(date1.before(date2))
	 {
	 	return -1;
	 }
	    
	 else if(date1.after(date2))
	 {
	 	return 1;
	 }
	 
	 else 
		 return 0;	
	 	
	 
		
	} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	 return 0;
	 	



	}*/

	public String getDate() {
		return date;
	}
}
		
	

