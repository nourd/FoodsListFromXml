package au.example.foodslistfromxml;

public class Food {

    private final String name;
    private final String calories;

    public Food(String name, String calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String getCalories() {
        return calories;
    }
}
