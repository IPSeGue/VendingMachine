import java.util.HashMap;

public class Transaction{
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;
    private HashMap<Item, Integer> quantitySold;
    private int totalAmountCollected;
    private HashMap<Integer, Integer> denominations;
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};


    public Transaction() {
        startingInventory = new HashMap<>();
        endingInventory = new HashMap<>();
        quantitySold = new HashMap<>();
        totalAmountCollected = 0;
        denominations = new HashMap<>();
        initializeDenominations();
    }
    
    private void initializeDenominations() {
        for (int denomination : DENOMINATIONS) {
            denominations.put(denomination, 0);
        }
    }

    public void addItem(Item item, int quantity) {
        // Add item to startingInventory
    }

    public void removeItem(Item item, int quantity) {
        // Remove item from startingInventory
    }

    public void updateQuantitySold(Item item, int quantity) {
        // Update quantitySold for the item
    }

    public void updateTotalAmountCollected(int amount) {
        // Update totalAmountCollected
    }

    public void addDenomination(Integer denomination, Integer quantity) {
        denominations.put(denomination, quantity);
    }

    public void removeDenomination(Integer denomination) {
        denominations.remove(denomination);
    }

    public void updateDenominationQuantity(Integer denomination, Integer quantity) {
        denominations.put(denomination, quantity);
    }

    public void printSummary() {
        // Print the summary of transactions
    }
}