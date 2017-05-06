package Session1;

import java.util.ArrayList;

public class Driver {
public static void main(String args[]){
	//define main class
		
	     SalesNote sn1=new SalesNote("2017-01-31","toilet paper",254);
	     SalesNote sn2=new SalesNote("2017-02-01","laptop",220);
	     SalesNote sn3=new SalesNote("2017-03-01","veggies",22); 
	     SalesNote sn4=new SalesNote("2017-05-02","mobile",1500);
	     SalesNote sn7=new SalesNote("2017-05-02","fruits",48);
	     SalesNote sn8=new SalesNote("2017-05-02","chickhen",150);
	     SalesNote sn9=new SalesNote("2017-05-02","prawn",17);
	     
	     
	     SalesPerson sp1=new SalesPerson(sn1,"CVK");
		 SalesPerson sp3=new SalesPerson(sn2,"CVK");
		 SalesPerson sp4=new SalesPerson(sn3,"sub");
		 SalesPerson sp5=new SalesPerson(sn4,"sub");
		 SalesPerson sp6=new SalesPerson(sn9,"sub");
		 SalesPerson sp7=new SalesPerson(sn8,"sub");
		 SalesPerson sp8=new SalesPerson(sn7,"sub");
		 
		 //add elments into arraylist
		 sp1.add(sn1);
		 sp1.add(sn2);
		 sp3.add(sn3);
		 sp3.add(sn4);
		 sp3.add(sn7);
		 sp3.add(sn8);
		 
		
		 //get poorest sales
		SalesNote sn5=sp1.poorestSale();
		System.out.println("the least sale is"+sn5.amount);
		System.out.println("state of the object"+sn5);
		
		//get total sales
		int amount=sp1.totalSales();
		System.out.println("total sales is:"+amount);
			
		//print all the sales
		ArrayList<SalesNote> l2=sp3.printSales("sub");
		for(SalesNote s:l2){
			System.out.println("sorted array"+s);
		}
		
		//print the best sale
		SalesNote sn6=sp1.bestSale();
		System.out.println("the best sale is"+sn6.amount);
		System.out.println("state of the object"+sn6);
		
		//sales tax
		sn1.tax();
		sn2.tax();
		sn3.tax();


	

}
}
