import java.util.ArrayList;

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
                    hours += 3;
                    volunteer.addHours(3);
                } else if (organization.equals("Red Cross")) {
                    hours += 2;
                    volunteer.addHours(2);
                } else if (organization.equals("Food Bank for NYC")) {
                    hours += 1;
                    volunteer.addHours(1);
                }
            }
        }
    }

    public void printInfo() {
        System.out.println("Requirements to fulfilled: ");
        System.out.println("Items Required: ");
        printList();
        System.out.println("---------------------");
        System.out.println("Hours fulfilled for this organization: " + hours);
        System.out.println("Hours required: " + hoursRequired);
    }


    public void printList() {
        int counter = 1;
        for (int i = 0; i < itemsRequired.length; i++) {
            System.out.println(counter + "." + itemsRequired[i]);
        }
    }
}
