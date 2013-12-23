package sim;
import java.util.Scanner;


public class readLine implements Runnable{

	
	readLine(){
		
	}
	static public void start(String w) {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		command c=  new command();
	//	while (main.exit!=true){
			System.out.println("..");
			String s1 = "<time :" + main.time + ">";
			String s2 = "<S:" + main.s.param.size() +" VM:"+ main.vm.col+ ">";
			System.out.print(s1+s2+"Input:");
//		Scanner scanner=new Scanner(System.in); 
//		String word = scanner.nextLine();
		
		String word =w;
		String []ww = word.split(" ");
		
		if (word.equals("111")){System.out.println("11");}
		if (word.equals("exit")){main.exit=true;		}
		if (word.equals("info")){c.serverInfo();		}
		if (word.equals("addvm")){c.addvm();	}
		if (word.equals("start")){c.start();	}
		if (word.equals("pause")){c.pause();	}
		if (word.equals("user")){c.user();	}
		if (word.equals("restart")){c.restart();	}
		if (word.equals("free")){c.frees();	}
		if (word.equals("total")){c.totalServer();	}
		
		if (ww.length==2){
			if (ww[0].equals("server")) {c.sinfo(Integer.parseInt(ww[1]));}
			if (ww[0].equals("start")) {c.start(Integer.parseInt(ww[1]));}
			if (ww[0].equals("addvm")) {c.addvm(Integer.parseInt(ww[1]));}
			if (ww[0].equals("repack")) {c.setKoef(Integer.parseInt(ww[1]));}
			if (ww[0].equals("setrepack")) {c.setRepuck(Integer.parseInt(ww[1]));}
		}
		
		if (ww.length==3){
		
			if (ww[0].equals("changevm")) {c.changevm(Integer.parseInt(ww[1]),Integer.parseInt(ww[2]));}
		}
		
		
		}
//	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
