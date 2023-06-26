import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class RegularVendingMachine{
    private HashMap<Item, Integer> itemSlots;
    private ArrayList<Transaction> transactions;

    public RegularVendingMachine(HashMap<Item, Integer> slot){
        this.itemSlots = slot;
        transactions = new ArrayList<>();
    }

    public void selectingItems(){
        
    }
    
    
    

    public void restockItemSlot(int slotNumber, int quantity) {
        ItemSlot itemSlot = itemSlots.get(slotNumber);
        if (itemSlot != null) {
            itemSlot.setQuantity(quantity);
            System.out.println("Slot " + slotNumber + " has been restocked with " + quantity + " items.");
        } else {
            System.out.println("Invalid slot number.");
        }
    }

    public void displayItemSlots() {
        for (Map.Entry<Integer, ItemSlot> entry : itemSlots.entrySet()) {
            int slotNumber = entry.getKey();
            ItemSlot itemSlot = entry.getValue();
            Item item = itemSlot.getItem();
            System.out.println("Slot " + slotNumber + ": " + item.getName() + " - Price: " + item.getPrice() + " - Calories: " + item.getCalories());
        }
    }


    public boolean receivePayment(int amount) { 
        // Process the payment from the user
        return true; // Placeholder return value
    }

    public void dispenseItem(Integer slotNumber) {
        // Dispense the item from the specified slot
    }

    public void produceChange(int amount) {
        // Calculate and provide change to the user
    }

    public void performMaintenance() {
        // Perform maintenance tasks on the vending machine
    }

    public void printTransactionSummary() {
    // Print the starting inventory
    System.out.println("Starting Inventory:");
    for (Map.Entry<Integer, ItemSlot> entry : itemSlots.entrySet()) {
        int slot = ((ItemSlot) entry).getSlotNumber();
        int quantity = ((ItemSlot) entry).getQuantity();
        String name = ((ItemSlot) entry).getItemName();
        System.out.println("Slot " + slot + ": " + quantity + " " + name);
    }

    // Print the ending inventory
    System.out.println("Ending Inventory:");
    for (Map.Entry<Integer, ItemSlot> entry : itemSlots.entrySet()) {
        System.out.println("Slot " + itemSlots.getSlotNumber() + ": " + itemSlots.getQuantity() + " " + itemSlots.getItem().getItemName());
    }

    // Print the total sales
    System.out.println("Total Sales: $" + totalSales);
}
}