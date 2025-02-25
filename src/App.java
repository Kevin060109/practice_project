import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("Margherita Pizza");
        menu.add("Pepperoni Pizza");

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Tomato Sauce");
        ingredients.add("Cheese");
        ingredients.add("Basil");

        List<String> sideList = new ArrayList<>();
        sideList.add("Garlic Bread");
        sideList.add("Fries");

        List<String> drinkList = new ArrayList<>();
        drinkList.add("Coke");
        drinkList.add("Sprite");

        SliceOHeaven pizzeria = new SliceOHeaven("Slice-o-Heaven", "123 Pizza St", "info@sliceoheaven.com",
                "555-1234", menu, ingredients, 10.0, sideList, drinkList);

        List<String> selectedSides = new ArrayList<>();
        selectedSides.add("Garlic Bread");
        List<String> selectedDrinks = new ArrayList<>();
        selectedDrinks.add("Coke");

        pizzeria.takeOrder(1, selectedSides, selectedDrinks);

        pizzeria.makePizza();
    }
}