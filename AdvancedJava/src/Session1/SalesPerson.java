package Session1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SalesPerson extends SalesNote implements Comparator<SalesNote> {
	
	public String name;
	public int[] minamt=new int[100];
	public SalesPerson(SalesNote sn,String name) {
		super(sn);
		this.name=name;
	}

	ArrayList<SalesNote> l1=new ArrayList<SalesNote>();
	
	public void add(SalesNote sn)
	{
		l1.add(sn);
	}
	
	public void remove(SalesNote sn)
	{
		l1.remove(sn);
	}


	


	public SalesNote poorestSale() {
		
		SalesNote res=l1.get(0);
		for(SalesNote s:l1)
		{
			if(s.amount<res.amount)
				res=s;//we want only the smaller so intialize the variable which was pointing to first element of list to the obtained least value
		}
		
		
		
	return res;
		
		
}

public int totalSales()
{
	int total=0;
	for(SalesNote s:l1)
	{
		total=total+s.amount;
	}
		
	return total;
	
}
//print sales of person and print date in chronological order

	 


public SalesNote bestSale() {
	
	SalesNote res=l1.get(0);
	for(SalesNote s:l1)
	{
		if(s.amount>res.amount)
			res=s;//we want only the smaller so intialize the variable which was pointing to first element of list to the obtained least value
	}
	
	
return res;
	
}



public ArrayList<SalesNote> printSales(String name){
	
	ArrayList<SalesNote> res=new ArrayList<SalesNote>();
	/*for(SalesNote s:l1){
			//sort the arraylist
			Collections.sort(l1, new Comparator<SalesNote>(){
		           public int compare (SalesNote m1, SalesNote m2){
		               return m1.getDate().compareTo(m2.getDate());
		           }
		       });	
		
	
}*/
	
	//now add only the objects of our interest
	for(SalesNote s:l1){
		if(this.name.equals(name)){
			res.add(s);
		}
	}
	return l1;
	
}
@Override
public int compare(SalesNote arg0, SalesNote arg1) {
	// TODO Auto-generated method stub
	return 0;
}
}



