import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The VMModel class represents the Model component of the Vending Machine application. It stores the state and data related to the vending machine, manages the inventory, sales, and handles various vending operations.
 */
public class VMModel {
    private JFrame frame;
    private boolean vending;
    
    private String name;
    private HashMap<Item, Integer> slot = new HashMap<>();
    private HashMap<Item, Integer> tempSlot;
    private Inventory inventory;
    private ArrayList<Transaction> sales;
    private ArrayList<String> listName = new ArrayList<>();
    private HashMap<Integer, Integer> money = new HashMap<>();;
    private HashMap<Integer, Integer> userMoney = new HashMap<>();;
    private HashMap<Integer, Integer> temp;
    private int num, valueP = 0, valueC = 0;
    private String itemName;
    private int price, quantity, calories, change, count;
    private int total = 0;
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    /**
     * Constructs a new VMModel object representing the Vending Machine's state and data.
     */
    public VMModel(){
        frame = new JFrame();
        temp = new HashMap<>();
        sales = new ArrayList<>();
        tempSlot = new HashMap<>();
        for(int denomination : DENOMINATIONS){ 
            this.userMoney.put(denomination,0);
            this.money.put(denomination, 0);
        }
        
        inventory = new Inventory(0,0,money,userMoney);
    }
    
    /**
     * Sets the default items in the vending machine's slots with initial quantities.
     * @param text The text representing a default item (not used in the method).
     */
    public void defaultItem(String text){
        Item Water = new Item("Water", 21, 0);
        Item Coke = new Item("Coke", 99, 139);
            Item Chocolate = new Item("Chocolate", 198, 546);
            Item Coffee = new Item("Coffee", 57, 1);
            Item Tea = new Item("Tea", 226, 2);
            Item IcedTea = new Item("IcedTea", 555, 35);
            Item Milk = new Item("Milk", 374, 42);
            Item Wine = new Item("Wine", 23, 83);
            Item Soda = new Item("Soda", 72, 41);
            Item Juice = new Item("Juice", 90, 54);

            int quantity = 10;
            slot.put(Water, quantity);
            slot.put(Coke, quantity);
            slot.put(Chocolate, quantity);
            slot.put(Coffee, quantity);
            slot.put(Tea, quantity);
            slot.put(IcedTea, quantity);
            slot.put(Milk, quantity);
            slot.put(Wine, quantity);
            slot.put(Soda, quantity);
            slot.put(Juice, quantity);
    }
    
    /**
     * Adds the specified number of money units to the vending machine's money inventory.
     * @param text The text representing the number of money units to add.
     */
    public void addStartInventory(String text){
        num = Integer.parseInt(text);
        int tempM, tempQ = 0;
        for (Map.Entry<Integer, Integer> entry : money.entrySet()) {
            tempM = entry.getKey();
            tempQ = entry.getValue();
        }
        tempQ += num;
        for(int denomination : DENOMINATIONS){
            money.put(denomination,tempQ);
            total += denomination * num;
        }
        
        inventory = new Inventory(0,total,money,userMoney);
        
    }
    
    /**
     * Resets the vending machine's money inventory by setting the quantity of each denomination to 0.
     */
    public void resetStartInventory(){
        for(int denomination : DENOMINATIONS){
            money.put(denomination, 0);
            
        }
        total = 0;
        inventory.setTotalMoney(total);
    }
    
    /**
     * Creates a new vending machine with the specified slot items, money inventory, vending machine name, and vending mode.
     * @param slot A HashMap representing the items and their quantities in the vending machine slots.
     * @param money The Inventory object representing the money inventory of the vending machine.
     * @param name The name of the vending machine.
     * @param check A boolean flag indicating the vending mode (regular or special).
     */
    public void create(HashMap<Item, Integer> slot, Inventory money, String name, boolean check){
        this.slot = slot;
        this.inventory = money;
        this.name = name;
        this.vending = check;
    }
    
