import java.util.HashMap;

/**
 * The Inventory class represents a store inventory and tracks the total money and user's total money.
 */
public class Inventory{
    private static int totalMoney = 0;
    private static int userTotalMoney = 0;
    private static HashMap<Integer,Integer> money;
    private static HashMap<Integer,Integer> userMoney;
    
    /**
     * Constructs an Inventory object with the specified initial values.
     *
     * @param totalMoney       The initial total money in the inventory.
     * @param userTotalMoney   The initial user's total money.
     * @param money            The initial money denominations and quantities in the inventory.
     * @param userMoney        The initial user's money denominations and quantities.
     */
    public Inventory(int totalMoney, int userTotalMoney, HashMap<Integer,Integer> money, HashMap<Integer,Integer> userMoney){
        Inventory.totalMoney = totalMoney;
        Inventory.userTotalMoney = userTotalMoney;
        Inventory.money = money;
        Inventory.userMoney = userMoney;
    }

    /**
     * Returns the total money in the inventory.
     *
     * @return The total money in the inventory.
     */
    public int getTotalMoney(){
        return totalMoney;
    }

    /**
     * Returns the user's total money in the inventory.
     *
     * @return The user's total money in the inventory.
     */
    public int getUserTotalMoney(){
        return userTotalMoney;
    }

    /**
     * Returns the money denominations and quantities in the inventory.
     *
     * @return The money denominations and quantities in the inventory.
     */
    public HashMap<Integer,Integer> getMoney(){
        return money;
    }

    /**
     * Returns the user's money denominations and quantities in the inventory.
     *
     * @return The user's money denominations and quantities in the inventory.
     */
    public HashMap<Integer,Integer> getUserMoney(){
        return userMoney;
    }

    /**
     * Sets the total money in the inventory.
     *
     * @param totalMoney The new total money in the inventory.
     */
    public void setTotalMoney(int totalMoney){
        Inventory.totalMoney = totalMoney;
    }

    /**
     * Sets the user's total money in the inventory.
     *
     * @param userTotalMoney The new user's total money in the inventory.
     */
    public void setUserTotalMoney(int userTotalMoney){
        Inventory.userTotalMoney = userTotalMoney;
    }

    /**
     * Sets the quantity of a specific money denomination in the inventory.
     *
     * @param denomination The denomination of the money.
     * @param quantity     The new quantity of the money denomination.
     */
    public void setMoney(int denomination, int quantity){
        Inventory.money.put(denomination, quantity);
    }

    /**
     * Sets the money denominations and quantities in the inventory.
     *
     * @param money The new money denominations and quantities in the inventory.
     */
    public void setMoney(HashMap<Integer,Integer> money){
        Inventory.money = money;
    }

    /**
     * Sets the quantity of a specific money denomination for the user.
     *
     * @param denomination The denomination of the money.
     * @param quantity     The new quantity of the money denomination for the user.
     */
    public void setUserMoney(int denomination, int quantity){
        Inventory.userMoney.put(denomination, quantity);
    }

    /**
     * Sets the money denominations and quantities for the user.
     *
     * @param money The new money denominations and quantities for the user.
     */
    public void setUserMoney(HashMap<Integer,Integer> money){
        Inventory.userMoney = money;
    }
}
