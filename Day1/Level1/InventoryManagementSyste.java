package Day1.Level1;

class InventoryItem {
    int itemId;
    String itemName;
    int quantity;
    double price;
    InventoryItem next;

    public InventoryItem(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private InventoryItem head;

    // Add an item at the beginning
    public void addItemAtBeginning(int itemId, String itemName, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        InventoryItem newItem = new InventoryItem(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove an item by Item ID
    public void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(int itemId) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println(temp.itemId + " | " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryItem temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Display all inventory items
    public void displayInventory() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " | " + temp.itemName + " | Quantity: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSyste {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Adding sample items
        inventory.addItemAtEnd(101, "Laptop", 5, 60000.0);
        inventory.addItemAtBeginning(102, "Mouse", 10, 500.0);
        inventory.addItemAtEnd(103, "Keyboard", 8, 1500.0);
        inventory.addItemAtBeginning(104, "Monitor", 4, 12000.0);

        System.out.println("All Inventory Items:");
        inventory.displayInventory();

        System.out.println("\nUpdating Quantity of Item ID 101 to 7:");
        inventory.updateQuantity(101, 7);
        inventory.displayInventory();

        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nRemoving Item ID 102 and displaying inventory:");
        inventory.removeItem(102);
        inventory.displayInventory();
    }
}

