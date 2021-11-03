import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        float difficulty = Float.parseFloat(in.readLine());
        float[] arr = new float[5];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        float max = max(arr);
        float min = min(arr);
        float[] filteredArr = fA(arr, max, min);
        float totalSum = 0;

        for (float value : filteredArr) {
            totalSum += value;
        }

        float average = totalSum / filteredArr.length;
        float result = rounder(average * difficulty);
        System.out.println(result);
    }
    public static float max(float[] arr) {
        float max = Float.MIN_VALUE;

        for (float v : arr) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static float min(float[] arr) {
        float min = Float.MAX_VALUE;

        for (float v : arr) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public static float[] fA(float[] arr, float max, float min) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] -= max;
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                arr[i] -= min;
                break;
            }
        }
        float[] filtered = new float[3];
        int k = 0;
        for (float v : arr) {
            if (v != 0) {
                filtered[k++] = v;
            }
        }
        return filtered;
    }

    public static float rounder(float num) {
        float pow = (float) Math.pow(10, 2);
        num *= pow;
        num = (int) num;
        num /= pow;
        return num;
    }
}