public class ItemSlot{
    private int quantity;
    private Item item;
    

    public ItemSlot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
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
