import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVa10114 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int months = Integer.parseInt(st.nextToken());
            if (months < 0) break;
            double downPayment = Double.parseDouble(st.nextToken());
            double car = Double.parseDouble(st.nextToken());
            double carValue = car + downPayment;
            double payment = car / months;
            int depreciationRecords = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Double> loan = new TreeMap<>();

            for (int i = 0; i < depreciationRecords; i++) {
                st = new StringTokenizer(in.readLine());
                int month = Integer.parseInt(st.nextToken());
                double percentage = Double.parseDouble(st.nextToken());
                loan.put(month, percentage);
            }
            int month = 0;

            double depreciation, percentage = loan.get(0);
            depreciation = carValue - (carValue * loan.get(0));
            for (int i = 1; i <= months; i++) {
                if (car < depreciation) break;
                if (loan.containsKey(i)) {
                    percentage = loan.get(i);
                }
                car -= payment; depreciation -= (depreciation * percentage);
                month++;
            }
            System.out.println(month + (month == 1 ? " month" : " months"));
        }
    }
}
