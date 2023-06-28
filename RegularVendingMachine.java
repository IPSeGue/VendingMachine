import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a regular vending machine that allows users to select items and make purchases.
 * Let the owner to do maintenance operation to the machine.
 */
public class RegularVendingMachine{
    private HashMap<Item, Integer> itemSlots;
    private ArrayList<Transaction> sales;
    private Inventory inventory;
    private HashMap<Item, Integer> startingInventory;
    private HashMap<Item, Integer> endingInventory;

    Scanner sc = new Scanner(System.in);

    /**
     * Creates a new regular vending machine with the given item slots and inventory.
     *
     * @param itemSlots  the slots containing the available items and their quantities
     * @param inventory  the inventory of the vending machine
     */
    public RegularVendingMachine(HashMap<Item, Integer> slot, Inventory inventory){
        this.itemSlots = slot;
        this.inventory = inventory;
        sales = new ArrayList<>();
    }

     /**
     * Allows the user to select an item and proceed with the purchase.
     *
     * @param itemName  the name of the item to be selected
     * @return true if the purchase was successful, false otherwise
     */
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
                        System.out.println("The calories of " + name + " is " + calories);
                        System.out.println("Continue with Purchase? [Y/N]");
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
            System.out.println("Item: "+ name);
            System.out.println("Price: "+ price);
            System.out.println("Change: "+ remaining);
            System.out.println("------------------------------------");
            System.out.println("Purchase successful.");


