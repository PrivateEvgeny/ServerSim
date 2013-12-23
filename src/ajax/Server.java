package ajax;
/* 
* Converts a character to decimal and sends back the 
* value in the response. 
*/ 

import java.io.IOException; 

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 

import sim.main;
import sim.readLine;

@WebServlet({ "/server" })
public class Server extends HttpServlet { 
private static final long serialVersionUID = 1L;
 public String key;


public void doGet(HttpServletRequest req, HttpServletResponse 
res) 
throws ServletException, IOException { 
	
	System.out.println("CONST: "   + constant.SelectS);
if ( constant.SelectS != 0 ) {
	key = "Server # "+ (constant.SelectS-1);} 
else key = " Nothing select";

if (key != null) { 
	
	try {
		first f = new first();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//System.out.println(key);
	 
	//readLine.start("server "+ (constant.SelectS-1));


String decimalString = "Server :" + key;
// set up the response 
res.setContentType("text/xml"); 
res.setHeader("Cache-Control", "no-cache"); 
// write out the response string 
res.getWriter( ).write(decimalString); 


} 
else { 
// if key comes back as a null, return a question mark 
res.setContentType("text/xml"); 
res.setHeader("Cache-Control", "no-cache"); 
res.getWriter( ).write("?"); 
} 
} 
} 