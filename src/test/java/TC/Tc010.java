package TC;

public class Tc010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1=new String("Pooja");
		String str2=str1;
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = "This is a beautiful day";
		
		System.out.println("core"+str3);
		System.out.println("Length of str3:"+str3.length());
		System.out.println("index of a:"+ str3.indexOf("A"));
		System.out.println("substring:"+str3.substring(10,20));
		System.out.println("value of"+str1.valueOf(30));
		System.out.println("Empty:"+str2.isEmpty());
		System.out.println(str1.concat(str3));
		System.out.println(str1.equals(str3));
		StringBuffer str4=new StringBuffer("apple");
		System.out.println("StringBuffer"+str4.append(str3));
		System.out.println("StringReverse"+str4.reverse());
		StringBuilder str5=new StringBuilder("Orange");
		System.out.println("StringBuilder"+str5.reverse());
				
		
		
		

	}

}
