import java.util.*;

class NumberAnalyzer {
    private List<Integer> numbers;

    public NumberAnalyzer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int findNumberWithDigitSum(int targetSum) {
        // Sort list based on digit sum, and for ties by number value
        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int sumA = digitSum(a);
                int sumB = digitSum(b);
                if (sumA != sumB) return Integer.compare(sumA, sumB);
                else return Integer.compare(a, b);
            }
        });

        // Binary search for target digit sum
        int low = 0, high = numbers.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midDigitSum = digitSum(numbers.get(mid));

            if (midDigitSum == targetSum) {
                result = numbers.get(mid);
                // Continue searching left for smaller number with same digit sum
                high = mid - 1;
            } else if (midDigitSum < targetSum) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int d = sc.nextInt();

        NumberAnalyzer analyzer = new NumberAnalyzer(list);
        int result = analyzer.findNumberWithDigitSum(d);
        System.out.print(result);

        sc.close();
    }
}