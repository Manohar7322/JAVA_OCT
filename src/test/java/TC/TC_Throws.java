package TC;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TC_Throws {
    static void fileopen1() throws FileNotFoundException {
        FileReader file = new FileReader("example.txt");  
        
    }

    public static void main(String[] args) {
        try {
            fileopen1();  
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); 
        }
    }
}
