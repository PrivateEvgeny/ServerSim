package sim;
import java.util.Random;


public class ThreadServer implements Runnable  {
	static servers s ;

static int turn; // с каким шагом надо печатать
	
//ThreadServer (int z){
//	turn = z;
//}
	
 
public ThreadServer(servers se)  {
	// TODO Auto-generated constructor stub
	 	s= se;
}

public   void run() {
	
		main.time++;
	
	//System.out.println("Strated " + main.time );
	
	
	boolean potok = false;
	
	boolean sw =false;
	if (main.user==true){
	main.user =false;
	sw = true;
	}
	int[]  effect= new  int [main.colls];
	int[]  work= new  int [main.colls];// col vm has done this turn
	int[]  workTotal= new  int [main.colls];// col vm has done this turn

	int col = s.col;// col serverov
	int colls = main.colls; // col parameters
	int vm; // col vm
	
	listP serv ;
	listP vm1;
	int rnd;
	 
	for (int i=0; i<col; i++){
		
		process pr = s.process.get(i);
		serv = s.param.get(i);
		
		
		
		for (int k=0; k<colls; k++) work[k]=0; // null work
		
		vm=serv.vm_listP.size();
		
		
		if (vm>1){ // all vm of this s
		for (int t=0; t<vm-1; t++){ //vm-1
			
			
			Random random = new Random();
	        rnd = random.nextInt(50);
	    if (serv.vm_listP.size()>0)  {  vm1 = serv.vm_listP.get(t);
	 
	        
			for (int k=0; k<colls; k++){
			
				
				
			//	System.out.println("Serrv# " + i + " vm# "+ t+" rand param= " + vm1.work.get(k).size );
			if (k==1) rnd=50;
			
			 work[k]=work[k]+(int)vm1.a.get(k).size * vm1.work.get(k).size*(50+rnd)/10000;// current vm
			
			}//end k - all params of vm
			
	    }
		}// end t - coll vm
		}// end if vm
		
		
		
			for (int t=0; t<colls; t++){
				
				pr.total[t]=serv.a.get(t).size;
				pr.last[t]=work[t];
				workTotal[t]+=work[t];
				pr.graffic[t][main.time]=work[t]*100/pr.total[t];
				pr.effect[t]=(int)pr.last[t]*100/pr.total[t];
				pr.lastTurn=main.turn;
				pr.effectTotal[t]=(pr.effectTotal[t]*(main.time-1)+work[t]*100/pr.total[t])/(main.time);
				
//				System.out.println("Srever process total " + i + " of par# " + t + " is= "+ serv.a.get(t).size);
//				System.out.println("              Noise is: " + i + " of par# " + t + " is= "+ work[t]);
//				System.out.println("              Zynato is: " + i + " of par# " + t + " is= "+ (serv.a.get(t).size - serv.a.get(t).last));
//				System.out.println("              Last is: " + i + " of par# " + t + " is= "+ (serv.a.get(t).last));
//				System.out.println("              Total is: " + i + " of par# " + t + " is= "+ (serv.a.get(t).size));
			}
		
		
		pr.allturn++;
	}// end i - all servers
	for (int k=0; k<colls; k++) workTotal[k] = workTotal[k]/col;
	
	//System.out.println("End asking, effect is: 1, 2, 3 = " + workTotal[0] + ", "+ workTotal[1]+ ", "+ workTotal[2]);
	if (sw==true) {main.user=true;}
	potok = true;
	
	//System.out.println("Stopped");
}

}
