import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa10049 {
    public static void main(String[] args) throws Throwable{
        int arr[] = new int[700000];
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 5;

        for (int i = 4; i < arr.length; i++) {
            int r = Arrays.binarySearch(arr, 0, i-1, i);
            arr[i] = arr[i-1]+(r>0?r:Math.abs(r)-1);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(in.readLine());
            if(n == 0) break;
            int res = Arrays.binarySearch(arr, n);
            System.out.println(res>0?res:Math.abs(res)-1);
        }
    }
}
