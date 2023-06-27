import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class RegularVendingMachine{
    private HashMap<Item, Integer> itemSlots;
    private ArrayList<Transaction> transactions;
    private Inventory inventory;
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;

    Scanner sc = new Scanner(System.in);
    
    public RegularVendingMachine(HashMap<Item, Integer> slot, Inventory inventory){
        this.itemSlots = slot;
        this.inventory = inventory;
        transactions = new ArrayList<>();
    }

    public void selectingItems(){
        
    }
     
    public void insertMoney(){
        int num, total = 0, choice = -1;
        
        while(choice != 0){
            System.out.println("The money you inserted");
            System.out.println("[1]: 1000  [2]: 500  [3]:200");
            System.out.println("[4]: 100   [5]: 50   [6]:20");
            System.out.println("[7]: 10    [8]: 5    [9]:1");
            System.out.println("           [0]:Exit");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0){
                System.out.println("Exit the inserting of money");
                break;
            }
            System.out.println("How many times");
            num = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: 
                    inventory.setUserMoney(1000, num);
                    total += 1000*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 2: 
                    inventory.setUserMoney(500, num);
                    total += 500*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 3: 
                    inventory.setUserMoney(200, num);
                    total += 200*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 4: 
                    inventory.setUserMoney(100, num);
                    total += 100*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 5: 
                    inventory.setUserMoney(50, num);
                    total += 50*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 6: 
                    inventory.setUserMoney(20, num);
                    total += 20*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 7: 
                    inventory.setUserMoney(10, num);
                    total += 10*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 8: 
                    inventory.setUserMoney(5, num);
                    total += 5*num;
                    inventory.setUserTotalMoney(total);
                    break;
                case 9: 
                    inventory.setUserMoney(1, num);
                    total += 1*num;
                    inventory.setUserTotalMoney(total);
                    break;
            }
        }
    }

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

    public void replenishMoney(int denomination, int quantity){
        HashMap<Integer, Integer> temp;
        int value, amount, total;
        total = inventory.getTotalMoney();
        temp = inventory.getMoney();
        
        if (temp.containsKey(denomination)) {
            amount = temp.get(denomination);
            value = quantity;
            quantity += amount;
            inventory.setMoney(denomination, quantity);
            total += 1000*value;
            inventory.setTotalMoney(total);
            System.out.println("Replenished " + quantity + " " + denomination + " successfully.");
        } else {
            System.out.println("Denomination not found in the money inventory.");
        }
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
            System.out.print("Enter a Number: ");
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
                    int denomination, quantity;
                    System.out.println("The Bill/Coin to replenish");
                    System.out.println("1000 | 500 | 200 | 100  | 50 | 20 | 10 | 5 | 1");
                    System.out.print("Enter the bill value: ");
               
                    denomination = Integer.parseInt(sc.nextLine());
                    if (denomination == 1000 || denomination == 500 || denomination == 200|| denomination == 100 || denomination == 50 || denomination == 20 || denomination == 10 || denomination == 5 || denomination == 1){
                        System.out.print("How many what to add: ");
                        quantity = Integer.parseInt(sc.nextLine());
                        replenishMoney(denomination,quantity);
                    }
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