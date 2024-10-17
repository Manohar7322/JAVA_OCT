package TC;

public class TC_Array1 {

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        int i = 10;
	        int a[] = new int[5];

	        String b[] = new String[2];
	        a[0] = 100;
	        a[1] = 200;
	        a[2] = 400;
	        a[4] = 77;
	        b[0] = "apple";
	        b[1] = "orange";

	        System.out.println("array values:" + (a[1] + a[2]));

	        int c[][] = new int[5][5];
	        c[0][0] = 1000;
	        c[0][1] = 2000;
	        c[0][4] = 3000;

	        System.out.println("array values:" + (c[0][0] + c[0][1]));
	    }
	}


