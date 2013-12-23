package sim;
import java.util.Random;
import java.util.Scanner;

import ajax.constant;


public class command implements intUser {

	public void commandList() {
		
		
	}
public void setKoef(int k) {
		main.r.userset= k;
		
		ajax.AjaxResponseServlet.result += "<br>" +"Koef setted!";
	}

public void setRepuck(int k) {
	main.r.setCurrent();
	ajax.AjaxResponseServlet.result += "<br>" +"Koef changed! ";
	
}



	

	public void serverInfo() {
		int sCol= main.s.col;
		servers s= main.s;
		VM vm = main.vm;
		
		ajax.AjaxResponseServlet.result += "<br>" +"servers: "+ s.col+  " vm: " +vm.col  + " time: " + main.time;
		ajax.info.info = "<br>" +"servers: "+ s.col+  " vm: " +vm.col  + " time: " + main.time;
	}

	public void totalInfo() {
		// TODO Auto-generated method stub
		
	}

	public void addvm() {
		
		ajax.AjaxResponseServlet.result += "<br>" +"how many VM to add?:";
		Scanner scanner=new Scanner(System.in); 
		String word = scanner.nextLine();
		
		Random random = new Random();
        int res = random.nextInt(3);
        
		addvmStep2(res, main.vm.col, Integer.parseInt(word));
		start();
	//	serverInfo();
		
		ajax.AjaxResponseServlet.result += "<br>" +"Added!";
	}
	
public void addvm(int k) {
		
		
		
		Random random = new Random();
        int res = random.nextInt(3);
        
		addvmStep2(res, main.vm.col, k);
		start();
	//	serverInfo();
		
		ajax.AjaxResponseServlet.result += "<br>" +"VM added!";
	}
	
	public void addvmStep2(int r, int c, int i){
		
		for (int y=0; y<i; y++){
			Random random = new Random();
	         r = random.nextInt(3);
		listP vm5 = new listP();
		if (r>=2)vm5.addVM1();
		else vm5.addVM2();
		vm5.addWork();
		main.vm.add(c+"a", vm5);
		}
	}

	public void start() {
		main.pause=false;
		ajax.AjaxResponseServlet.result += "<br>" +"Time is started!";
		main.move=2;
	}
	
	
	public void start(int k) {
		main.pause=false;
		ajax.AjaxResponseServlet.result += "<br>" +"Time is started!";
		main.move=k;
	}
	

	public void pause() {
		main.pause = true;
		ajax.AjaxResponseServlet.result += "<br>" +"Time stopped!";
		
	}

	public void user() {
	if (main.user==true) {main.user =false;
	ajax.AjaxResponseServlet.result += "<br>" +"User adding stopped";
	} else {main.user=true;
	ajax.AjaxResponseServlet.result += "<br>" +"User adding started";
	}
			
		
	}

	public void frees() {
		int c = main.s.param.size();
		int s =0;
		listP server;
		
		
		
		for (int i=0; i<c; i++){
			server = main.s.param.get(i);
			if (server.free==true)s++;
			
		}
		
		ajax.AjaxResponseServlet.result += "<br>" +"There are free " + s + " from " + c + "servers";
	}

	public void restart() {
		
		main.pause =true;
		main.user =false;
		main.restartServers();
		//main.Exe(main.s, main.vm);
		
		main.pause = false;
		start();
		
		ajax.AjaxResponseServlet.result += "<br>" +"Restarted";
		
	}

