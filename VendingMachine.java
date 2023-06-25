import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private static final int ITEM_LIMIT = 10;
    private static final int SLOT_COUNT = 8;

    private Map<Integer, ItemSlot> itemSlots;
    private Map<Item, Integer> startingInventory;
    private Map<Item, Integer> endingInventory;
    private Map<Item, Integer> quantitySold;
    private int totalAmountCollected;
    private Map<Integer, Integer> denominations;

    public VendingMachine() {
        itemSlots = new HashMap<>();
        startingInventory = new HashMap<>();
        endingInventory = new HashMap<>();
        quantitySold = new HashMap<>();
        denominations = new HashMap<>();
        totalAmountCollected = 0;
    }

    public void addItemSlot(Integer slotNumber, ItemSlot itemSlot) {
        if (itemSlots.size() < SLOT_COUNT) {
            itemSlots.put(slotNumber, itemSlot);
        } else {
            System.out.println("Maximum slot limit reached!");
        }
    }

    public void removeItemSlot(Integer slotNumber) {
        itemSlots.remove(slotNumber);
    }

    public ItemSlot getItemSlot(Integer slotNumber) {
        return itemSlots.get(slotNumber);
    }

    public void displayItemSlots() {
        for (Integer slotNumber : itemSlots.keySet()) {
            ItemSlot itemSlot = itemSlots.get(slotNumber);
            Item item = itemSlot.getItem();
            if (item != null) {
                System.out.println("Slot: " + slotNumber +
                        ", Item: " + item.getName() +
                        ", Price: " + item.getPrice() +
                        ", Calories: " + item.getCalories());
            } else {
                System.out.println("Slot: " + slotNumber + ", Empty");
            }
        }
    }

    public boolean receivePayment(int amount) {
        // Logic to process the payment and return true if successful, false otherwise
        return false;
    }

    public void dispenseItem(Integer slotNumber) {
        ItemSlot itemSlot = itemSlots.get(slotNumber);
        if (itemSlot != null) {
            Item item = itemSlot.getItem();
            if (item != null) {
                // Logic to dispense the item
                System.out.println("Dispensing item: " + item.getName());
            } else {
                System.out.println("Slot is empty.");
            }
        } else {
            System.out.println("Invalid slot number.");
        }
    }

    public void produceChange(int amount) {
        // Logic to calculate and dispense the change
    }

    public void performMaintenance() {
        // Logic to perform maintenance tasks on the vending machine
    }

    public void printTransactionSummary() {
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
