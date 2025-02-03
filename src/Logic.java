import java.util.Scanner;

public class Logic {
    Volunteer volunteer;
    Scanner scan;
    String choice;
    Organization current;
    boolean foundOrganization;
    //same thing as name variable


    public Logic() {
        scan = new Scanner(System.in);
        choice = "";
        current = null;
        foundOrganization = false;
    }

    public void run() {

    }

    public void welcome() {
        System.out.println("Welcome to ______!");
        System.out.println("Come volunteer, donate, and make a difference in the community you are in today!");
        System.out.println();
        System.out.println("Menu");
        System.out.println("---------------------------");
        System.out.println("(L)ook for a organization to volunteer in");
        System.out.println("(D)onate to an organization");
        System.out.println("(I)nfo of a organization");
        System.out.println("(Y)our points");
        System.out.print("Enter here: ");
        choice = scan.nextLine();
        choice.toLowerCase();
    }



    public void processChoice() {
        if (choice.equals("l")) {
            lookForVolunteer();
        }
    }

    public void lookForVolunteer() {
        double chance = Math.random();
        if (chance >= 0.4) {
            System.out.println("You found an opportunity for volunteering! ");
            double organizationChance = Math.random();
            foundOrganization = true;
            if (organizationChance >= 0.99) {
                current = new Organization("Prospect Park Cleanup");
                System.out.println("The Organization is Prospect Park Cleanup");
            }
            else if (organizationChance >= 0.66) {
                current = new Organization("Red Cross");
                System.out.println("The Organization is Red Cross");
            }
            else {
                current = new Organization("Food Bank for NYC");
                System.out.println("The Organization is Food Bank for NYC");
            }
        } else {
            System.out.println("The organization is currently not holding any events.");
            System.out.println("Try again or try looking for another organization!");
        }
    }

}

