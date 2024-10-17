package TC;

import java.io.FileNotFoundException;

public class TC_Throw {
		void proc() {
			try {
				int i=10/0;
				throw new FileNotFoundException("From Exception");
			}catch(FileNotFoundException e) {
				System.out.println("caught inside the demo");
				
			}
		}
public static void main(String[] args) throws FileNotFoundException{
	TC_Throw obj=new TC_Throw();
	obj.proc();
}
}


