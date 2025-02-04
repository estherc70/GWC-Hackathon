import java.util.Scanner;

public class Logic {
    private Volunteer volunteer;
    private Scanner scan;
    private String choice;
    private Organization current;
    private boolean foundOrganization;
    private boolean run;
    private String[] wants;

    public Logic() {
        scan = new Scanner(System.in);
        choice = "";
        current = null;
        foundOrganization = false;
        run = true;
        wants = new String[] {"sprout", "boba tea", "$50", "tree", "food", "education"};
    }

    public void run() {
        welcome();
        System.out.println("------------------------");
        while (run) {
            mainMenu();
            System.out.println();
            processChoice();
            if (completedRequirements()) {
                System.out.println(Colors.YELLOW + "Congrats, you've completed the requirements!" + Colors.RESET);
                System.out.println("Look for a new organization to move on!");
                foundOrganization = false;
                current = null;
            }
        }

    }

    public void welcome() {
        System.out.println(Colors.GREEN + "Welcome to Service Quests for Communities!" + Colors.RESET);
        System.out.println();
        System.out.println(Colors.BLUE + "Come volunteer, donate, and make a difference in the community you are in today!" + Colors.RESET);
        System.out.println(Colors.BLUE +"Look for an organization to volunteer and commit to it!" + Colors.RESET);
        System.out.println(Colors.BLUE +"Fulfill the requirements before moving on!" + Colors.RESET);
        System.out.println(Colors.BLUE +"Be sure to type the item names with no errors!" + Colors.RESET);
        System.out.println(Colors.BLUE +"Make a difference in your community and help out!" + Colors.RESET);
        System.out.println();
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        volunteer = new Volunteer(name);
        System.out.println("--------------------------------");
        System.out.println("Welcome " + name + "!");
    }

    public void mainMenu() {
        System.out.println(Colors.PURPLE + "Menu" + Colors.RESET);
        System.out.println(Colors.PURPLE + "---------------------------" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(L)ook for a organization to volunteer in" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(G)et item" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(D)onate to an organization" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(I)nfo of a organization" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(V)iew stats" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(Y)our points" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(S)ell item" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(W)ork" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(P)oint shop" + Colors.RESET);
        System.out.println(Colors.PURPLE + "(E)xit" + Colors.RESET);
        System.out.print(Colors.YELLOW + "Enter here: " + Colors.RESET);
        choice = scan.nextLine();
        choice.toLowerCase();
    }

    public void processChoice() {
        if (choice.equals("l") ) {
            if (foundOrganization) {
                System.out.println(Colors.RED + "You need to complete your task before moving on!" + Colors.RESET);
            }
            else {
                lookForVolunteer();
            }
        }
        else if (choice.equals("g")) {
            String item = volunteer.itemGenerator();
            System.out.println(Colors.CYAN + "You obtained " + item + "!" + Colors.RESET);
            volunteer.addItemToInventory(item);
        }
        else if (choice.equals("d") && foundOrganization) {
            volunteer.printInventory();
            System.out.println("Which item would you like to donate!");
            System.out.print("Enter here: ");
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
        else if (choice.equals("y")) {
            System.out.println("Points: " + volunteer.getPoints());
            System.out.println("You've volunteered for a total of  " + volunteer.getHours() + "!");
            System.out.println("Inventory");
            System.out.println("-------------");
            volunteer.printInventory();
            System.out.println("Wants");
            System.out.println("-------------");
            volunteer.printWants();
        }
        else if (choice.equals("s")) {
            volunteer.printInventory();
            System.out.println("Which item would you like to sell!");
            System.out.print("Enter here: ");
            String item = scan.nextLine();
            volunteer.removeItem(item);
            volunteer.addPoint(30);
            System.out.println(Colors.YELLOW + "You just got 30 points from selling " + item + "!" + Colors.RESET);
        }
        else if (choice.equals("w") && foundOrganization) {
            double time = volunteer();
            current.addHours(time);
            volunteer.addHours(time);
            System.out.println("You volunteered for " + Colors.BLUE + time + Colors.RESET + " hours!");
        }
        else if (choice.equals("p")) {
            printPointShop();
            System.out.print("Enter the item number: ");
            int num = scan.nextInt();
            scan.nextLine();
            volunteer.addWants(wants[num - 1]);
            System.out.println(Colors.CYAN + "Congrats! You just obtained " + wants[num - 1] + " !" + Colors.RESET);

        }
        else {
            run = false;
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
                current = new Organization("Prospect Park Cleanup", items, 40, volunteer);
                System.out.println("The Organization is Prospect Park Cleanup");
            }
            else if (organizationChance >= 0.33) {
                String[] items = {"mask", "pipettes", "bandaid", "heartbeat monitor"};
                current = new Organization("Red Cross", items, 30, volunteer);
                System.out.println("The Organization is Red Cross");
            }
            else {
                String[] items = {"canned tomatoes", "pasta", "sushi", "pizza"};
                current = new Organization("Food Bank for NYC", items, 20, volunteer);
                System.out.println("The Organization is Food Bank for NYC");
            }
        } else {
            System.out.println("The organization is currently not holding any events.");
            System.out.println("Try again or try looking for another organization!");
        }
    }

    public double volunteer() {
        return Math.random() * 30;
    }

    public boolean completedRequirements() {
        if (current != null) {
            return current.allItems() && current.completedVolunteer();
        } else {
            return false;
        }
    }

    public void printPointShop() {
        System.out.println(Colors.PURPLE + volunteer.getName() + " welcome to the point shop!");
        System.out.println("Enter the number to obtain the special item!" + Colors.RESET);
        System.out.println("------------------------------------------------");
        System.out.println(Colors.BLUE + "1.sprout" + Colors.RESET + Colors.YELLOW + " 40 points" + Colors.RESET);
        System.out.println(Colors.BLUE + "2.boba tea" + Colors.RESET + Colors.YELLOW + " 30 points" + Colors.RESET);
        System.out.println(Colors.BLUE + "3.$50" + Colors.RESET + Colors.YELLOW + " 50 points" + Colors.RESET);
        System.out.println(Colors.BLUE + "4.tree" + Colors.RESET + Colors.YELLOW + " 100 points" + Colors.RESET);
        System.out.println(Colors.BLUE + "5.food" + Colors.RESET + Colors.YELLOW + " 250 points" + Colors.RESET);
        System.out.println(Colors.BLUE + "6.education" + Colors.RESET + Colors.YELLOW + "300 points" + Colors.RESET);


    }
}

