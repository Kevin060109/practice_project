import java.util.ArrayList;
import java.util.List;


class SliceOHeaven {

    String storeName;
    String storeAddress;
    String storeEmail;
    String storePhone;
    List<String> storeMenu;
    List<String> pizzaIngredients;
    double pizzaPrice;
    List<String> sides;
    List<String> drinks;
    private String orderID;
    private double orderTotal;

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;


    public SliceOHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = new ArrayList<>();
        this.pizzaIngredients.add(DEF_PIZZA_INGREDIENTS);
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public SliceOHeaven(String name, String address, String email, String phone, List<String> menu,
                        List<String> ingredients, double price, List<String> sideList, List<String> drinkList) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = price;
        this.sides = sideList;
        this.drinks = drinkList;
        this.orderID = DEF_ORDER_ID;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public SliceOHeaven(String orderID, List<String> pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder(int pizzaCount, List<String> selectedSides, List<String> selectedDrinks) {
        orderID = "Order-" + (int)(Math.random() * 1000);
        orderTotal = pizzaCount * pizzaPrice;
        for (String side : selectedSides) {
            if (sides.contains(side)) {
                orderTotal += 2; 
            }
        }
        for (String drink : selectedDrinks) {
            if (drinks.contains(drink)) {
                orderTotal += 1; 
            }
        }
        System.out.println("Order " + orderID + " taken successfully!");
        printReceipt();
    }

    public void makePizza() {
        System.out.println("Preparing a pizza with " + String.join(", ", pizzaIngredients));
        System.out.println("Pizza is ready!");
    }

    private void printReceipt() {
        System.out.println("---------------------");
        System.out.println("Store: " + storeName);
        System.out.println("Address: " + storeAddress);
        System.out.println("Email: " + storeEmail);
        System.out.println("Phone: " + storePhone);
        System.out.println("Order ID: " + orderID);
        System.out.println("Total: $" + orderTotal);
        System.out.println("---------------------");
    }
}