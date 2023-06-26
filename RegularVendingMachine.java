import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class RegularVendingMachine{
    private HashMap<Item, Integer> itemSlots;
    private ArrayList<Transaction> transactions;
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;

    Scanner sc = new Scanner(System.in);
    
    public RegularVendingMachine(HashMap<Item, Integer> slot){
        this.itemSlots = slot;
        transactions = new ArrayList<>();
    }

    public void selectingItems(){
        
    }
     
    /*
    public Integer getItemSlot(Item item) {
        return itemSlots.get(item);
    } */

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Map.Entry<Item, Integer> entry : itemSlots.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            String name = item.getName();
            int price = item.getPrice();
            String output = String.format("%-10s| %-6d| %-8d", name, price, quantity);
            if (quantity >= 1){
                System.out.println(output);
            }
            else{
                System.out.println(output);
                System.out.print("SOLD OUT");
            } 
            
        }

    }

    public boolean receivePayment(int amount) { 
        // Process the payment from the user
        return true; // Placeholder return value
    }

    public void dispenseItem(Integer slotNumber) {
        // Dispense the item from the specified slot
    }

    public void replenishMoney() {
        HashMap<Integer, Integer> temp;

    }

    public int computeStartingInventory() {
        int startingInventoryCount = 0;
        for (int quantity : itemSlots.values()) {
            startingInventoryCount += quantity;
        }
        return startingInventoryCount;
    }

    public int computeEndingInventory() {
        int endingInventoryCount = 0;
        for (int quantity : endingInventory.values()) {
            endingInventoryCount += quantity;
        }
        return endingInventoryCount;
    }



    public void maintenance() {
        // Perform maintenance tasks on the vending machine
        
        int choice = 0;
        int num;
        String itemName;
        boolean found = false;

        while(choice !=6){
            System.out.println("1: Restocking");
            System.out.println("2: Change Price");
            System.out.println("3: Collecting Payment");
            System.out.println("4: Replenishing Money");
            System.out.println("5: Printing Summary of the transactions");
            System.out.println("6: Exit");
            choice = Integer.parseInt(sc.nextLine());
        
            switch(choice){
                case 1:
                    displayAvailableItems();
                    System.out.println("Enter the Name");
                    itemName = sc.nextLine();

                    for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
                        Item item = items.getKey();
                        int quantity = items.getValue();
                        String name = item.getName();
                        if (itemName.equalsIgnoreCase(item.getName())) {
                            System.out.println("What quantity you want to apply to "+ item.getName());
                            num = Integer.parseInt(sc.nextLine());
                            quantity = num;
                            itemSlots.put(item, quantity);
                            found = true;
                        }
                    }

                    if (!found){
                         System.out.println("Can't find the item");
                    }
                    break;
                case 2: 
                    displayAvailableItems();
                    System.out.println("Enter the Name");
                    itemName = sc.nextLine();

                    for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
                        Item item = items.getKey();
                        int quantity = items.getValue();
                        String name = item.getName();
                        int price = item.getPrice();
                        if (itemName.equalsIgnoreCase(item.getName())) {
                            System.out.println("What Price you want to apply to "+ item.getName());
                            num = Integer.parseInt(sc.nextLine());
                            price = num;
                            item.setPrice(price);
                            found = true;
                        }
                    }

                    if (!found){
                         System.out.println("Can't find the item");
                    }
                    break;
                case 3:
                    System.out.println("3: Collecting Payment");

                    break;
                case 4: 
                    System.out.println("4: Replenishing Money");


                    break;
                case 5:
                    System.out.println("Printing Summary of the transactions");

                    //printTransactionSummary();
                    break;
                case 6: 
                    System.out.println("EXit");
                    break;
            }
        }
    }

    /* public void printTransactionSummary() {
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
    } */
}