package powerconsumption;

import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader reader = null; // data reader
    public static BufferedWriter bufferedWriter = null; // data writer
    public static String file = "src\\PowerConsumption\\data.csv"; // file to retrieve data from
    public static String line;
    public static double cost = 598.98; // price in COP
    public static double voltage = 120; // voltage line

    public static String word(String word) {
        word = word.substring(0, 1).toUpperCase(Locale.ROOT) + word.substring(1).toLowerCase(Locale.ROOT);
        return word;
    }

    public static void writeData(double cost, double voltage) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter("src\\PowerConsumption\\textData.txt"));
        reader = new BufferedReader(new FileReader(file));
        double totalSum = 0;
        boolean count = false;
        while ((line = reader.readLine()) != null) {
            if (count) bufferedWriter.newLine();
            String[] row = line.split(",");
            for (int i = 0; i < row.length; i++) {
                double amperes = Double.parseDouble(row[2]);
                double watts = voltage * amperes;
                double kilowatts = watts / 1000;
                double consumptionPerDay = (Double.parseDouble(row[3]) * kilowatts);
                double consumptionPerMonth = consumptionPerDay * 30;
                double priceDay = consumptionPerDay * cost;
                double priceMonth = consumptionPerMonth * cost;
                switch (i) {
                    case 0 -> {
                        bufferedWriter.write("[CONSUMIDOR: " + word(row[0]) + "]");
                        bufferedWriter.newLine();
                    }
                    case 1 -> {
                        bufferedWriter.write("APARATO: " + word(row[1]));
                        bufferedWriter.newLine();
                    }
                    case 2 -> {
                        bufferedWriter.write("AMPERIOS: " + word(row[2]));
                        bufferedWriter.newLine();
                    }
                    case 3 -> {
                        totalSum += priceMonth;
                        bufferedWriter.write("HORAS AL DÍA: " + row[3]);
                        bufferedWriter.newLine();
                        bufferedWriter.write("CONSUMO POR DÍA: " +
                                String.format("%,.2f", priceDay) + " COP");
                        bufferedWriter.newLine();
                        bufferedWriter.write("CONSUMO AL MES: " +
                                String.format("%,.2f", priceMonth) + " COP");
                    }
                }
            }
            count = true;
            bufferedWriter.newLine();
        }
        bufferedWriter.newLine();
        bufferedWriter.write("SUMA TOTAL : [" + String.format("%,.2f",totalSum) + "]");
    }

    public static void main(String[] args) throws IOException {

        try {
            writeData(cost, voltage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert reader != null;
                reader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
