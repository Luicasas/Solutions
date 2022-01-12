import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class GroceryList {
    private ArrayList<String> groceryList;

    public GroceryList() {
        this.groceryList = new ArrayList<String>();
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryItem(final String item) {
        this.groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + this.groceryList.size() + " items in your grocery list");
        for (int i = 0; i < this.groceryList.size(); ++i) {
            System.out.println(i + 1 + ". " + this.groceryList.get(i));
        }
    }

    public void modifyGroceryItem(final String currentItem, final String newItem) {
        final int position = this.findItem(currentItem);
        if (position >= 0) {
            this.modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(final int position, final String newItem) {
        this.groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.");
    }

    public void removeGroceryItem(final String item) {
        final int position = this.findItem(item);
        if (position >= 0) {
            this.removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(final int position) {
        this.groceryList.remove(position);
    }

    private int findItem(final String searchItem) {
        return this.groceryList.indexOf(searchItem);
    }

    public boolean onFile(final String searchItem) {
        final int position = this.findItem(searchItem);
        return position >= 0;
    }
}

public class Main {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final GroceryList groceryList = new GroceryList();

    public static void main(String[] args) throws IOException {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(in.readLine());
            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> groceryList.printGroceryList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> searchForItem();
                case 6 -> processArrayList();
                case 7 -> quit = true;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() throws IOException {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(in.readLine());
    }

    public static void modifyItem() throws IOException {
        System.out.println("Current item number: ");
        String itemNo = in.readLine();
        System.out.println("Enter new item: ");
        String newItem = in.readLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() throws IOException {
        System.out.println("Enter item name: ");
        String itemNo = in.readLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() throws IOException {
        System.out.println("Item to search for: ");
        String searchItem = in.readLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + ", not on file.");
        }
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<>(groceryList.getGroceryList());
    }
}
