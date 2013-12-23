package sim;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import ajax.AjaxResponseServlet;



public class main {
	static int c1 =0; // счетчик для вызова потоков оценки состояния 
	static int c2 =0; // счетчик для вывода количества всего на печать
	static int colls = 3;
	static int colV =0;
	static int colS =0;
	static int turn=0;
	static Integer time =0;
	static boolean newServer = false;
	static servers s;
	static VM vm;
	static boolean exit =false;
	static boolean pause = true;
	static boolean user = false;
	static boolean potok = true;
	static boolean blockUser = false;
	static repuck r;
	static int move = 0;
	static readLine d;
	
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main() throws InterruptedException {
		
		
		 s = new servers();
		 vm = new VM ();
		 r = new repuck();
	//new Thread(new readLine()).start();
		
		d = new readLine();
		 
		ThreadServer sa = new ThreadServer(s); 
		process p = new process();
	
	for (int i=0; i<3; i++){
		Random random = new Random();
        int res = random.nextInt(3);
        addVM(vm, colV++,res);
        
	}
	
		int C1 = 3000; // const for c1
		int C2= 100; // const for c2
	int i=0;
	int h=0;// chetchik hodov
	while(exit==false ) {
		
		if (pause == false & h < move){
			
			
		if(user ==true )		generateSing(vm, s, colV, colS);
		
	//	if(user ==true & blockUser == false)		generateSing(vm, s, colV, colS);
		

	
		if (c2==C2){ 
			c2=0;
		
		//	System.out.println("Turn: " + turn + ", Servers: " + s.col+ ", vm: "+ vm.col);
		}
		
		c1++;
		c2++;
	//	if (c1==C1){ 
		//	c1=0;
		if (potok ==true) sa.run();
	//	if (potok ==true)	new Thread(new ThreadServer(s)).start();
		Exe();
//		}
		
		
		move--;
		i++;
		}//pause
		
	}
	
	//restartServers();
	}
	
	
	
	public static void read(String s){
		
		main.d.start(ajax.AjaxResponseServlet.key);
		
	}
	
	public static Integer addtime() {
		return main.time++;
		
	}




	public static void restartServers() {
		int c = main.s.param.size();
		int v = main.vm.param.size();
		listP server;
		listP vm;
		
		
		for (int i=0; i<c; i++){
			server = main.s.param.get(i);
			server.vm_listP.clear();
			server.vm_name.clear();
			server.free =true;
			for (int t=0; t<main.colls; t++){
			server.a.get(t).last = 	server.a.get(t).size;
				
			}
		
			
		}
		
		for (int i=0; i<v; i++){
			vm = main.vm.param.get(i);
			vm.server =null;
			vm.serverName=null;
			vm.free =true;
		}
		
		
	}




	private static void generateSing(VM vm, servers s, int colV2, int colS2) {
		Random random = new Random();
        int res = random.nextInt(3);
      
        
        
      //  System.out.println("generate: +" +res);
        
        if (res==1){
        	addVM(vm, colV++, res);	
        	
        }
        
        if (res==0&& vm.col>100){
        	int num = random.nextInt(vm.col-2);
        	deleteVM(s, vm, num);
        }
		
	}
	
	
	private static void addRanServer(servers s, int c, int z) {
		
		Random random = new Random();
        int res = random.nextInt(3);
		listP p = new listP();
		
		if(res==1)p.addTree1();
		else if(res==2)p.addTree2();
		else p.addTree3();
		
		s.add("server " + c, p);
	}

	private static void addServer(servers s, int c, int z) {
		
		
		listP p = new listP();
		if(z==1)p.addTree1();
		if(z==2)p.addTree2();
		if(z==3)p.addTree3();
		s.add("server " + c, p);
	}

	private static void addVM(VM vm, int c, int r) {
		listP vm5 = new listP();
		if (r>=2)vm5.addVM1();
		else vm5.addVM2();
		vm5.addWork();
		vm.add(c+"a", vm5);	
		Exe();
	}

	static void Exe  (){
	
		servers s1 = main.s;
		VM vm1= main.vm;
		
		turn++;
				
		putOneSVM(s1, vm1, vm1.col);
		printServers(s1, s1.col);
		checkServers();
	
		
	}




	private static void checkServers() {
	int c = main.s.param.size();
		for(int i=0; i<c; i++)
		{
			if (main.s.param.get(i).vm_listP.size()>0){
				main.s.param.get(i).free= false;
				
			}else main.s.param.get(i).free= true;
			
		}
		
	}




	private static void printServers(servers s1, int colS) {
		int z2;
		z2=0;
		
		//printing effect and all serv
		while (colS>z2){
			double effect =1;
			
			
			//System.out.print("Server: " +s1.name.get(z2));
			//for (int i=0; i<colls; i++){
				
		//		System.out.print( s1.param.get(z2).a.get(i).name + " " + s1.param.get(z2).a.get(i).size + " " );
		//	}
			
		//	System.out.println (" ");
			
		for (int i=0; i<colls; i++){
		
			
		//printing params of server	
		//	System.out.print(s1.param.get(z2).a.get(i).name + " used: " +(double) (1-(double) s1.param.get(z2).a.get(i).last/
		//			s1.param.get(z2).a.get(i).size	)+ "    " );
			effect =effect* (double) (1-(double) s1.param.get(z2).a.get(i).last/
					s1.param.get(z2).a.get(i).size	);
			s1.param.get(z2).effect=effect;
					}
		//System.out.println("effect = " + effect);		
		
		z2++;
		}// end printing
	}

