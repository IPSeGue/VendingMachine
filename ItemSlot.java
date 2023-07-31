/**
 * The ItemSlot class represents a slot in a store inventory that holds an item and its quantity.
 */
public class ItemSlot{
    private int slotNumber = 0;
    private Item item;
    private int quantity;
    
    /**
     * Constructs an ItemSlot object with the specified slot number, item, and quantity.
     *
     * @param slotNumber The slot number of the item slot.
     * @param item       The item held in the item slot.
     * @param quantity   The quantity of the item in the item slot.
     */
    public ItemSlot(int slotNumber, Item item, int quantity) {
        this.slotNumber = 1;
        this.item = item;
        this.quantity = quantity;
    }
    
    /**
     * Returns the slot number of the item slot.
     *
     * @return The slot number of the item slot.
     */
    public int getSlotNumber(){
        return slotNumber;
    }
    
    /**
     * Returns the item held in the item slot.
     *
     * @return The item held in the item slot.
     */
    public Item getItem(){
        return item;
    }

    /**
     * Returns the quantity of the item in the item slot.
     *
     * @return The quantity of the item in the item slot.
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Sets the quantity of the item in the item slot.
     *
     * @param quantity The new quantity of the item in the item slot.
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Sets the item held in the item slot.
     *
     * @param item The new item held in the item slot.
     */
    public void setItem(Item item){
        this.item = item;
    }
}
