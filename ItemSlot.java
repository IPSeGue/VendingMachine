public class ItemSlot{
    private int slotNumber;
    private Item item;
    private int quantity;
    

    public ItemSlot(int slotNumber, Item item, int quantity) {
        this.slotNumber = slotNumber;
        this.item = item;
        this.quantity = quantity;
    }
    
    public int getSlotNumber(){
        return slotNumber;
    }
    
    public Item getItem(){
        return item;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setItem(Item item){
        this.item = item;
    }
}