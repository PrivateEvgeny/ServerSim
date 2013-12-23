package ajax;

public class first {
static int col;
static String key ;

	 first() throws InterruptedException{
		this.key=AjaxResponseServlet.key;
		if (col==0 ){
			col++;
			
			 new timer().time();;
		}
		
		
		
	}
	
}
