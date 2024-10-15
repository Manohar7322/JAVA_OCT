package TC;
class box
{
	
	 static double dblwidth =10;
	 static double dblheight =30;
	 static double dbldepth =4;
	  int boxid;
	  public static double calvolume() 
	  {
		  double doutemp =0;
			doutemp = dblwidth * dblheight * dbldepth;
			System.out.println(doutemp);
			return doutemp;

	   }
	

   }
		
	

public class Tc01lasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		box box1 = new box();
		box1.calvolume();
		
		

	}

}
