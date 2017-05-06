package Employee;

public class Mat {

	public static void main(String args[])
	{
       int[][] matarr=new int[3][3];
       //insert into the matrix
       int i;//iterate over matrix
       int j;//iterate over matrix
       int k=1;//enters the required value
       
       //enters the value
       for(i=0;i<=2;i++)
       {
    	   for(j=0;j<=2;j++)
    		 matarr[i][j]=k++;  
       }
	
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
