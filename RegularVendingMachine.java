import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class RegularVendingMachine{
    private HashMap<Item, Integer> itemSlots;
    private ArrayList<Transaction> sales;
    private Inventory inventory;
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;

    Scanner sc = new Scanner(System.in);
    
    public RegularVendingMachine(HashMap<Item, Integer> slot, Inventory inventory){
        this.itemSlots = slot;
        this.inventory = inventory;
        sales = new ArrayList<>();
    }

    public boolean selectingItems(String itemName){
        boolean found = false, c = false, q = false, n = false, m = false;
        int money = inventory.getUserTotalMoney();
        int amount = inventory.getTotalMoney();
        int remaining = 0, profit;
        String choice;

        int quantity = 0, price = 0, calories = 0;
        String name = null;

        for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
            Item item = items.getKey();
            quantity = items.getValue();
            name = item.getName();
            price = item.getPrice();
            calories = item.getCalories();
            if (itemName.equalsIgnoreCase(item.getName())) {
                if (itemName.equalsIgnoreCase(item.getName()) && quantity > 0) {
                    if (itemName.equalsIgnoreCase(item.getName()) && quantity > 0 && money >= price) {
                        System.out.println("The calories of the item " + name + " is " + calories);
                        System.out.println("You want to continue? [Y/N]");
                        choice = sc.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            remaining = money - price;
                            profit = amount + price; 

                            boolean calcu = calculateChange(price, money);
                            if (!calcu){
                                n = true;
                                q = true;
                                m = true;
                                c = false;
                                found = false;
                                break;
                                

                            }
                            else if (calcu){
                                inventory.setUserTotalMoney(remaining);
                                inventory.setTotalMoney(profit);
                                quantity--;
                                itemSlots.put(item, quantity);
                                calculateCollect(price, money);
                                Transaction transaction = new Transaction(item.getName(),price,1);
                                sales.add(transaction);
                                
                                n = true;
                                q = true;
                                m = true;
                                c = true;
                                found = true;
                                break;
                            }  
                        }
                        else {   
                            n = false;
                            q = false;
                            m = false;
                            c = false;
                            found = false;
                            break;
                        }
                    }
                    else {
                        found = false;
                        q = true;
                        n = true;
                        m = false;
                        break;
                    }
                } 
                else {
                    found = false;
                    n = true;
                    q = false;
                    break;
                }
            }
            else {
                found = true;
                n = false;
            }
        }
        if (found && c && q && m && n){
            System.out.println("Dispensed the item");
            System.out.println();
            System.out.println("--------------RECEIPT---------------");
            System.out.println("Iteam: "+ name);
            System.out.println("Price: "+ price);
            System.out.println("Change: "+ remaining);
            System.out.println("------------------------------------");
            System.out.println("Purchase successful.");


            inventory.setUserTotalMoney(0);
            return true;
        }
        else if (!found && !n && !m && !q && !c){
            System.out.println("Cancelled");
            inventory.setUserTotalMoney(0);
            return true;
        }
        else if (!n && found){
            System.out.println("Can't find the item " + itemName);
            return false;
        }
        else if (!m){
            System.out.println("Not enough money to purchase << Insered: " + money + " item price: " + price);
            return false;
        }
        else if (!q){
             System.out.println("Not enough quantity for the item"  + name);
             return false;
        }
        else if (!c){
            System.out.println("Not enough money to produce change");
            return false;
        }
        return true;
    }


    public boolean calculateChange(int price, int InsertMoney) {
        int changeAmount = InsertMoney - price;
        int quantity, amount = 0;
        boolean changed = false;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

         // Calculate the change in denominations
        for (int denomination : denominations) {
            if (changeAmount >= denomination) {
                quantity = changeAmount / denomination;
                amount = temp.get(denomination);
                if (quantity > amount) {
                    changed = false;
                }
                else{
                    inventory.setUserMoney(denomination, quantity);
                    changeAmount -= denomination * quantity; 
                    changed = true;
                }
            }
        }
        return changed;
    }

    public void calculateCollect(int price, int InsertMoney) {
        int changeAmount = InsertMoney - price;
        int collectedAmount = InsertMoney;
        int amount = 0, quantity;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

         // Calculate the change in denominations
        for (int denomination : denominations) {
            if (changeAmount >= denomination) {
                quantity = changeAmount / denomination;
                amount = temp.get(denomination);
                quantity = amount - quantity;
                inventory.setMoney(denomination, quantity);
                changeAmount -= denomination * quantity;
            }
        }

        for (int denomination : denominations) {
            if (collectedAmount >= denomination) {
                quantity = collectedAmount / denomination;
                amount = temp.get(denomination);
                quantity = amount + quantity;
                inventory.setMoney(denomination, quantity);
                collectedAmount -= denomination * quantity;
            }
        }
    }
   
    
    public void insertMoney(){
        int num, total = 0, choice = -1;
        
        while(choice != 0){
            System.out.println("The money you inserted");
            System.out.println("[1]: 1000  [2]: 500  [3]:200");
            System.out.println("[4]: 100   [5]: 50   [6]:20");
            System.out.println("[7]: 10    [8]: 5    [9]:1");
            System.out.println("           [0]:Exit");
            System.out.print("Enter the number: ");    
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0){
                System.out.println("Exit the inserting of money");
                break;
            }
            System.out.print("How many times: ");
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
            total += denomination*value;
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

    public void addItem(String name, int price, int calories, int quantity) {
        Item item = new Item(name, price, calories);
        itemSlots.put(item,quantity); 
    }

    public void removeItem(String name) {
        String itemName;
        int i = 0;
        for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
            Item item = items.getKey();
            itemName = item.getName();
            i++;
            if (itemName.equalsIgnoreCase(name)){
                itemSlots.remove(name);
                System.out.println("Successfully removed");
            }
        }
    }


    public void maintenance() {
        int choice = 0;
        int num, price = 0, calories = 0, totalPayment = 0, amount = 0, total, quantity, denomination;
        String itemName, name;
        boolean found = false;
        HashMap<Integer, Integer> temp;

        while(choice != 8){
            System.out.println("1: Restocking");
            System.out.println("2: Change Price");
            System.out.println("3: Collecting Payment");
            System.out.println("4: Replenishing Money");
            System.out.println("5: Printing Summary of the transactions");
            System.out.println("6: Add New Items");
            System.out.println("7: Remove Items");
            System.out.println("8: Exit");
            System.out.print("Enter a Number: ");
            choice = Integer.parseInt(sc.nextLine());
        
            switch(choice){
                
                case 1:
                    displayAvailableItems();
                    System.out.println("Enter the Name");
                    itemName = sc.nextLine();

                    for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
                        Item item = items.getKey();
                        quantity = items.getValue();
                        name = item.getName();
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
                        quantity = items.getValue();
                        name = item.getName();
                        price = item.getPrice();
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
                    total = inventory.getTotalMoney();
                    temp = inventory.getMoney();
                    int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
                    System.out.println("3: Collecting Payment");

                    for (Transaction transaction : sales) {
                        name = transaction.getName();
                        price = transaction.getPrice();
                        quantity = transaction.getQuantity();

                        int payment = price * quantity;
                        totalPayment += payment;
                    }
                    System.out.println("Total payment collected: " + totalPayment + " Peso");
                    for(int Denomination : denominations){ 
                        amount = temp.get(Denomination);
                        System.out.println("Collect " + amount + " " + Denomination + " successfully.");   
                    }
                    

                    break;
                case 4: 
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

                    printTransactionSummary();
                    break;
                case 6:
                    System.out.println("Create new Item");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = Integer.parseInt(sc.nextLine());
                    System.out.print("Calories: ");
                    calories = Integer.parseInt(sc.nextLine());
                    System.out.print("Quantity: ");
                    quantity = Integer.parseInt(sc.nextLine());

                    addItem(name, price, calories, quantity); 
                    break;
                case 7: 
                    displayAvailableItems();
                    System.out.println("Remove a Item");
                    System.out.print("Name of it: ");
                    name = sc.nextLine();

                    removeItem(name);
                    break;
                case 8: 
                    System.out.println("EXit");
                    break; 
                default:
                    System.out.println("Input Again\n");
                    break;
            }
        }
    }

    public void printTransactionSummary() {
    System.out.println("Transaction Summary:");

    for (Transaction transaction : sales) {
        String itemName = transaction.getName();
        int price = transaction.getPrice();
        int quantity = transaction.getQuantity();
        int totalAmount = price * quantity;

        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("------------------------");
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