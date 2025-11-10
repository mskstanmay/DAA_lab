import java.util.*;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
            freq[i] = sc.nextInt();

        }

        int m = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (keys[i] == m) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Key " + m + " found in the OBST.");
        } else {
            System.out.println("Key " + m + " not found in the OBST.");
        }
    }
}
