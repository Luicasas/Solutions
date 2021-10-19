import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class binarySearch{
    public static void main(String[] args) throws IOException {
        int[] arr = {24, 1263, 17, 30, 2, 12};
        Arrays.sort(arr);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(in.readLine());

        int result = search(arr, target);
        if (result != -1) {
            System.out.println(target + " was found at index " + (result + 1));
            System.out.println(Arrays.toString(arr));
        } else {
            System.out.println(target + " was not found");
        }
    }
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (target < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}