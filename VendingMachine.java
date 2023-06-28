import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class VendingMachine{
    private RegularVendingMachine RegularVendingMachine;
    private SpecialVendingMachine SpecialVendingMachine;
    private Inventory inventory;
    private HashMap<Integer, Integer> money = new HashMap<>();
    private HashMap<Integer, Integer> userMoney = new HashMap<>();
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    Scanner sc = new Scanner(System.in);

    public void create(HashMap<Item,Integer> slots){
        int num, total = 0, choice = 0;
        
        while(choice != 1 && choice != 2){
            System.out.println();
            System.out.println("Create inventroy");
            System.out.println("1: Default");
            System.out.println("2: Input the inventory");
            System.out.print("Enter the number: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    for(int denomination : DENOMINATIONS){ 
                        money.put(denomination, 0);
                        userMoney.put(denomination,0);
                        total += money.get(denomination) * denomination; 
                    }
                    break;
                case 2:
                    for(int denomination : DENOMINATIONS){ 
                        System.out.println(denomination + " PESO - How many you want to add ");
                        num = Integer.parseInt(sc.nextLine());
                        money.put(denomination, num);
                        userMoney.put(denomination,0);
                        total += money.get(denomination) * denomination; 
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        
        System.out.println("Inserted Total Amount is " + total);
        inventory = new Inventory(total, 0, money, userMoney);
        RegularVendingMachine regular = new RegularVendingMachine(slots, inventory);
        this.RegularVendingMachine = regular;
    }
    public void test(){
        int choice = 0;
        while(choice !=3){
            System.out.println();
            System.out.println("1: Testing Features");
            System.out.println("2: Maintenance features");
            System.out.println("3: Exit");
            System.out.print("Enter the number: ");
            choice = Integer.parseInt(sc.nextLine());
        
            switch(choice){
                case 1:
                    boolean i = true;
                    int money;
                    String name, select;

                    System.out.println("\nWelcome to Test Feature");
                    RegularVendingMachine.displayAvailableItems();
                    RegularVendingMachine.insertMoney();
                    System.out.println();
                    RegularVendingMachine.displayAvailableItems();
                    money = inventory.getUserTotalMoney();
                    System.out.println("You insertd " + money);
                    System.out.print("What item name (input): ");
                    name = sc.nextLine();
                    i = RegularVendingMachine.selectingItems(name);
                    while (!i){
                        System.out.println("What to continue?[Y/N]");
                        select = sc.nextLine();
                        if (select.equalsIgnoreCase("y")) {
                            RegularVendingMachine.displayAvailableItems();
                            System.out.println("You insertd " + money);
                            System.out.print("What item name (input): ");
                            name = sc.nextLine();
                            i = RegularVendingMachine.selectingItems(name);
                        }
                        else if (select.equalsIgnoreCase("n")){
                            i = false;
                            inventory.setUserTotalMoney(0);
                        }
                    }
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