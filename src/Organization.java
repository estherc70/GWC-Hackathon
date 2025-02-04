import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
    private ArrayList<String> pantry; //items the organization already has
    private String organization;
    private double hours;
    private double hoursRequired;
    private String[] itemsRequired;

    public Organization (String organization, String[] itemsRequired) {
        hours = 0;
        hoursRequired = 0;
        pantry = new ArrayList<>();
        this.itemsRequired = itemsRequired;
        this.organization = organization;

    }

    public void setHoursRequired(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public void addItem(String item) {
//        boolean hasItem = false; // if the pantry has the item
        for (int i = 0; i < pantry.size(); i++) {
            if (pantry.get(i).equals(item)) {
                System.out.println("You already donated this item to " + organization + " before!");
//                hasItem = true;
//                if (hasItem) {
//                    System.out.println("You already donated this item to the organization before!");
//                }
            } else {
                System.out.println("You donated " + item + " to " + organization + "!");
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
