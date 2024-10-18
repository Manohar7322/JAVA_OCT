package TC;

import java.util.HashSet;

public class TC_Hashset {

    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>();

        s1.add(100);
        s1.add(1000);
        s1.add(10000);
        s1.add(100);
        s1.add(10000);

        System.out.println("size: " + s1.size());
        for (Integer index : s1) {
            System.out.println(index + " ");
        }
    }
}