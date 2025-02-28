public class App {
    public static void main(String[] args) throws Exception {
        SliceOHeaven pizza1 = new SliceOHeaven();
        pizza1.storeName = "Slice-o-Heaven";
        pizza1.storeAddress = "123 Pizza Street";
        pizza1.storeEmail = "contact@sliceoheaven.com";
        pizza1.storePhone = 1234567890L;
        pizza1.storeMenu = "Pizza, Sides, Drinks";
        pizza1.pizzaIngredients = "Cheese, Tomato Sauce, Pepperoni";
        pizza1.pizzaPrice = 15.00;
        pizza1.sides = "Garlic Bread, Salad";
        pizza1.drinks = "Soda, Water";

        pizza1.takeOrder("1234", 15.00);
    }
}