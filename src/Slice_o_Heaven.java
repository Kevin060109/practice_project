import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Slice_o_Heaven {
    String ingChoice1, ingChoice2, ingChoice3;
    String ing1, ing2, ing3;    
    String pizzaSize;
    String extraCheese;
    String sideDish;
    String drinks;
    String wantDiscount;
    long cardNumber;
    String expiryDate;
    int cvv;
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;

    @SuppressWarnings("resource")
    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        // Ingredient selection
        while (!validInput) {
            System.out.println("Please pick any three of the following ingredients:\r\n" + //
                    " 1. Mushroom\r\n" + //
                    " 2. Paprika\r\n" + //
                    " 3. Sun-dried tomatoes\r\n" + //
                    " 4. Chicken\r\n" + //
                    " 5. Pineapple\r\n" + //
                    " Enter any three choices (1, 2, 3,…) separated by spaces:");
            ingChoice1 = scanner.next();
            ingChoice2 = scanner.next();
            ingChoice3 = scanner.next();

            if (isValidIngredientChoice(ingChoice1) && isValidIngredientChoice(ingChoice2) && isValidIngredientChoice(ingChoice3)) {
                validInput = true;
                ing1 = convertIngredientChoice(ingChoice1);
                ing2 = convertIngredientChoice(ingChoice2);
                ing3 = convertIngredientChoice(ingChoice3);
            } else {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        }

        // Pizza size selection
        validInput = false;
        while (!validInput) {
            System.out.println("What size should your pizza be?\r\n" + //
                    " 1. Large\r\n" + //
                    " 2. Medium\r\n" + //
                    " 3. Small\r\n" + //
                    " Enter only one choice (1, 2, or 3):");
            String sizeChoice = scanner.next();

            if (isValidSizeChoice(sizeChoice)) {
                validInput = true;
                pizzaSize = convertSizeChoice(sizeChoice);
            } else {
                System.out.println("Invalid choice. Please enter a valid size:");
            }
        }

        // Extra cheese selection
        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();

        // Side dish selection
        validInput = false;
        while (!validInput) {
            System.out.println("Following are the side dish that go well with your pizza:\r\n" + //
                    " 1. Calzone\r\n" + //
                    " 2. Garlic bread\r\n" + //
                    " 3. Chicken puff\r\n" + //
                    " 4. Muffin\r\n" + //
                    " 5. Nothing for me\r\n" + //
                    " What would you like? Pick one (1, 2, 3,…):");
            String sideDishChoice = scanner.next();

            if (isValidSideDishChoice(sideDishChoice)) {
                validInput = true;
                sideDish = convertSideDishChoice(sideDishChoice);
            } else {
                System.out.println("Invalid choice. Please enter a valid side dish:");
            }
        }

        // Drink selection
        validInput = false;
        while (!validInput) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                    " 1. Coca Cola\r\n" + //
                    " 2. Cold coffee\r\n" + //
                    " 3. Cocoa Drink\r\n" + //
                    " 4. No drinks for me\r\n" + //
                    " Enter your choice:");
            String drinkChoice = scanner.next();

            if (isValidDrinkChoice(drinkChoice)) {
                validInput = true;
                drinks = convertDrinkChoice(drinkChoice);
            } else {
                System.out.println("Invalid choice. Please enter a valid drink:");
            }
        }

        // Discount selection
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount = scanner.next();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    private boolean isValidIngredientChoice(String choice) {
        return choice.matches("[1-5]");
    }

    private String convertIngredientChoice(String choice) {
        switch (choice) {
            case "1":
                return "Mushroom";
            case "2":
                return "Paprika";
            case "3":
                return "Sun-dried tomatoes";
            case "4":
                return "Chicken";
            case "5":
                return "Pineapple";
            default:
                return "";
        }
    }

    private boolean isValidSizeChoice(String choice) {
        return choice.matches("[1-3]");
    }

    private String convertSizeChoice(String choice) {
        switch (choice) {
            case "1":
                return "Large";
            case "2":
                return "Medium";
            case "3":
                return "Small";
            default:
                return "";
        }
    }

    private boolean isValidSideDishChoice(String choice) {
        return choice.matches("[1-5]");
    }

    private String convertSideDishChoice(String choice) {
        switch (choice) {
            case "1":
                return "Calzone";
            case "2":
                return "Garlic bread";
            case "3":
                return "Chicken puff";
            case "4":
                return "Muffin";
            case "5":
                return "Nothing for me";
            default:
                return "";
        }
    }

    private boolean isValidDrinkChoice(String choice) {
        return choice.matches("[1-4]");
    }

    private String convertDrinkChoice(String choice) {
        switch (choice) {
            case "1":
                return "Coca Cola";
            case "2":
                return "Cold coffee";
            case "3":
                return "Cocoa Drink";
            case "4":
                return "No drinks for me";
            default:
                return "";
        }
    }

    @SuppressWarnings("resource")
    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter your birthday (dd/MM/yyyy):");
            String birthdateStr = scanner.next();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date birthdate = null;
            try {
                birthdate = sdf.parse(birthdateStr);
                Calendar cal = Calendar.getInstance();
                cal.setTime(birthdate);
                int birthYear = cal.get(Calendar.YEAR);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                if (currentYear - birthYear < 5 || currentYear - birthYear > 120) {
                    System.out.println("Invalid date. You are either too young or too dead to order. Please enter a valid date:");
                } else {
                    validDate = true;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }
        }

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);

        Date birthdate = null;
        cal.setTime(birthdate);
        int birthYear = cal.get(Calendar.YEAR);
        int birthMonth = cal.get(Calendar.MONTH) + 1;
        int birthDay = cal.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        if (age < 18 && currentMonth == birthMonth && currentDay == birthDay) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter your card number:");
            cardNumber = scanner.nextLong();
            System.out.println("Enter the card's expiry date (MM/yyyy):");
            expiryDate = scanner.next();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
            try {
                Date expDate = sdf.parse(expiryDate);
                if (expDate.before(new Date())) {
                    System.out.println("Invalid date. Please enter a future date:");
                } else {
                    validDate = true;
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }
        }
        System.out.println("Enter the card's cvv number:");
        cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        final long BLACKLISTED_NUMBER = 12345678901234L;
        boolean validCard = false;
        while (!validCard) {
            String cardNumberStr = Long.toString(cardNumber);
            if (cardNumberStr.length() == 14 && cardNumber != BLACKLISTED_NUMBER) {
                validCard = true;
                String firstCardDigit = cardNumberStr.substring(0, 1);
                String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
                String cardNumberToDisplay = firstCardDigit + cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") + lastFourDigits;
                System.out.println("Card accepted. Card number to display: " + cardNumberToDisplay);
            } else {
                System.out.println("Invalid card. Please enter a valid card number:");
                Scanner scanner = new Scanner(System.in);
                cardNumber = scanner.nextLong();
            }
        }
    }

    public void specialOfTheDay() {
        // This method remains unchanged
        System.out.println("Special of the day: Free garlic bread with a large pizza!");
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("----- Receipt -----\n");
        receipt.append("Pizza Ingredients: ").append(ingChoice1).append(", ").append(ingChoice2).append(", ").append(ingChoice3).append("\n");
        receipt.append("Pizza Size: ").append(pizzaSize).append("\n");
        receipt.append("Extra Cheese: ").append(extraCheese).append("\n");
        receipt.append("Side Dish: ").append(sideDish).append("\n");
        receipt.append("Drinks: ").append(drinks).append("\n");
        if (wantDiscount.equalsIgnoreCase("Y")) {
            receipt.append("Discount Checked: Checked birthday for discount\n");
        } else {
            receipt.append("Discount Checked: Not requested\n");
            receipt.append("Card Number: ").append(Long.toString(cardNumber).substring(0, 1)).append(Long.toString(cardNumber).substring(1, Long.toString(cardNumber).length() - 4).replaceAll(".", "*")).append(Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4)).append("\n");
            receipt.append("Expiry Date: ").append(expiryDate).append("\n");
            receipt.append("CVV: ").append(cvv).append("\n");
        }
        receipt.append("-------------------");
        return receipt.toString();
    }

    public static void main(String[] args) {
        Slice_o_Heaven soh = new Slice_o_Heaven();
        soh.takeOrder();
        soh.specialOfTheDay();
        System.out.println(soh);
    }
}