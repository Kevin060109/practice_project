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

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    public SliceOHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public SliceOHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
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

    public void takeOrder(String orderID, double orderTotal) {
        this.orderID = orderID;
        this.orderTotal = orderTotal;

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

    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }


        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }


        StringBuilder cardNumberToDisplay = new StringBuilder(cardNumber.substring(0, 1));
        for (int i = 1; i < cardLength - 4; i++) {
            cardNumberToDisplay.append('*');
        }
        cardNumberToDisplay.append(cardNumber.substring(cardLength - 4));

        System.out.println("Card Number: " + cardNumberToDisplay);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("CVV: " + cvv);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder special = new StringBuilder();
        special.append("Pizza of the Day: ").append(pizzaOfTheDay).append("\n");
        special.append("Side of the Day: ").append(sideOfTheDay).append("\n");
        special.append("Special Price: ").append(specialPrice).append("\n");

        System.out.println(special.toString());
    }

    public static void main(String[] args) {
        SliceOHeaven pizzeria = new SliceOHeaven();
        pizzeria.storeName = "Slice-o-Heaven";
        pizzeria.storeAddress = "123 Pizza Street";
        pizzeria.storeEmail = "contact@sliceoheaven.com";
        pizzeria.storePhone = 1234567890L;
        pizzeria.storeMenu = "Pizza, Sides, Drinks";
        pizzeria.pizzaIngredients = "Mozzarella Cheese";
        pizzeria.pizzaPrice = 12.99;
        pizzeria.sides = "Garlic Bread, Salad";
        pizzeria.drinks = "Soda, Water";

        pizzeria.takeOrder("DEF-SOH-099", 15.00);
        pizzeria.processCardPayment("12345678901234", "12/25", 123);
        pizzeria.specialOfTheDay("Pepperoni Pizza", "Garlic Bread", "$9.99");
    }
}