            inventory.setUserTotalMoney(0);
            return true;
        }
        else if (!found && !n && !m && !q && !c){
            System.out.println("Transaction Cancelled.");
            inventory.setUserTotalMoney(0);
            return true;
        }
        else if (!n && found){
            System.out.println("Can't find the item " + itemName);
            return false;
        }
        else if (!m){
            System.out.println("Not enough money to purchase << Inserted: " + money + " item price: " + price);
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

    /**
     * Calculates and updates the change to be given based on the price and the amount of money inserted.
     *
     * @param price         the price of the item
     * @param insertedMoney the amount of money inserted by the user
     * @return true if change can be given, false otherwise
     */
    public boolean calculateChange(int price, int InsertMoney) {
        int changeAmount = InsertMoney - price;
        int quantity, amount = 0;
        boolean changed = false;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        
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

    /**
     * Calculates the change and updates the collected money based on the price and the amount of money inserted.
     *
     * @param price         the price of the item
     * @param insertedMoney the amount of money inserted by the user
     */
    public void calculateCollect(int price, int InsertMoney) {
        int changeAmount = InsertMoney - price;
        int collectedAmount = InsertMoney;
        int amount = 0, quantity, num;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

         // Calculate the change in denominations
        for (int denomination : denominations) {
            if (changeAmount >= denomination) {
                quantity = changeAmount / denomination;
                amount = temp.get(denomination);
                num = quantity;
                quantity = amount - quantity;
                inventory.setMoney(denomination, quantity);
                changeAmount -= denomination * num;
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
   
    /**
     * Allows the user to insert bills or coins into the vending machine.
     */
    public void insertMoney(){
        int num, total = 0, choice = -1;
        
        while(choice != 0){
            System.out.println("Please insert the bills/coins you wish to use:");
            System.out.println("[1]: 1000  [2]: 500  [3]:200");
            System.out.println("[4]: 100   [5]: 50   [6]:20");
            System.out.println("[7]: 10    [8]: 5    [9]:1");
            System.out.println("           [0]:Exit");
            System.out.print("Enter the number: ");    
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 0){
                System.out.println("Insertion complete! Proceeding to Transaction...");
                System.out.println("====================");
                break;
            }
            System.out.print("Amount of bills/coins inserted: ");
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
            System.out.println("Amount Inserted: " + total);
            System.out.println("========================");
        }
    }

    /**
     * Displays the available items in the vending machine.
     * Prints the name, price, and quantity of each item.
     * If an item is sold out, it is marked as "SOLD OUT".
     */
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
        System.out.println("========================");
    }

    /**
     * Replenishes the inventory with the specified denomination and quantity.
     *
     * @param denomination the denomination of the bills/coins to replenish
     * @param quantity     the quantity of bills/coins to replenish
     */
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

    /**
     * Computes the total count of items in the vending machine's starting inventory.
     *
     * @return the count of items in the starting inventory
     */
    public int computeStartingInventory() {
        int startingInventoryCount = 0;
        for (int quantity : itemSlots.values()) {
            startingInventoryCount += quantity;
        }
        return startingInventoryCount;
    }

    /**
     * Computes the total count of items in the vending machine's ending inventory.
     *
     * @return the count of items in the ending inventory
     */
    public int computeEndingInventory() {
        int endingInventoryCount = 0;
        for (int quantity : endingInventory.values()) {
            endingInventoryCount += quantity;
        }
        return endingInventoryCount;
    }

    /**
     * Adds an item to the vending machine's inventory with the specified details.
     *
     * @param name     the name of the item
     * @param price    the price of the item
     * @param calories the calories of the item
     * @param quantity the quantity of the item to add
     */
    public void addItem(String name, int price, int calories, int quantity) {
        Item item = new Item(name, price, calories);
        itemSlots.put(item,quantity); 
    }

    /**
     * Removes an item from the vending machine's inventory based on the specified name.
     *
     * @param name the name of the item to remove
     */
    public void removeItem(String name) {
        Iterator<Map.Entry<Item, Integer>> iterator  = itemSlots.entrySet().iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Map.Entry<Item, Integer> entry = iterator.next();
            Item item = entry.getKey();
            String itemName = item.getName();

            if (itemName.equalsIgnoreCase(name)) {
                iterator.remove(); // Safely remove the item from the HashMap
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Item '" + name + "' has been successfully removed.");
        } else {
            System.out.println("Item '" + name + "' does not exist in the inventory.");
        }
    }

    /**
     * Enters maintenance mode for the vending machine.
     * Provides various maintenance options to restock items, change prices,
     * collect payment, replenish money, print transaction summaries, add new items,
     * and remove items from the inventory.
     */
    public void maintenance() {
        int choice = 0;
        int num, price = 0, calories = 0, totalPayment = 0, amount = 0, total, quantity, denomination;
        String itemName, name;
        boolean found = false, i = false;
        HashMap<Integer, Integer> temp;

        while(choice != 8){
            displayAvailableItems();
            System.out.println("Maintenance Options:");
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
                    System.out.print("Enter the Product Name: ");
                    itemName = sc.nextLine();

                    for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
                        Item item = items.getKey();
                        quantity = items.getValue();
                        name = item.getName();
                        if (itemName.equalsIgnoreCase(item.getName())) {
                            System.out.println("What is the new quantity of "+ item.getName() + " [At least 10]");
                            num = Integer.parseInt(sc.nextLine());
                            if (num >= 10){
                                quantity = num;
                                itemSlots.put(item, quantity);
                                found = true;
                            }
                            else {
                                found = true;
                                i = false;
                            }
                        }
                    }

                    if (!found){
                        System.out.println("Unable to Find the item.");
                    }
                    else if (!i && found){
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    break;
                case 2: 
                    displayAvailableItems();
                    System.out.print("Enter the Product Name: ");
                    itemName = sc.nextLine();

                    for (Map.Entry<Item, Integer> items : itemSlots.entrySet()) {
                        Item item = items.getKey();
                        quantity = items.getValue();
                        name = item.getName();
                        price = item.getPrice();
                        if (itemName.equalsIgnoreCase(item.getName())) {
                            System.out.println("Please input new price of "+ item.getName());
                            num = Integer.parseInt(sc.nextLine());
                            
                            price = num;
                            item.setPrice(price);
                            found = true;
                        }
                    }

                    if (!found){
                         System.out.println("Unable to Find the item.");
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
                    System.out.println("New Item Creation");
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
                    System.out.println("Item Removal");
                    System.out.print("Name of Product: ");
                    name = sc.nextLine();

                    removeItem(name);
                    break;
                case 8: 
                    System.out.println("Exit");
                    break; 
                default:
                    System.out.println("Please input a valid number.\n");
                    break;
            }
        }
    }

    /**
     * Prints a summary of the transactions made in the vending machine.
     * Displays the item name, price, quantity, and total amount for each transaction.
     */
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
            System.out.println("=========================");
        }
    }
}