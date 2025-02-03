import java.util.ArrayList;

public class Volunteer {
    ArrayList<Double> hours;
    String name;
    Organization organization;

    public Volunteer(String name) {
        this.name = name;
        hours = new ArrayList<>();
    }

    public void addHours(double hour) {
        hours.add(hour);
    }

    public double totalHours() {
        double sum = 0;
        for (int i = 0; i < hours.size(); i++) {
            sum += hours.get(i);
        }
        return sum;
    }

    public void donate(String item, String organization) {

    }


}


