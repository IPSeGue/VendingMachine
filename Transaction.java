import java.util.HashMap;

public class Transaction {
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;
    private HashMap<Item, Integer> quantitySold;
    private int totalAmountCollected;
    private HashMap<Integer, Integer> denominations;

    public Transaction(HashMap<Item, Integer> startingInventory) {
        this.startingInventory = startingInventory;
        this.endingInventory = new HashMap<>();
        this.quantitySold = new HashMap<>();
        this.totalAmountCollected = 0;
        this.denominations = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        int startingQuantity = startingInventory.getOrDefault(item, 0);
        startingInventory.put(item, startingQuantity + quantity);
    }

    public void removeItem(Item item, int quantity) {
        int startingQuantity = startingInventory.getOrDefault(item, 0);
        if (startingQuantity >= quantity) {
            startingInventory.put(item, startingQuantity - quantity);
        } else {
            System.out.println("Insufficient quantity to remove.");
        }
    }

    public void updateQuantitySold(Item item, int quantity) {
        int soldQuantity = quantitySold.getOrDefault(item, 0);
        quantitySold.put(item, soldQuantity + quantity);
    }

    public void updateTotalAmountCollected(int amount) {
        totalAmountCollected += amount;
    }

    public void addDenomination(int denomination, int quantity) {
        denominations.put(denomination, quantity);
    }

    public void removeDenomination(int denomination) {
        denominations.remove(denomination);
    }

    public void updateDenominationQuantity(int denomination, int quantity) {
        denominations.put(denomination, quantity);
    }

    public void printSummary() {
        System.out.println("Starting Inventory:");
        for (Item item : startingInventory.keySet()) {
            System.out.println(item.getName() + ": " + startingInventory.get(item));
        }

        System.out.println("\nEnding Inventory:");
        for (Item item : endingInventory.keySet()) {
            System.out.println(item.getName() + ": " + endingInventory.get(item));
        }

        System.out.println("\nQuantity Sold:");
        for (Item item : quantitySold.keySet()) {
            System.out.println(item.getName() + ": " + quantitySold.get(item));
        }

        System.out.println("\nTotal Amount Collected: " + totalAmountCollected);

        System.out.println("\nDenominations:");
        for (Integer denomination : denominations.keySet()) {
            System.out.println("Denomination: " + denomination +
                    ", Quantity: " + denominations.get(denomination));
        }
    }
}
