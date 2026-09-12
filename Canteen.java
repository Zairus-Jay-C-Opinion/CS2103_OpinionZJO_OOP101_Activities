import java.util.Scanner;

class Canteen{

    static void orderMenu(){
        System.out.println("\n========================================");
        System.out.println("--- WELCOME TO BAI-SUAL CODE STUDIO! ---");
        System.out.println("================= MENU =================");
        System.out.println("----------------------------------------");
        System.out.println("|SNACKS                                |");
        System.out.println("----------------------------------------");
        System.out.printf("%-32s%s%.2f%n", "1. Buldak", "- $", 50.00);
        System.out.printf("%-32s%s%.2f%n", "2. Takoyaki", "- $", 20.00);
        System.out.printf("%-32s%s%.2f%n", "3. Chicken", "- $", 80.00);
        System.out.printf("%-32s%s%.2f%n", "4. Adobo", "- $", 50.00);
        System.out.printf("%-32s%s%.2f%n", "5. Cheezy", "- $", 85.00);
        System.out.println("----------------------------------------");
        System.out.println("|DRINKS                                |");
        System.out.println("----------------------------------------");
        System.out.printf("%-32s%s%.2f%n", "6. Coke", "- $", 10.00);
        System.out.printf("%-32s%s%.2f%n", "7. Sprite", "- $", 10.00);
        System.out.printf("%-32s%s%.2f%n", "8. Mountain Dew", "- $", 10.00);
        System.out.printf("%-32s%s%.2f%n", "9. Coffee", "- $", 15.00);
        System.out.printf("%-32s%s%.2f%n", "10. Water", "- $", 5.00);
        System.out.println("========================================");
    }

    static double subTotal(int itemNumber, int quantity){
        int n = (itemNumber == 4) ? 1 : (itemNumber == 7 || itemNumber == 8) ? 6 : itemNumber;
        double price = 0.00;

        switch(n){
            case 1: 
                price = 50.00;
                break;
            case 2:
                price = 20.00;
                break;
            case 3:
                price = 80.00;
                break;
            case 5:
                price = 85.00;
                break;
            case 6:
                price = 10.00;
                break;
            case 9:
                price = 15.00;
                break;
            case 10:
                price = 5.00;
                break;
            default:
                System.out.println("Invalid order Bai!");
        }

        double total = price * quantity;

        return total;
    }

    static double discount(String studentStatus, double subT){
        double discountTotal = (studentStatus.equals("Y")) 
            ? ((subT >= 500.00) ? subT * .15 : subT * .10)
            : ((subT >= 500.00) ? subT * .05 : 0);

        return discountTotal;
    }

    static void orderSummary(int totalItems, double subT, double discountTotal, double orderTotal){
        System.out.println("\n========================================");
        System.out.println("----------- ORDER BAI SUMMARY ----------");
        System.out.println("========================================");
        System.out.printf("%-32s%s%d%n", "Total Items", "-  ", totalItems);
        System.out.printf("%-32s%s%.2f%n", "Total Before Discount:", "- $", subT);
        System.out.printf("%-32s%s%.2f%n", "Total Discount:", "- $", discountTotal);
        System.out.printf("%-32s%s%.2f%n", "Final Amount", "- $", orderTotal);
        System.out.println("----------------------------------------");
        System.out.println("|THANK FOR DINING WITH US BAI!         |");
        System.out.println("----------------------------------------");
        System.out.println("|PLEASE COME BACK AGAIN TO BCS!  :)    |");
        System.out.println("========================================");
        System.out.println("");
    }

    public static void main(String[] args){
        String answer = "Y";
        int totalItems = 0;
        double subT = 0;
        double discountTotal = 0;
        double orderTotal = 0;
        Scanner input = new Scanner(System.in);
        
        while (answer.equals("Y")){
            orderMenu();

            System.out.print("\nEnter item number (1-10): ");
            int itemNumber = input.nextInt();       

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > 10 ||quantity < 1 || quantity > 10){
                System.out.println("\nInvalid order BAI! Please enter a valid item and quantity.");
            }
            else{
                totalItems += quantity;
            
            System.out.print("Are you a student? (Y/N): ");
            String studentStatus = input.next();

            while (!studentStatus.equals("Y") && !studentStatus.equals("N")){
                System.out.println("\nInvalid status Bai!");
                System.out.print("\nAre you a student? (Y/N): ");
                studentStatus = input.next();
            }

            double orderSubT = subTotal(itemNumber, quantity);
            double orderDiscountTotal = discount(studentStatus, orderSubT);
            double thisOrderTotal = orderSubT - orderDiscountTotal;

            subT += orderSubT;
            discountTotal += orderDiscountTotal;
            orderTotal += thisOrderTotal;

            System.out.printf("%s%.2f%n", "\nSubtotal: $", orderSubT);
            System.out.printf("%s%.2f%n", "Discount: $", orderDiscountTotal);
            System.out.printf("%s%.2f%n", "Order Total: $", thisOrderTotal);
            }

            System.out.print("\nDo you want to order again Bai? (Y/N): ");
            answer = input.next();

            while (!answer.equals("Y") && !answer.equals("N")){
                System.out.println("\nInvalid answer Bai!");
                System.out.print("\nDo you want to order again Bai? (Y/N): ");
                answer = input.next();
            }
        }
        orderSummary(totalItems, subT, discountTotal, orderTotal);
        input.close();
    }
}
