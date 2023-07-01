import java.util.HashMap;
import java.util.Scanner;

/**
 * The VendingMachine class represents a vending machine that can be created and tested.
 * It manages the inventory, denominations, and allows users to interact with the machine.
 */
public class VendingMachine{
    private RegularVendingMachine RegularVendingMachine;
    private Inventory inventory;
    private HashMap<Integer, Integer> money = new HashMap<>();
    private HashMap<Integer, Integer> userMoney = new HashMap<>();
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    Scanner sc = new Scanner(System.in);

    /**
     * Creates a vending machine with the specified slots and denominations.
     *
     * @param slots the slots representing the items and their quantities in the machine
     */
    public void create(HashMap<Item,Integer> slots){
        int num, total = 0, choice = 0;
        
        while(choice != 1 && choice != 2){
            System.out.println("================================================================");
            System.out.println("Vending Machine: Denominations");
            System.out.println("Please input the action for the Vending Machine's denominations:");
            System.out.println("1: Default - no denominations will be stored in this machine.");
            System.out.println("2: Population of Denomination Inventory");
            System.out.print("Enter the action to be taken: ");
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
                        System.out.print(denomination + " PESO - Please input quantity of bills/coins in the machine: ");
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

    /**
     * Tests the features of the vending machine or performs maintenance actions.
     */
    public void test(){
        int choice = 0;
        while(choice !=3){
            System.out.println("=======================================");
            System.out.println("Vending Machine Testing and Maintenance");
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

                    System.out.println("\nWelcome to Test Features! Simulating Vending Machine now...");
                    RegularVendingMachine.displayAvailableItems();
                    RegularVendingMachine.insertMoney();
                    System.out.println();
                    RegularVendingMachine.displayAvailableItems();
                    money = inventory.getUserTotalMoney();
                    System.out.println("Amount inserted: " + money);
                    System.out.print("What will you order?: ");
                    name = sc.nextLine();
                    i = RegularVendingMachine.selectingItems(name);
                    while (!i){
                        System.out.println("Continue or Cancel Transaction?[Y/N]");
                        select = sc.nextLine();
                        if (select.equals("y") || select.equals("Y")) {
                            RegularVendingMachine.displayAvailableItems();
                            System.out.println("Amount Inserted: " + money);
                            System.out.print("What will you order?: ");
                            name = sc.nextLine();
                            i = RegularVendingMachine.selectingItems(name);
                        }
                        else if (select.equalsIgnoreCase("n")){
                            i = true;
                            inventory.setUserTotalMoney(0);
                        }
                    }
                    break;
                case 2: 
                    System.out.println("\nWelcome to Vending Machine Maintenance!");
                    RegularVendingMachine.maintenance();
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }
        
    }
}