package sim;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class listP {
	public ArrayList<param>  a= new  ArrayList();
	public ArrayList<listP>  vm_listP= new  ArrayList();
	public ArrayList<param> work= new ArrayList();
	public listP  server;
	public String serverName;
	public Integer num;
	public ArrayList<String>  vm_name= new  ArrayList();
//	public ArrayList<VM>  vm_link= new  ArrayList();
	public boolean free = true;
	public int col =0, serv=-1;
	public double effect = 0;
	public int colV=0;
	
	
	void add(param p){
		a.add(p);
		col++;
		
	}
	
	void add2(param p){
		work.add(p);
			
	}
	
	void addWork(){
		Random random = new Random();
        int res = random.nextInt(50);
        
		add2(new param("RAM", 50+res));
		add2(new param("VCPU", 100));
		 res = random.nextInt(100);
		add2(new param("DISK", res));
	
	}
	
	void addTree1(){
		add(new param("RAM", 1200));
		add(new param("VCPU", 50));
		add(new param("DISK", 1200));
		
		
	}
	
	void addTree2(){
		add(new param("RAM", 1400));
		add(new param("VCPU", 150));
		add(new param("DISK", 2000));
		
		
	}
	
	void addTree3(){
		add(new param("RAM", 1200));
		add(new param("VCPU", 70));
		add(new param("DISK", 2000));
		
		
	}
	
	
	
	
	void addVM1(){
		add(new param("RAM", 10));
		add(new param("VCPU", 1));
		add(new param("DISK", 12));
		
		
	}
	
	void addVM2(){
		add(new param("RAM", 20));
		add(new param("VCPU", 2));
		add(new param("DISK", 10));
		
		
	}
	
	
	void addVM3(){
		add(new param("RAM", 30));
		add(new param("VCPU", 2));
		add(new param("DISK", 50));
		
		
	}
	
	
	
	
}
