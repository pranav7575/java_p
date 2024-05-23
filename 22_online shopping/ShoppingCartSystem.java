import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Purchasable {
    void addItem();
    void removeItem();
    double calculateTotalPrice();
}

class Electronics implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem() {
        quantity++;
    }

    @Override
    public void removeItem() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " (Electronics) - " + quantity + " pcs, Total: $" + calculateTotalPrice();
    }
}

class Clothing implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem() {
        quantity++;
    }

    @Override
    public void removeItem() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " (Clothing) - " + quantity + " pcs, Total: $" + calculateTotalPrice();
    }
}

class Books implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Books(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem() {
        quantity++;
    }

    @Override
    public void removeItem() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return name + " (Books) - " + quantity + " pcs, Total: $" + calculateTotalPrice();
    }
}

class ShoppingCart {
    private List<Purchasable> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Purchasable item) {
        item.addItem();
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(Purchasable item) {
        item.removeItem();
        if (item.calculateTotalPrice() == 0) {
            items.remove(item);
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Purchasable item : items) {
            total += item.calculateTotalPrice();
        }
        return total;
    }

    public void purchaseItems() {
        System.out.println("Purchased Items:");
        for (Purchasable item : items) {
            System.out.println(item);
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
        items.clear();
    }

    public void showCart() {
        System.out.println("Current Cart:");
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Purchasable item : items) {
                System.out.println(item);
            }
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        Electronics laptop = new Electronics("Laptop", 1000.00);
        Clothing tshirt = new Clothing("T-Shirt", 20.00);
        Books novel = new Books("Novel", 15.00);

        while (true) {
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Clothing");
            System.out.println("3. Add Books");
            System.out.println("4. Remove Electronics");
            System.out.println("5. Remove Clothing");
            System.out.println("6. Remove Books");
            System.out.println("7. Show Cart");
            System.out.println("8. Purchase Items");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cart.addItem(laptop);
                    System.out.println("Laptop added to the cart.");
                    break;
                case 2:
                    cart.addItem(tshirt);
                    System.out.println("T-Shirt added to the cart.");
                    break;
                case 3:
                    cart.addItem(novel);
                    System.out.println("Novel added to the cart.");
                    break;
                case 4:
                    cart.removeItem(laptop);
                    System.out.println("Laptop removed from the cart.");
                    break;
                case 5:
                    cart.removeItem(tshirt);
                    System.out.println("T-Shirt removed from the cart.");
                    break;
                case 6:
                    cart.removeItem(novel);
                    System.out.println("Novel removed from the cart.");
                    break;
                case 7:
                    cart.showCart();
                    break;
                case 8:
                    cart.purchaseItems();
                    break;
                case 9:
                    System.out.println("Thank you for shopping with us!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
