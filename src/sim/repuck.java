package sim;
import java.util.ArrayList;
import java.util.Scanner;


public class repuck {
	static int count =2;
	par[] listPara  = new par [10];
	static public int userset = 0;
	public int []koef= new int [main.colls];
	public ArrayList<String>  name= new  ArrayList();
	
	repuck(){
		
		listPara[0] =  new par().addOdin();
		listPara[1] =  new par().addTwo();
		name.add("RAM");
		name.add("VCPU");
		name.add("DISK");
	}
	
	void setCurrent(){
		int k=1;
		
		for (int i=0; i<main.colls; i++){
			Scanner scanner=new Scanner(System.in);
			System.out.println("Input (100 as 100%) of " + name.get(i) + " :" );
			String word = scanner.nextLine();
			listPara[k].para[i] = Integer.parseInt(word);
			
		}
		
		
		
	}
	
	
	public class par {
		int[]  para= new  int[main.colls];
		public ArrayList<String>  name= new  ArrayList();
		
		par addOdin(){
			
			para[0]=100;
			para[1]=100;
			para[2]=100;
			name.add("Odin");
			
			return this;
		}
		
		par addTwo(){
			
			para[0]=100;
			para[1]=100;
			para[2]=130;
			name.add("Current");
			
			return this;
		}
		
		
		
		
	}
}
