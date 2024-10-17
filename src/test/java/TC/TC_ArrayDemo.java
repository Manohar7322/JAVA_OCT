package TC;

public class TC_ArrayDemo {
    int intnumbers[];

    TC_ArrayDemo(int i) {
        intnumbers = new int[i];
    }

    void populatearray() {
        for (int i = 0; i < intnumbers.length; i++) {
            intnumbers[i] = i + 100;
        }
    }

    void displaycontents() {
        for (int i = 0; i < intnumbers.length; i++) {
            System.out.println("Number " + i + ": " + intnumbers[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TC_ArrayDemo obj = new TC_ArrayDemo(5);
        obj.displaycontents();
        obj.populatearray();
        obj.displaycontents();
    }
}