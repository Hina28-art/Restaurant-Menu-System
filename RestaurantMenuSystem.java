//Creating a Restaurant Menu with user input for adding menu items

import java.util.*;

public class RestaurantMenuSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        // Prompt user to add menu items
        System.out.println("Welcome to the Restaurant Menu System!");
        while (true) {
            System.out.println("\nEnter 1 to add a new menu item or 2 to display the menu or (0 to exit): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;
                case 1:
            
                    System.out.println("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    MenuItem newItem = new MenuItem(name, description, price);
                    menu.addItem(newItem);
                    break;
                case 2:
                    
                    menu.displayMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 0.");
            }
        }
    }
}

class MenuItem {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - Rs " + price;
    }
}

class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public void displayMenu() {
        if (items.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            System.out.println("Menu:");
            for (MenuItem item : items) {
                System.out.println(item);
            }
        }
    }
}
