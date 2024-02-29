import java.util.Scanner;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using credit card number: " + creditCardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal account: " + email);
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Bitcoin address: " + bitcoinAddress);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select payment method: ");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bitcoin");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter credit card number: ");
                String creditCardNumber = scanner.next();
                cart.setPaymentStrategy(new CreditCardPayment(creditCardNumber));
                break;
            case 2:
                System.out.println("Enter PayPal email: ");
                String paypalEmail = scanner.next();
                cart.setPaymentStrategy(new PayPalPayment(paypalEmail));
                break;
            case 3:
                System.out.println("Enter Bitcoin address: ");
                String bitcoinAddress = scanner.next();
                cart.setPaymentStrategy(new BitcoinPayment(bitcoinAddress));
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Enter amount to pay: ");
        int amount = scanner.nextInt();
        cart.checkout(amount);


        scanner.close();
    }
}
