import java.util.*;
import java.io.*;

public class SeniorEngineer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // O(N log N) LIS
            ArrayList<Integer> lis = new ArrayList<>();
            for (int val : arr) {
                int pos = Collections.binarySearch(lis, val);
                if (pos < 0)
                    pos = -(pos + 1); // insertion point
                if (pos == lis.size()) {
                    lis.add(val);
                } else {
                    lis.set(pos, val);
                }
            }
            sb.append(lis.size()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
