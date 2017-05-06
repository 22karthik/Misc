package Graphic;

public class Building {
	public String location;
	public  int floor;
	public Building(String location,int floor)
	{
		this.location=location;
		this.floor=floor;
		
	}

public void print(){
	System.out.println("the building is"+location+"floor"+floor);
}

public static void main(String args[]){
Building b=new Building("france",10);
b.print();
}

}
