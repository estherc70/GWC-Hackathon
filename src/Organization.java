import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
    private ArrayList<String> pantry;
    private double hours;
    private double hoursRequired;
    private String[] itemsRequired;

    public Organization (String organization) {
        hours = 0;
        hoursRequired = 0;
        pantry = new ArrayList<>();
    }

    public void initializeItemsRequired(String[] list) {
        itemsRequired = list;
    }

    public void setHoursRequired(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public void addItem(String item) {
        boolean hasItem = false;
        for (int i = 0; i < pantry.size(); i++) {
            if (pantry.get(i).equals(item)) {
                hasItem = true;
                if (hasItem) {
                    System.out.println("You already donated this item to the organization before!");
                }
            }
            else {

            }
        }
    }

    public void printInfo() {
        System.out.println("Requirements to fulfilled: ");
        System.out.println("Items Required");
        System.out.println("---------------------");
        printList();
        System.out.println("Hours required: " + hoursRequired);
    }


    public void printList() {
        int counter = 1;
        for (int i = 0; i < itemsRequired.length; i++) {
            System.out.println(counter + "." + itemsRequired[i]);
        }
    }

    public double currentHour() {
        return hours;
    }




}
