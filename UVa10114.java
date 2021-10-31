import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVa10114 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int monthsLoan = Integer.parseInt(st.nextToken());
            if (monthsLoan < 0) break;
            double downPayment = Double.parseDouble(st.nextToken());
            double amountLoan = Double.parseDouble(st.nextToken());
            int depreciationRecords = Integer.parseInt(st.nextToken());
            TreeMap<Integer, Double> loans = new TreeMap<>();
            
            for (int i = 0; i < depreciationRecords; i++) {
                st = new StringTokenizer(in.readLine());
                int months = Integer.parseInt(st.nextToken());
                double percentage = Double.parseDouble(st.nextToken());
                loans.put(months, percentage);
            }

            double debt = amountLoan;
            double depreciation = (amountLoan + downPayment) - ((amountLoan + downPayment) * loans.get(0));
            double percentage = loans.get(0);
            int i = 1;
            for (; i <= monthsLoan; i++) {
                debt -= downPayment;
                System.out.println(debt + " " + depreciation + " " + percentage);
                if (debt < depreciation) break;
                if (loans.containsKey(i)) {
                    percentage = loans.get(i);
                }
                depreciation -= (depreciation*percentage);
            }
            System.out.println(i + (i > 1 ? " months" : " month"));
        }
    }
}
