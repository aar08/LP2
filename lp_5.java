import java.util.*;

class Chatbot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Bot: Hello! How can I help you?");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! Welcome 😊");
            }
            else if (input.contains("price")) {
                System.out.println("Bot: Prices start from ₹500.");
            }
            else if (input.contains("order")) {
                System.out.println("Bot: Your order will be delivered in 3 days.");
            }
            else if (input.contains("bye")) {
                System.out.println("Bot: Thank you! Visit again.");
                break;
            }
            else {
                System.out.println("Bot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}