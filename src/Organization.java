import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
    private boolean PlaytimeForCharity;
    private boolean ServiceSquad;
    private boolean MealsOnWhales;
    private ArrayList<String> pantry;
    private double hours;
    private double hoursRequired;
    private String[] itemsRequired;

    public Organization (String organization) {
        hours = 0;
        hoursRequired = 0;
        pantry = new ArrayList<>();
    }

    public void initializeItemsRequired(String[] list) {
        itemsRequired = list;
    }

    public void setHoursRequired(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public void addItem(String item) {
        boolean hasItem = false;
        for (int i = 0; i < pantry.size(); i++) {
            if (pantry.get(i).equals(item)) {
                hasItem = true;
                if (hasItem) {
                    System.out.println("You already donated this item to the organization before!");
                }
            }
        }


    }




}
