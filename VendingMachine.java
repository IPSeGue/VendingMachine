import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class VendingMachine{
    private RegularVendingMachine RegularVendingMachine;
    private SpecialVendingMachine SpecialVendingMachine;
    private HashMap<Integer, Integer>    money = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> userMoney = new HashMap<Integer, Integer>();
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    public void create(HashMap<Item,Integer> slots){
        RegularVendingMachine regular = new RegularVendingMachine(slots);
        this.RegularVendingMachine = regular;
    }
    public void test(){
        RegularVendingMachine.displayAvailableItems();
    }
    
    
    
    
    
    
    
    
    /* public void addItemSlot(Integer slotNumber, ItemSlot itemSlot){
        itemSlots.put(slotNumber, itemSlot);
    }

    public void removeItemSlot(Integer slotNumber) {
        itemSlots.remove(slotNumber);
    } */
}