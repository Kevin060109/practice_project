import java.util.Scanner;

enum PizzaSelection {
    MARGHERITA(8.0),
    PEPPERONI(9.5),
    VEGGIE(9.0),
    BBQ_CHICKEN(10.0),
    HAWAIIAN(9.5);

    private final double price;

    PizzaSelection(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

enum PizzaToppings {
    CHEESE(1.0, "Cheese"),
    PEPPERONI(1.5, "Pepperoni"),
    MUSHROOMS(1.2, "Mushrooms"),
    ONIONS(0.8, "Onions"),
    OLIVES(1.0, "Olives"),
    BACON(1.7, "Bacon"),
    PINEAPPLE(1.3, "Pineapple"),
    SPINACH(1.1, "Spinach"),
    SAUSAGE(1.6, "Sausage"),
    PEPPERS(1.0, "Peppers");

    private final double toppingPrice;
    private final String topping;

    PizzaToppings(double toppingPrice, String topping) {
        this.toppingPrice = toppingPrice;
        this.topping = topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public String getTopping() {
        return topping;
    }
}

enum PizzaSize {
    SMALL(0.0, "Small"),
    MEDIUM(2.0, "Medium"),
    LARGE(4.0, "Large");

    private final double addToPizzaPrice;
    private final String pizzaSize;

    PizzaSize(double addToPizzaPrice, String pizzaSize) {
        this.addToPizzaPrice = addToPizzaPrice;
        this.pizzaSize = pizzaSize;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }
}

enum SideDish {
    GARLIC_BREAD(3.0, "Garlic Bread"),
    CHICKEN_WINGS(5.0, "Chicken Wings"),
    MOZZARELLA_STICKS(4.0, "Mozzarella Sticks"),
    SALAD(2.5, "Salad");

    private final double addToPizzaPrice;
    private final String sideDishName;

    SideDish(double addToPizzaPrice, String sideDishName) {
        this.addToPizzaPrice = addToPizzaPrice;
        this.sideDishName = sideDishName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    public String getSideDishName() {
        return sideDishName;
    }
}

enum Drinks {
    COLA(1.5, "Cola"),
    LEMONADE(1.5, "Lemonade"),
    WATER(1.0, "Water"),
    ORANGE_JUICE(2.0, "Orange Juice");

    private final double addToPizzaPrice;
    private final String drinkName;

    Drinks(double addToPizzaPrice, String drinkName) {
        this.addToPizzaPrice = addToPizzaPrice;
        this.drinkName = drinkName;
    }

    public double getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }
}

public class Slice_o_Heaven {
    private static final double PIZZA_BASE_PRICE = 10.0;
    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int orderCount = 0;
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve:");
            for (PizzaSelection pizza : PizzaSelection.values()) {
                System.out.println((pizza.ordinal() + 1) + ". " + pizza);
            }
            System.out.println("Please enter your choice (1 - 6):");
            int pizzaChoice = scanner.nextInt();

            if (pizzaChoice >= 1 && pizzaChoice <= 5) {
                PizzaSelection selectedPizza = PizzaSelection.values()[pizzaChoice - 1];
                pizzasOrdered[orderCount] = selectedPizza.toString();
                totalOrderPrice += selectedPizza.getPrice();
            } else if (pizzaChoice == 6) {
                System.out.println("Choose up to 10 toppings:");
                for (PizzaToppings topping : PizzaToppings.values()) {
                    System.out.println((topping.ordinal() + 1) + ". " + topping);
                }
                System.out.println("Enter your choices separated by spaces:");
                scanner.nextLine(); // Consume newline
                String[] toppingChoices = scanner.nextLine().split(" ");
                StringBuilder customPizzaDescription = new StringBuilder("Custom Pizza with ");
                double customPizzaPrice = PIZZA_BASE_PRICE;

                for (String choice : toppingChoices) {
                    int toppingIndex = Integer.parseInt(choice) - 1;
                    PizzaToppings selectedTopping = PizzaToppings.values()[toppingIndex];
                    customPizzaDescription.append(selectedTopping.getTopping()).append(", ");
                    customPizzaPrice += selectedTopping.getToppingPrice();
                }
                customPizzaDescription.append("for €").append(customPizzaPrice);
                pizzasOrdered[orderCount] = customPizzaDescription.toString();
                totalOrderPrice += customPizzaPrice;
            }

            System.out.println("Choose a pizza size:");
            for (PizzaSize size : PizzaSize.values()) {
                System.out.println((size.ordinal() + 1) + ". " + size);
            }
            int sizeChoice = scanner.nextInt();
            PizzaSize selectedSize = PizzaSize.values()[sizeChoice - 1];
            pizzaSizesOrdered[orderCount] = selectedSize.getPizzaSize();
            totalOrderPrice += selectedSize.getAddToPizzaPrice();

            System.out.println("Choose a side dish:");
            for (SideDish side : SideDish.values()) {
                System.out.println((side.ordinal() + 1) + ". " + side);
            }
            int sideChoice = scanner.nextInt();
            SideDish selectedSide = SideDish.values()[sideChoice - 1];
            sideDishesOrdered[orderCount] = selectedSide.getSideDishName();
            totalOrderPrice += selectedSide.getAddToPizzaPrice();

            System.out.println("Choose a drink:");
            for (Drinks drink : Drinks.values()) {
                System.out.println((drink.ordinal() + 1) + ". " + drink);
            }
            int drinkChoice = scanner.nextInt();
            Drinks selectedDrink = Drinks.values()[drinkChoice - 1];
            drinksOrdered[orderCount] = selectedDrink.getDrinkName();
            totalOrderPrice += selectedDrink.getAddToPizzaPrice();

            orderCount++;

            System.out.println("Would you like to order another pizza? (Y/N):");
            String continueChoice = scanner.next();
            continueOrdering = continueChoice.equalsIgnoreCase("Y");
        }
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder("----- Receipt -----\n");
        for (int i = 0; i < orderCount; i++) {
            receipt.append("Pizza: ").append(pizzasOrdered[i]).append("\n");
            receipt.append("Size: ").append(pizzaSizesOrdered[i]).append("\n");
            receipt.append("Side Dish: ").append(sideDishesOrdered[i]).append("\n");
            receipt.append("Drink: ").append(drinksOrdered[i]).append("\n");
            receipt.append("-------------------\n");
        }
        receipt.append("Total Order Price: €").append(totalOrderPrice).append("\n");
        return receipt.toString();
    }

    public static void main(String[] args) {
        Slice_o_Heaven soh = new Slice_o_Heaven();
        soh.takeOrder();
        System.out.println(soh);
    }
}