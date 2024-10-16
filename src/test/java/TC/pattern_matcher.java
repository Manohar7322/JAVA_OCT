package TC;
import java.util.regex.*;

public class pattern_matcher {
	    public static void main(String[] args) {
	       String inputstr="Apple";
	       String pattern ="Apple";
	       boolean patternmatch=Pattern.matches(pattern, inputstr);
	       System.out.println("pattern match is :"+patternmatch);
	       
	       
	       String input1="shop,mop,hopping,chopping";
	       Pattern p1=Pattern.compile("hop");
	       Matcher m1=p1.matcher(input1);
	       
	       System.out.println(m1.matches());
	       while(m1.find()) {
	    	   System.out.println(m1.group()+":"+m1.start()+":"+m1.end());
	    	   
	       String input2="welcome santhosh";
		   Pattern p2=Pattern.compile("santhosh");
		   Matcher m2=p2.matcher(input2);
		       
		       System.out.println(m1.matches());
		       while(m2.find()) {
		    	   System.out.println(m2.group()+":"+m2.start()+":"+m2.end());
		//string pattern    	   
		    	   String input3="stygjgfhsg";
				   Pattern p3=Pattern.compile("^[A-Z].*[0-9]$");
				   Matcher m3=p3.matcher(input3);
				   if(m3.find()) {
					   System.out.println("found");
				   }
				   else {
					   System.out.println("not found");
				   }
		//digit pattern
				   String input4="7569217322";
				   Pattern p4=Pattern.compile("^\\D{10}$");
				   Matcher m4=p4.matcher(input4);
				   if(m4.find()) {
					   System.out.println("found");
				   }
				   else {
					   System.out.println("not found");
				   }
	       }
	    }
	    }
}



