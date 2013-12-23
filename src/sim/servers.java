package sim;
import java.util.ArrayList;
import java.util.HashMap;


public class servers {
	ArrayList <String> name= new ArrayList();
	ArrayList <listP>param= new ArrayList();
	ArrayList <process>process= new ArrayList();
	
	public int col =0;
	public double effect = 0;
	

	void add(String n, listP listP){
		param.add(listP);

	//	param.put(x, listP);
		name.add(n);
		process.add(new process());
		col++;
		
		
	}
	
	
	

	
}
