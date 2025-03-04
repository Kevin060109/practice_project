import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Slice_o_Heaven {
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
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        ing1 = scanner.next();
        ing2 = scanner.next();
        ing3 = scanner.next();
        System.out.println("Enter size of pizza (Small, Medium, Large):");
        pizzaSize = scanner.next();
        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();
        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sideDish = scanner.next();
        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        drinks = scanner.next();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount = scanner.next();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
    }

    @SuppressWarnings("resource")
    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday (dd/MM/yyyy):");
        String birthdateStr = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdate = null;
        try {
            birthdate = sdf.parse(birthdateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);

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
        System.out.println("Enter your card number:");
        cardNumber = scanner.nextLong();
        System.out.println("Enter the card's expiry date (MM/yyyy):");
        expiryDate = scanner.next();
        System.out.println("Enter the card's cvv number:");
        cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);
        if (cardNumberStr.length() == 14) {
            String firstCardDigit = cardNumberStr.substring(0, 1);
            long blacklistedNumber = 12345678901234L;
            if (cardNumber == blacklistedNumber) {
                System.out.println("Card is blacklisted. Please use another card");
                return;
            }
            String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
            String cardNumberToDisplay = firstCardDigit + cardNumberStr.substring(1, cardNumberStr.length() - 4).replaceAll(".", "*") + lastFourDigits;
            System.out.println("Card accepted. Card number to display: " + cardNumberToDisplay);
        } else {
            System.out.println("Invalid card");
        }
    }

    public void specialOfTheDay() {
        // This method remains unchanged
        System.out.println("Special of the day: Free garlic bread with a large pizza!");
    }

    public void printReceipt() {
        System.out.println("----- Receipt -----");
        System.out.println("Pizza Ingredients: " + ing1 + ", " + ing2 + ", " + ing3);
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Extra Cheese: " + extraCheese);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Drinks: " + drinks);
        if (wantDiscount.equalsIgnoreCase("Y")) {
            System.out.println("Discount Checked: Checked birthday for discount");
        } else {
            System.out.println("Discount Checked: Not requested");
            System.out.println("Card Number: " + Long.toString(cardNumber).substring(0, 1) + Long.toString(cardNumber).substring(1, Long.toString(cardNumber).length() - 4).replaceAll(".", "*") + Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4));
            System.out.println("Expiry Date: " + expiryDate);
            System.out.println("CVV: " + cvv);
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        Slice_o_Heaven soh = new Slice_o_Heaven();
        soh.takeOrder();
        soh.specialOfTheDay();
        soh.printReceipt();
    }
}