    /**
     * Handles the regular buying process for the specified item in the vending machine.
     * @param input The name of the item the user wants to purchase.
     * @param sum The amount of money inserted by the user.
     * @return True if the purchase is successful; otherwise, false.
     */
    public boolean regularBuy(String input, int sum){
        String name = "";
        int check = 0;
        calories = 0;
        quantity = 0;
        price = 0;
        Item temp;
        Item item = new Item("", 0,0);
        boolean calcu = false, display = false; 
        for (Map.Entry<Item, Integer> entry : slot.entrySet()) {
            temp = entry.getKey();
            quantity = entry.getValue();
            if (temp.getName().equalsIgnoreCase(input)){
                name = temp.getName();
                price = temp.getPrice();
                calories = temp.getCalories();
                check = quantity;
                item = entry.getKey();
                calcu = calculateChange(price,sum);
            } 
        }
        if (name.equalsIgnoreCase(input) && sum >= price && check > 0 && calcu){ 
            check--;
            slot.put(item,check);
            Transaction transaction = new Transaction(name, price,1);
            sales.add(transaction);
            calculateCollect(price,sum);
            change = sum - price;
            
            display = true;  
        }
        else if(name.equalsIgnoreCase(input) == false){
            JOptionPane.showMessageDialog(frame, "Can't find the item " + input);
        }
        else if(sum >= price == false){
            JOptionPane.showMessageDialog(frame, "Not enough money to purchase << Inserted: " + sum + " item price: " + price);
        }
        else if(check > 0 == false){
            JOptionPane.showMessageDialog(frame, "Not enough quantity for the item " + name);
        }
        else if(!calcu){
            JOptionPane.showMessageDialog(frame, "Not enough money to produce change ");
        }
        return display;
    }
    
    /**
     * Handles the seller's buying process when multiple items are involved.
     * @param input The name of the item the seller wants to purchase.
     * @param sum The amount of money inserted by the seller.
     * @return True if the purchase is successful; otherwise, false.
     */
    public boolean sellerBuy(String input, int sum){
        String name = "";
        change = 0;
        calories = 0;
        quantity = 0;
        price = 0;
        Item item;
        boolean calcu = false, display = false;

        price = valueP;
        calcu = calculateChange(price,sum);

        if (sum >= price && calcu){
            count = 0;
            for (Map.Entry<Item, Integer> entry : tempSlot.entrySet()) {
                item = entry.getKey();
                quantity = entry.getValue();
                quantity--;
                slot.put(item,quantity);
                name = item.getName();
                price = item.getPrice();
                listName.add(name);
                Transaction transaction = new Transaction(name, price,1);
                sales.add(transaction);
                count++;
            }
            price = valueP;
            calories = valueC;
            calculateCollect(price,sum);
            change = sum - price;
            display = true;

        }
        else if(sum >= price == false){
            JOptionPane.showMessageDialog(frame, "Not enough money to purchase << Inserted: " + sum + " item price: " + price);
        }
        else if(!calcu){
            JOptionPane.showMessageDialog(frame, "Not enough money to produce change ");
        }

        valueP = 0;
        valueC = 0;
        return display;
    }
    
