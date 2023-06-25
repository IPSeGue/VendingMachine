public class ItemSlot{
    private int slotNumber;
    private Item item;

    public ItemSlot(int slotNumber, Item item){
        this.slotNumber = slotNumber;
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }
}