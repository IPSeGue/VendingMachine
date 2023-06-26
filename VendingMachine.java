import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class VendingMachine{
    private RegularVendingMachine RegularVendingMachine;
    private SpecialVendingMachine SpecialVendingMachine;
    private HashMap<Integer, Integer>    money = new HashMap<Integer, Integer>();
    private HashMap<Integer, Integer> userMoney = new HashMap<Integer, Integer>();
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    Scanner sc = new Scanner(System.in);

    public void create(HashMap<Item,Integer> slots){
        RegularVendingMachine regular = new RegularVendingMachine(slots);
        this.RegularVendingMachine = regular;
    }
    public void test(){
        int choice = 0;
        while(choice !=3){
            System.out.println("1: Testing Features");
            System.out.println("2: Maintenance features");
            System.out.println("3: Exit");
            choice = Integer.parseInt(sc.nextLine());
        
            switch(choice){
                case 1:
                    System.out.println("\nWelcome to Test Feature");
                    RegularVendingMachine.displayAvailableItems();
                    //.....
                    break;
                case 2: 
                    System.out.println("\nWelcome to Maintenance");
                    RegularVendingMachine.maintenance();
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }
        
    }
    
    
    
    
    
    
    
    
    /* public void addItemSlot(Integer slotNumber, ItemSlot itemSlot){
        itemSlots.put(slotNumber, itemSlot);
    }

    public void removeItemSlot(Integer slotNumber) {
        itemSlots.remove(slotNumber);
    } */
}