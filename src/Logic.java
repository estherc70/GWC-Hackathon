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
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        volunteer = new Volunteer(name);
        System.out.println("Menu");
        System.out.println("---------------------------");
        System.out.println("(L)ook for a organization to volunteer in");
        System.out.println("(G)et item");
        System.out.println("(D)onate to an organization");
        System.out.println("(I)nfo of a organization");
        System.out.println("(V)iew stats");
        System.out.println("(Y)our points");
        System.out.println("(S)ell item");
        System.out.print("Enter here: ");
        choice = scan.nextLine();
        choice.toLowerCase();
    }



    public void processChoice() {
        if (choice.equals("l")) {
            lookForVolunteer();
        }
        else if (choice.equals("g")) {
            String item = volunteer.itemGenerator();
            System.out.println("You obtained " + item + "!");
            volunteer.addItemToInventory(item);
        }
        else if (choice.equals("d")) {
            volunteer.printInventory();
            System.out.println("Which item would you like to donate!");
            System.out.println("Enter here: ");
            String item = scan.nextLine();
            current.addItem(item);
        }
        else if (choice.equals("i")) {
            current.printInfo();
        }
        else if (choice.equals("v")) {
            volunteer.printInventory();
            System.out.println("You volunteered for " + volunteer.getHours() + "!");
        }
    }

    public void lookForVolunteer() {
        double chance = Math.random();
        if (chance >= 0.4) {
            System.out.println("You found an opportunity for volunteering! ");
            double organizationChance = Math.random();
            foundOrganization = true;
            if (organizationChance >= 0.66) {
                String[] items = {"brooms", "water", "trash bags", "rakes"};
                current = new Organization("Prospect Park Cleanup", items, 40);
                System.out.println("The Organization is Prospect Park Cleanup");
            }
            else if (organizationChance >= 0.33) {
                String[] items = {"mask", "pipettes", "bandaid", "heartbeat monitor"};
                current = new Organization("Red Cross", items, 30);
                System.out.println("The Organization is Red Cross");
            }
            else {
                String[] items = {"canned tomatoes", "pasta", "sushi", "pizza"};
                current = new Organization("Food Bank for NYC", items, 20);
                System.out.println("The Organization is Food Bank for NYC");
            }
        } else {
            System.out.println("The organization is currently not holding any events.");
            System.out.println("Try again or try looking for another organization!");
        }
    }





}