    /**
     * Calculates the change for a given price and the amount of money inserted.
     * @param price The price of the item.
     * @param insertMoney The amount of money inserted.
     * @return True if change can be provided; otherwise, false.
     */
    public boolean calculateChange(int price, int insertMoney) {
        int changeAmount = insertMoney - price;
        int amount = 0;
        boolean changed = false;
        HashMap<Integer, Integer> tempMoney = new HashMap<>();
        tempMoney = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        for (int denomination : denominations) {
            if (changeAmount >= denomination) {
                quantity = changeAmount / denomination;
                amount = tempMoney.get(denomination);
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
     * Calculates the money collected and updates the money inventory after a successful purchase.
     * @param price The price of the purchased item.
     * @param insertMoney The amount of money inserted by the user.
     */
    public void calculateCollect(int price, int insertMoney) {
        int changeAmount = insertMoney - price;
        int collectedAmount = insertMoney;
        int amount = 0;
        HashMap<Integer, Integer> tempMoney = new HashMap<>();
        tempMoney = inventory.getMoney();
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

         // Calculate the change in denominations
        for (int denomination : denominations) {
            if (changeAmount >= denomination) {
                quantity = changeAmount / denomination;
                amount = tempMoney.get(denomination);
                num = quantity;
                quantity = amount - quantity;
                inventory.setMoney(denomination, quantity);
                changeAmount -= denomination * num;
            }
        }

        for (int denomination : denominations) {
            if (collectedAmount >= denomination) {
                quantity = collectedAmount / denomination;
                amount = tempMoney.get(denomination);
                num = quantity;
                quantity = amount + quantity;
                
                inventory.setMoney(denomination, quantity);
                collectedAmount -= denomination * num;
            }
        }
    }
    
    /**
     * Handles the process of adding an item to the shopping cart.
     * @param text The name of the item to be added to the shopping cart.
     * @return True if the item is added successfully; otherwise, false.
     */
    public boolean addBuyItem(String text){
        boolean checkN = false, display = false;
        for (Map.Entry<Item, Integer> entry : slot.entrySet()) {
            Item item = entry.getKey();
            if (item.getName().equalsIgnoreCase(text)){
                quantity = entry.getValue();
                checkN = true;
                if (quantity > 0){
                    valueP += item.getPrice();
                    valueC += item.getCalories();
                    tempSlot.put(item, quantity);
                    name = item.getName();
                    price = item.getPrice();
                    calories = item.getCalories();
                    display = true;
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Not enough quantity for the item");
                }
            }
        }
        if (!checkN){
            JOptionPane.showMessageDialog(frame, "Can't find the item");
        }
        return display;
        
    }
    
    /**
     * Updates information about an item in the vending machine inventory, such as restocking quantity or changing its price.
     * @param n The name of the item to be updated.
     * @param r The restocking quantity for the item (can be empty).
     * @param c The new price for the item (can be empty).
     */
    public void updateInfo(String n, String r, String c){
        int restocking;
        int changePrice;
        int amount, q = 0;
        Item temp = new Item("",0,0);

        boolean found = false;
        for (Map.Entry<Item, Integer> entry : slot.entrySet()) {
            Item item = entry.getKey();
            amount = entry.getValue();
            if (item.getName().equalsIgnoreCase(n)){
                q = amount;
                temp = item;
                found = true;
            }
        }
        if(!r.isEmpty() && c.isEmpty() && found){
            restocking = Integer.parseInt(r);
            if (restocking < 10){
                JOptionPane.showMessageDialog(frame, "Invalid input [less than 10]. Please enter a valid number");
            }
            else {
                slot.put(temp,restocking);
            }
        }
        else if(r.isEmpty() && !c.isEmpty() && found){
            changePrice = Integer.parseInt(c);
            temp.setPrice(changePrice);
            slot.put(temp,q);
        }
        else if (!found){
            JOptionPane.showMessageDialog(frame, "Unable to Find the item.");
        }
        else {
            JOptionPane.showMessageDialog(frame, "Please enter one of the fields");
        }
    }
    
    /**
     * Adds a new item to the vending machine inventory.
     * @param n The name of the new item.
     * @param p The price of the new item.
     * @param c The calories of the new item.
     * @param q The quantity of the new item in stock.
     */
    public void addNewItem(String n, String p, String c, String q){
        
        int newP = Integer.parseInt(p);
        int newC = Integer.parseInt(c);
        int newQ = Integer.parseInt(q);

        if(!n.isEmpty() && !p.isEmpty() && !c.isEmpty() && !q.isEmpty() && newQ >= 10){
            Item item = new Item(n, newP,newC);
            slot.put(item,newQ);
        }

        
    }
    
    /**
     * Removes an item from the vending machine inventory.
     * @param n The name of the item to be removed.
     */
    public void removeItem(String n){
        
        Iterator<Map.Entry<Item, Integer>> iterator  = slot.entrySet().iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Map.Entry<Item, Integer> entry = iterator.next();
            Item item = entry.getKey();
            String itemName = item.getName();

            if (itemName.equalsIgnoreCase(n)) {
                iterator.remove(); // Safely remove the item from the HashMap
                found = true;
                break;
            }
        }
        
        if (found) {
            JOptionPane.showMessageDialog(frame, "Item '" + n + "' has been successfully removed.");
        } else {
            JOptionPane.showMessageDialog(frame,"Item '" + n + "' does not exist in the inventory.");
        }
    }
    
    /**
     * Get the inventory of the vending machine.
     * @return The Inventory object representing the current state of the vending machine inventory.
     */
    public Inventory getInventory(){
        return this.inventory;
    }
    
    /**
     * Get the HashMap representing the available slots and quantities of items in the vending machine.
     * @return A HashMap with Item objects as keys and Integer values representing the quantity of each item.
     */
    public HashMap<Item,Integer> getSlots(){
        return this.slot;
    }
    
    /**
     * Get the list of transactions representing the sales made in the vending machine.
     * @return An ArrayList of Transaction objects representing the sales made in the vending machine.
     */
    public ArrayList<Transaction> getSales(){
        return this.sales;
    }
    
    /**
     * Get the name of the vending machine.
     * @return A String representing the name of the vending machine.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Check whether the vending machine is operational or not.
     * @return A boolean value indicating whether the vending machine is operational (true) or not (false).
     */
    public boolean check(){
        return this.vending;
    }
    
    /**
     * Get the name of the last item bought from the vending machine.
     * @return A String representing the name of the last item bought from the vending machine.
     */
    public String getItemName(){
        return this.itemName;
    }
    
    /**
     * Get the price of the last item bought from the vending machine.
     * @return An integer representing the price of the last item bought from the vending machine.
     */
    public int getPrice(){
        return this.price;
    }
    
    /**
     * Get the calories of the last item bought from the vending machine.
     * @return An integer representing the calories of the last item bought from the vending machine.
     */
    public int getCalories(){
        return this.calories;
    }
    
    /**
     * Get the change amount from the last transaction made in the vending machine.
     * @return An integer representing the change amount from the last transaction.
     */
    public int getChange(){
        return this.change;
    }
    
    /**
     * Get the count of items bought in the last transaction from the vending machine.
     * @return An integer representing the count of items bought in the last transaction.
     */
    public int getCount(){
        return this.count;
    }
    
    /**
     * Get the total price of the items selected for purchase in the current transaction.
     * @return An integer representing the total price of the items selected for purchase.
     */
    public int getValueP(){
        return this.valueP;
    }
    
    /**
     * Get the total calories of the items selected for purchase in the current transaction.
     * @return An integer representing the total calories of the items selected for purchase.
     */
    public int getValueC(){
        return this.valueC;
    }
    
    /**
     * Get the list of names of items selected for purchase in the current transaction.
     * @return An ArrayList of Strings representing the names of items selected for purchase.
     */
    public ArrayList<String> getListItem(){
        return this.listName;
    }
    
    /**
     * Get the total money available in the vending machine.
     * @return An integer representing the total money available in the vending machine.
     */
    public int getTotal(){
        return this.total;
    }
    
    /**
     * Set the total price of the items selected for purchase in the current transaction.
     * @param value The new total price of the items selected for purchase.
     */
    public void setValueP(int value){
        this.valueP = value;
    }
    
    /**
     * Set the total calories of the items selected for purchase in the current transaction.
     * @param value The new total calories of the items selected for purchase.
     */
    public void setValueC(int value){
        this.valueC = value;
    }
    
    /**
     * Clear the temporary slot containing items selected for purchase in the current transaction.
     */
    public void setTempSlot(){
        this.tempSlot.clear();
    }
    
    /**
     * Clear the list containing names of items selected for purchase in the current transaction.
     */
    public void setTListName(){
        this.listName.clear();
    }
    
    /**
     * Set the inventory of the vending machine to a new state.
     * @param newInventory The new Inventory object representing the updated state of the vending machine inventory.
     */
    public void setInventory(Inventory newInventory){
       this.inventory = newInventory;
    }
}
