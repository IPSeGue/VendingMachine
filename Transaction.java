/**
 * The Transaction class represents a transaction made for a specific item.
 */
public class Transaction{
    private String name;
    private int itemPrice;
    private int quantity;

    /**
     * Constructs a Transaction object with the specified item name, item price, and quantity.
     *
     * @param name      The name of the item involved in the transaction.
     * @param itemPrice The price of the item in the transaction.
     * @param quantity  The quantity of the item in the transaction.
     */
    public Transaction(String name, int itemPrice, int quantity){
        this.name = name;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the item involved in the transaction.
     *
     * @return The name of the item involved in the transaction.
     */
    public String getName(){
        return name;
    }

     /**
     * Returns the price of the item in the transaction.
     *
     * @return The price of the item in the transaction.
     */
    public int getPrice(){
        return itemPrice;
    }

    /**
     * Returns the quantity of the item in the transaction.
     *
     * @return The quantity of the item in the transaction.
     */
    public int getQuantity(){
        return quantity;
    }
}