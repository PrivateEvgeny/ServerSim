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

@WebServlet({ "/info" })
public class info extends HttpServlet { 
private static final long serialVersionUID = 1L;
static public String key;

public static String  info;
public void doGet(HttpServletRequest req, HttpServletResponse 
res) 
throws ServletException, IOException { 
	
	info="";
key = req.getParameter("key"); 
if (key != null) { 
	
	try {
		first f = new first();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(key);
	 
	readLine.start("info");


String decimalString = "Server Anwer:" + info;
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