import java.util.ArrayList;

public class Volunteer {
    private double hours;
    private String name;
    private ArrayList<String> inventory;
    private int points;
    private ArrayList<String> wants;

    public Volunteer(String name) {
        this.name = name;
        hours = 0;
        inventory = new ArrayList<>();
        wants = new ArrayList<>();
        points = 0;
    }

    public void addHours(double time) {
        hours += hours;
    }

    public double getHours() {
        return hours;
    }

    public String itemGenerator() {
        String[] items = {"brooms", "water", "trash bags", "rakes", "mask", "pipettes", "bandaid", "heartbeat monitor", "canned tomatoes", "pasta", "sushi", "pizza"};
        int random = (int) (Math.random() * 11);
        return items[random];
    }

    public void addItemToInventory(String item) {
        inventory.add(item);
    }

    public void printInventory() {
        int counter = 1;
        if (inventory.isEmpty()) {
            System.out.println("You have nothing in your inventory yet!");
        }
        else {
            for (String s : inventory) {
                System.out.println(counter + "." + s);
            }
        }

    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public String getInventory(int index) {
        return inventory.get(index);
    }

    public void removeItem(String remove) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equals(remove)) {
                inventory.remove(i);
            }
        }
    }

    public void addPoint(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void addWants(String item) {
        wants.add(item);
    }

    public void printWants() {
        int counter = 1;
        for(String items : wants) {
            System.out.println(Colors.PURPLE + counter + "." + items);
        }
    }
}


