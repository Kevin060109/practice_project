public class SliceOHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    private double orderTotal;

    public void takeOrder(String id, double total) {
        orderID = id;
        orderTotal = total;

        System.out.println("Order accepted!");

        makePizza();

        System.out.println("Your order is ready!");

        printReceipt();
    }

    private void makePizza() {
        System.out.println("Pizza is being prepared with the following ingredients: " + pizzaIngredients);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Pizza preparation interrupted!");
        }

        System.out.println("Pizza is ready!");
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Store Address: " + storeAddress);
        System.out.println("Store Email: " + storeEmail);
        System.out.println("Store Phone: " + storePhone);
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: " + orderTotal);
    }

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven();
        pizzeria.storeName = "Slice-o-Heaven";
        pizzeria.storeAddress = "123 Pizza Street";
        pizzeria.storeEmail = "contact@sliceoheaven.com";
        pizzeria.storePhone = 1234567890L;
        pizzeria.storeMenu = "Pizza, Sides, Drinks";
        pizzeria.pizzaIngredients = "Cheese, Tomato Sauce, Pepperoni";
        pizzeria.pizzaPrice = 12.99;
        pizzeria.sides = "Garlic Bread, Salad";
        pizzeria.drinks = "Soda, Water";

        pizzeria.takeOrder("001", 15.99);
    }
}