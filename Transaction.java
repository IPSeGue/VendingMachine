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
}