package sim;
import java.util.ArrayList;


public class process {
	
	public int lastTurn;
	public int allturn;
	public int[]  total= new  int [main.colls];
	public int[]  last= new  int [main.colls];
	public int[]  effect= new  int [main.colls];
	public int[][]  graffic = new int[main.colls][100000];
	public int[]  effectTotal= new  int [main.colls];
	public ArrayList<String>  name= new  ArrayList();
	
	process(){
		
		name.add("RAM");
		name.add("VCPU");
		name.add("DISK");
		
		
	}
}
