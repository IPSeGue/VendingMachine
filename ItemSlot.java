public class ItemSlot {
    private Integer slotNumber;
    private Item item;

    public ItemSlot(Integer slotNumber) {
        this.slotNumber = slotNumber;
        this.item = null;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
