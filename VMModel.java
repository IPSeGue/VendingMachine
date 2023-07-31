import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author o_0
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
    
    public void resetStartInventory(){
        for(int denomination : DENOMINATIONS){
            money.put(denomination, 0);
            
        }
        total = 0;
        inventory.setTotalMoney(total);
    }
    
    public void create(HashMap<Item, Integer> slot, Inventory money, String name, boolean check){
        this.slot = slot;
        this.inventory = money;
        this.name = name;
        this.vending = check;
    }
    
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
                
                quantity = amount + quantity;
                
                inventory.setMoney(denomination, quantity);
                collectedAmount -= denomination * quantity;
            }
        }
    }
    
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
    
    public void addNewItem(String n, String p, String c, String q){
        
        int newP = Integer.parseInt(p);
        int newC = Integer.parseInt(c);
        int newQ = Integer.parseInt(q);

        if(!n.isEmpty() && !p.isEmpty() && !c.isEmpty() && !q.isEmpty() && newQ >= 10){
            Item item = new Item(n, newP,newC);
            slot.put(item,newQ);
        }

        
    }
    
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
    
    public Inventory getInventory(){
        return this.inventory;
    }
    
    public HashMap<Item,Integer> getSlots(){
        return this.slot;
    }
    
   public ArrayList<Transaction> getSales(){
        return this.sales;
    }
        
    public String getName(){
        return this.name;
    }
    
    public boolean check(){
        return this.vending;
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public int getCalories(){
        return this.calories;
    }
    
    public int getChange(){
        return this.change;
    }
   
    public int getCount(){
        return this.count;
    }
    
    public int getValueP(){
        return this.valueP;
    }
    
    public int getValueC(){
        return this.valueC;
    }
    
    public ArrayList<String> getListItem(){
        return this.listName;
    }
    
    public int getTotal(){
        return this.total;
    }
    
    public void setValueP(int value){
        this.valueP = value;
    }
    
    public void setValueC(int value){
        this.valueC = value;
    }
    
    public void setTempSlot(){
        this.tempSlot.clear();
    }
    
    public void setTListName(){
        this.listName.clear();
    }
    
    public void setInventory(Inventory newInventory){
       this.inventory = newInventory;
    }
}
