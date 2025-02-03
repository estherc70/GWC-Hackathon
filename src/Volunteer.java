import java.util.ArrayList;

public class Volunteer {
    double hours;
    String name;
    ArrayList<String> inventory;

    public Volunteer(String name) {
        this.name = name;
        hours = 0;
        inventory = new ArrayList<>();
    }

    public void addHours(int time) {
        hours += hours;
    }

    public double getHours() {
        return hours;
    }

    public void donate(String item, String organization) {

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
        if (inventory.size() == 0) {
            System.out.println("You have nothing in your inventory yet!");
        }
        else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(counter + "." + inventory.get(i));
            }
        }

    }

    public String getInventory(int index) {
        return inventory.get(index);
    }



}