	public void sinfo(int i) {
		pause();
		listP s = main.s.param.get(i);
		process p =  main.s.process.get(i);
		int c= s.vm_listP.size();
		double []ten = new double [main.colls];
		int callten =0;
		
		ajax.AjaxResponseServlet.result += "Server # " + i + " "+ main.s.name.get(i)+ "";
		ajax.AjaxResponseServlet.result += "<br>" + "VMs : "  + c;
		for (int t=0; t<main.colls; t++){
			ajax.AjaxResponseServlet.result += "<br>" +"Param: " + s.a.get(t).name + " all:" + s.a.get(t).size + " last: " + s.a.get(t).last;
			
		}
		for (int t=0; t<c; t++){
			ajax.AjaxResponseServlet.result += "<br>" +"VM: " + s.vm_name.get(t)+ " :  p:  ";
			ajax.AjaxResponseServlet.result +=  s.vm_listP.get(t).a.get(0).size+ " "
					+ s.vm_listP.get(t).a.get(1).size+ " "
					+ s.vm_listP.get(t).a.get(2).size+ " ";
		}
		//int g = p.allturn;
		int g = main.time;
		if ((g) <10) callten =main.time; else callten=10;
		for (int t=0; t<main.colls; t++){
			
			for (int l=0; l<callten; l++){
				ten[t] = p.graffic[t][g-l]+ten[t];
				
			}
			
			
			ten[t] = ten[t]/callten;
			//System.out.println("Effect in time: " + main.time+  " time; " +p.name.get(t) +" "+ p.effect[t]);
			ajax.AjaxResponseServlet.result += "<br>" +"Effect: total:          " + " " +p.name.get(t) +" "+ p.effectTotal[t]+ "     effect last 10: " + ten[t]+ "; " ;
		//	System.out.println("Effect: previuosa :          " + " " +p.name.get(t) +" "+ p.graffic[t][main.time-1]);
		
			for (int l=0; l<callten; l++){
				
				System.out.print(" " + p.graffic[t][g-l]);
			}
		
			System.out.println(" ");
		}
		
		constant.SelectS = i+1;
		//new graphics(p.graffic, 0);
		//for (int t=0; t< p.graffic[1].length; t++){
		//	System.out.print(" " +p.graffic[1][t] );
		//}
	}
	
	public void totalServer (){
		pause();
		int sc =main.s.col;
		double [][] effect = new double [main.colls][sc];
		double	[]	signed = new double[sc];
		double [] eff = new double [main.colls];

		for (int i=0; i<sc; i++){
			
			listP s = main.s.param.get(i);
			process p =  main.s.process.get(i);
			signed[i] = 1;
			
			for (int t= 0; t<main.colls; t++){
				
				effect[t][i] = p.effectTotal[t];
				
				System.out.println(main.s.name.get(i) + " " + main.s.param.get(i).a.get(t).name + " effect: " + effect[t][i]);
				
				signed[i] = signed[i]*  p.effectTotal[t]/100;
				eff[t]=eff[t]+effect[t][i];
				
			}// end t all colls
			
			ajax.AjaxResponseServlet.result += "<br>" + main.s.name.get(i)+ "total effect: " + (double)(signed[i]*100);
			
			for (int t= 0; t<main.colls; t++){
				eff[t]=eff[t]/sc;
				
			
						
			}
			
			
			
		}// all server i
		
		for (int t= 0; t<main.colls; t++){
			ajax.AjaxResponseServlet.result += "<br>" +main.s.param.get(0).a.get(t).name+ "total effect all servers: " + (double)(eff[t]);
		
		
		
		
		
		}
	}
	
	public void changevm(int e, int k){
		
	//	int z=e;
		int z = 0;
		for (int yy=0; yy<VM.col; yy++){//-1
			
			if (main.vm.name.get(yy).equals(e+"")) z=yy;	
		}
		
		main.blockUser = true;
		listP z2;
		
		
		z2=main.vm.param.get(z).server;
		int colVMs = z2.vm_listP.size();
		

		for (int y=0; y<colVMs; y++){//-1
		
			if (z2.vm_listP.get(y).equals(main.vm.param.get(z))){	
		
				z2.vm_listP.remove(y);
				z2.vm_name.remove(y);// 
				z2.colV--;
				colVMs--;
				
				
				for (int i=0; i<main.colls; i++){
					
					if (z2!=null)	z2.a.get(i).last = z2.a.get(i).last+ main.vm.param.get(z).a.get(i).size;

				}
				
			}
		
		}// end for y
		
		
		// put vm
		VM vm1= main.vm;
		servers s1 = main.s;
vm1.param.get(z).free = false;
		
		vm1.param.get(z).server = s1.param.get(k);
		vm1.param.get(z).serverName = s1.name.get(k);
		s1.param.get(k).colV++;
		s1.param.get(k).num = vm1.col;
		s1.param.get(k).vm_name.add(vm1.name.get(z));
		//System.out.print("put VM # " + vm1.name.get(z));
		//System.out.println(" to " + s1.name.get(z2));
	//!!	
		s1.param.get(k).vm_listP.add( vm1.param.get(z));
		for (int i=0; i<main.colls; i++){
		s1.param.get(k).a.get(i).last = s1.param.get(k).a.get(i).last- vm1.param.get(z).a.get(i).size;
		
		}
		main.Exe();
		
		System.out.println("Done, maybe..");
		
		
	}

}
