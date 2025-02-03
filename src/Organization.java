import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
    private boolean PlaytimeForCharity;
    private boolean ServiceSquad;
    private boolean MealsOnWhales;
    private String current; //same thing as name variable
    private int hours;
    private Scanner scanner;
    private ArrayList<String> pantry;

    public Organization (String organization) {
        current = organization;
        hours = 0;
        scanner = new Scanner(System.in);
    }

    public void lookForVolunteer() {
        double chance = Math.random();
        if (chance >= 0.4) {
            System.out.println("You found an opportunity for volunteering! ");
            if (current.equals("PTC")) {
                // different things to volunteer for this organization
            } else if (current.equals("SS")) {
                // different things to volunteer for this organization
            } else {
                // different things to volunteer for this organization
            }
        } else {
            System.out.println("The organization is currently not holding any events.");
            System.out.println("Try again or try looking for another organization!");
        }
    }
}
