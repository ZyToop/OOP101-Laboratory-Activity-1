import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] food = {"Burger", "Fries", "Chicken", "Spaghetti", "Soft Drink"};
        double[] price = {100, 60, 120, 90, 40};

        int totalQuantity = 0;
        double totalAmount = 0;

        System.out.println("Canteen Menu");

        for (int i = 0; i < food.length; i++) {
            System.out.println((i + 1) + ". " + food[i] + " - $" + price[i]);
        }

        System.out.print("Are you a student? (Y/N): ");
        char student = input.next().charAt(0);

        char again = 'Y';

        while (again == 'Y' || again == 'y') {
            System.out.print("Enter item number: ");
            int item = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (item < 1 || item > 5) {
                System.out.println("Invalid item number.");
                continue;
            }

            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid quantity. Enter 1 to 10.");
                continue;
            }

            double orderAmount = price[item - 1] * quantity;

            totalQuantity += quantity;
            totalAmount += orderAmount;

            System.out.println("Order added.");
            System.out.println("Item: " + food[item - 1]);
            System.out.println("Quantity: " + quantity);
            System.out.println("Amount: $" + orderAmount);

            System.out.print("Do you want to order again? (Y/N): ");
            again = input.next().charAt(0);
        }

        double discount = 0;

        if ((student == 'Y' || student == 'y') && totalAmount >= 500) {
            discount = totalAmount * 0.15;
        } else if (student == 'Y' || student == 'y') {
            discount = totalAmount * 0.10;
        } else if (totalAmount >= 500) {
            discount = totalAmount * 0.05;
        }

        double finalAmount = totalAmount - discount;

        System.out.println();
        System.out.println("Total quantity: " + totalQuantity);
        System.out.println("Total amount: $" + totalAmount);
        System.out.println("Total deduction: $" + discount);
        System.out.println("Final amount to pay: $" + finalAmount);

        input.close();
    }
}
