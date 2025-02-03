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
    }

    public void initializeItemsRequired(String[] list) {
        itemsRequired = list;
    }

    public void setHoursRequired(double hours) {
        this.hours = hours;
    }


}
