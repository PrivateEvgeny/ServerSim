package sim;
import java.util.ArrayList;


public class VM {
	static public int src =0;
	public ArrayList<String> name= new ArrayList();
	public ArrayList<listP> param= new ArrayList();

	public static  int col =0;


	void add(String n, listP listP){
		param.add(listP);
		name.add(src+"");
		col++;
		src++;
		
	}
	
	void delNumber(int k){
		
		param.remove(k);
		name.remove(k);
		
		col--;
		
	}
	
	
	

	
}
