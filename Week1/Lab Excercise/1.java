import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public boolean containsDuplicateAndPrintIndices(int[] nums) {
        ArrayList<Integer> indices = new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                indices.add(i);
                indices.add(i + 1);
                System.out.println("The element " + nums[i] + " occurs at the indices " + indices.get(0) + " and " + indices.get(1));
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        boolean hasDuplicate = solution.containsDuplicateAndPrintIndices(nums);

        if (!hasDuplicate) {
            System.out.println("All the values are Distinct");
        }
    }
}
