import java.util.ArrayList;

public class Organization {
    private ArrayList<String> pantry; //items the organization already has
    private String organization;
    private Volunteer volunteer;
    private double hours;
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
        String str = "";
        for (int i = 0; i < pantry.size(); i++) {
            if (pantry.get(i).equals(item)) {
                str = "You already donated this item to " + organization + " before or this item is not required!";
            } else {
                str = "You donated " + item + " to " + organization + "!";
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
        System.out.println(str);
    }

    public void printInfo() {
        System.out.println("Requirements to fulfilled: ");
        System.out.println("Items Required: ");
        printList();
        System.out.println("---------------------");
        System.out.println("Hours fulfilled for this organization: " + hours);
        System.out.println(Colors.RED + "Hours required: " + hoursRequired + Colors.RESET);
    }


    public void printList() {
        int counter = 1;
        for (int i = 0; i < itemsRequired.length; i++) {
            if (isInPantry(itemsRequired[i])) {
                System.out.println(counter + "." + Colors.CYAN + itemsRequired[i] + Colors.RESET);
                counter++;
            }
            else {
                System.out.println(counter + "." + Colors.RED + itemsRequired[i] + Colors.RESET);
                counter++;
            }

        }
    }

    public boolean isInPantry(String item) {
        for (String thing : pantry) {
            if (thing.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean allItems() {
        for (int i = 0; i < itemsRequired.length; i++) {
            if (!(isInPantry(itemsRequired[i]))) {
                return false;
            }
        }
        return true;
    }

    public boolean completedVolunteer() {
        return hours >= hoursRequired;
    }

    public void addHours(double hour) {
        hours += hour;
    }
}
