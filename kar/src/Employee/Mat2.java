package Employee;

public class Mat2 {
	public static void main(String args[])
	{
       int[][] matarr=new int[3][3];
       //insert into the matrix
       int i;//iterate over matrix
       int j;//iterate over matrix
       int k=1;//enters the required value
       
       //enters the first value
       matarr[1][1]=1;
       matarr[1][2]=2;
       matarr[0][2]=3;
       matarr[0][1]=4;
       matarr[0][0]=5;
       matarr[1][0]=6;
       matarr[2][0]=7;
       matarr[2][1]=8;
       matarr[2][2]=9;
   
       
        //prints the value
      for(i=0;i<=2;i++)
       {   
    	  for(j=0;j<=2;j++)
    	   {
    	     System.out.print(matarr[i][j]+" ");  
    	   }
    	   System.out.println();  
       }
	
	

}
}