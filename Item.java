/**
 * The Item class represents an item in a store inventory.
 */
public class Item{
    private String name;
    private int price;
    private int calories;
    private int quantity;

    /**
     * Constructs an Item object with the specified name, price, and calories.
     *
     * @param name     The name of the item.
     * @param price    The price of the item.
     * @param calories The number of calories of the item.
     */
    public Item(String name, int price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
    
    public void setEmpty() {
        this.name = "";
        this.price = 0;
        this.calories = 0;
    }
    
    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the number of calories of the item.
     *
     * @return The number of calories of the item.
     */
    public int getCalories() {
        return calories;
    }
    
    public int getQuantity() { // Add getter for quantity
        return quantity;
    }

    public void setQuantity(int quantity) { // Add setter for quantity
        this.quantity = quantity;
    }
    
    /**
     * Sets the price of the item.
     *
     * @param price The new price of the item.
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return name + " - Price: $" + price + " - Quantity: ";
    }

}
