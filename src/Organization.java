import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
    private ArrayList<String> pantry; //items the organization already has
    private String organization;
    private Volunteer volunteer;
    private int hours;
    private double hoursRequired;
    private String[] itemsRequired;

    public Organization (String organization, String[] itemsRequired, int hoursRequired, Volunteer volunteer) {
        hours = 0;
        this.volunteer = volunteer;
        this.hoursRequired = hoursRequired;
        pantry = new ArrayList<>();
        this.itemsRequired = itemsRequired;
        this.organization = organization;
    }


    public void addItem(String item) {
        for (int i = 0; i < pantry.size(); i++) {
            if (pantry.get(i).equals(item)) {
                System.out.println("You already donated this item to " + organization + " before!");
            } else {
                System.out.println("You donated " + item + " to " + organization + "!");
                if (organization.equals("Prospect Park Cleanup")) {
                    volunteer.addHours(3);
                } else if (organization.equals("Red Cross")) {
                    volunteer.addHours(2);
                } else if (organization.equals("Food Bank for NYC")) {
                    volunteer.addHours(1);
                }
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