	private static void deleteServ(servers s1, VM vm1, int num ){
		listP z2;
		int col = s1.param.get(num).vm_listP.size();
		z2=s1.param.get(num);
		for (int i=0;i<col;i++){
			s1.param.get(num).vm_listP.get(i).free= true;
			s1.param.get(num).vm_listP.get(i).server=null;
			s1.param.get(num).vm_listP.get(i).serverName=null;
		}
		
		for (int l=0; l<colls; l++){
		
				z2.a.get(l).last = z2.a.get(l).size;
			
				}
		
		
		s1.param.remove(num);
		s1.col--;
		s1.name.remove(num);
		colS--;
		
		
	}
	
private static void returnServ(servers s1, VM vm1, int num ){
		
		listP oldParam = s1.param.get(num);
		
		deleteServ(s1, vm1, num);
			
		colS++;
		s1.add("server " + colS, oldParam);
		Exe();
		
	}
	
	
	
	
	private static void putOneSVM(servers s1, VM vm1, int colVM) {
	
		//z = number of VM
		//z2 number of server
		int z2=0;
		int []  para =  main.r.listPara[r.userset].para;
		
		int z; 
		// try all VM here 
		z=0;
		//System.out.println("ColVM= " + colVM);
		while (colVM>z){
			z2=0;
			
			newServer=true;
			
			//allserv
			while (colS>z2){
			
			if (vm1.param.get(z).free) {
				
				boolean virtual = true;
				for (int i=0; i<colls; i++){
			
					if (((s1.param.get(z2).a.get(i).last) + s1.param.get(z2).a.get(i).size/100*(para[i]-100) )
							<vm1.param.get(z).a.get(i).size ) virtual = false;
				//	System.out.print(" para+" + i + ":" + para[i]);
					
				}//end for 3
					
					
				if (virtual == true & vm1.param.get(z).free) {
						newServer=false;
						putVM(s1, vm1, z, z2);
				} 
				
			}//end if vm1 free
				
			z2++;
			}// end allserv
			
			
//		
		if (vm1.param.get(z).free){
			
			addRanServer(s1, colS++, 3);
		}
			
		z++;
		}// end all VM while
	
	}
	
	private static boolean checkVMtoServer(servers s1, VM vm1, int colVM, int[][] p,	int z2, int z) {
		
		//z = number of VM
		//z2 number of server
				
			boolean virtual = true;
			listP e = s1.param.get(z2);
			for (int i=0; i<colls; i++){
			if (s1.param.get(z2).a.get(i).last <p[i][z] ) virtual =false;
			}//end for 3
			
			if (virtual == true & vm1.param.get(z).free) {
				
				return true;
			} else return false;
			

	}
	
	
		
	private static void putVM(servers s1, VM vm1,  int z, int z2) {
		vm1.param.get(z).free = false;
		
		vm1.param.get(z).server = s1.param.get(z2);
		vm1.param.get(z).serverName = s1.name.get(z2);
		s1.param.get(z2).colV++;
		s1.param.get(z2).num = vm1.col;
		s1.param.get(z2).vm_name.add(vm1.name.get(z));
		//System.out.print("put VM # " + vm1.name.get(z));
		//System.out.println(" to " + s1.name.get(z2));
	//!!	
		s1.param.get(z2).vm_listP.add( vm1.param.get(z));
		for (int i=0; i<colls; i++){
		s1.param.get(z2).a.get(i).last = s1.param.get(z2).a.get(i).last- vm1.param.get(z).a.get(i).size;
		
		}
		Exe();
	}
	
	private static void deleteVM(servers s1, VM vm1,  int z ) {
		
		blockUser = true;
		listP z2;
		z2=vm1.param.get(z).server;
		if (z2==null ){ //&& z2.vm_listP.size()
			
			System.out.println("NET servera!!!");
		}else{
		int colVMs = z2.vm_listP.size();
//		System.out.println("## " + z +" colvms: "+ colVMs);
//		
//		
//		// start printing server
//		
//		
//		listP s = z2;
//		int c= colVMs;
//		
//		
//		System.out.println("VMs : "  + c);
//		for (int t=0; t<main.colls; t++){
//			System.out.println("Param: " + s.a.get(t).name + " all:" + s.a.get(t).size + " last: " + s.a.get(t).last);
//			
//		}
//		for (int t=0; t<c; t++){
//			System.out.println("VM: " + s.vm_name.get(t));
//			
//		}
//		
//		
//		
//		
//		// stop printing
		
		
		
		for (int y=0; y<colVMs; y++){//-1
		//	System.out.println(colVMs);
		//	if (z2.vm_listP.get(y-1)==null)	z2.vm_listP.remove(y-1);	
		//	System.out.println(z2.vm_listP.get(y));
		//	System.out.print(y+" ");
		if (z2.vm_listP.get(y).equals(vm1.param.get(z))){	
		//	System.out.println(z2.vm_listP.size());
			z2.vm_listP.remove(y);
			z2.vm_name.remove(y);// 
			colVMs--;
	z2.colV--;
		//System.out.println("deleted" + " " + z2.colV);
	//	System.out.println(z2.vm_listP.size());
		}
	//	if (z2.vm_listP.get(y)==null) z2.vm_listP.remove(y);
		}
	//	z2.vm_listP.remove(z);
	
	colV--;
		
		
	
		for (int i=0; i<colls; i++){
	
			if (z2!=null)	z2.a.get(i).last = z2.a.get(i).last+ vm1.param.get(z).a.get(i).size;

		}
		
		
		vm1.delNumber(z);
		
		
	}
		blockUser= false;
		Exe();
	}

}
