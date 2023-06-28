import java.util.*;

public class Main{
    public static void main(String[] args){
        HashMap<Item, Integer> slot = new HashMap<>();
        int num = 0;
        Scanner sc = new Scanner(System.in);

        VendingMachine vendingMachine = new VendingMachine();
        int choice = 0;
        boolean created = false;

        while(choice != 3){
            System.out.println("Welcome to the Vending Machine System!");
            System.out.println("Please Choose an option: ");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test Vending Machine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    if (created){
                        System.out.println("Vending Machine has been created!");
                        break;
                    }
                    // Name, price, calories
                    Item Water = new Item("Water", 21, 10);
                    Item Coke = new Item("Coke", 99, 10);
                    Item Chocolate = new Item("Chocolate", 198, 10);
                    Item Coffee = new Item("Coffee", 57, 10);
                    Item Tea = new Item("Tea", 226, 10);
                    Item IcedTea = new Item("IcedTea", 555, 10);
                    Item Milk = new Item("Milk", 1374, 10);
                    Item Wine = new Item("Wine", 23, 10);
                    Item Soda = new Item("Soda", 72, 10);
                    Item Juice = new Item("Juice", 90, 10);
                    
                    System.out.print("Please input the Quantity of all products: ");
                    while ((num = sc.nextInt()) < 10){
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                    sc.nextLine();
                    
                    // Name, Quantity
                    slot.put(Water,num);
                    slot.put(Coke,num);
                    slot.put(Chocolate,num);
                    slot.put(Coffee,num);
                    slot.put(Tea,num);
                    slot.put(IcedTea,num);
                    slot.put(Milk,num);
                    slot.put(Wine,num);
                    slot.put(Soda,num);
                    slot.put(Juice,num);
                    
                    vendingMachine.create(slot);
                    System.out.println("Vending Machine Stocked!");
                    System.out.println("========================");
                    created = true;
                    break;
                    
                case 2:
                    if (created) {
                        vendingMachine.test();
                    }
                    else{
                        System.out.println("A Vending Machine has not been created yet. Please create one before choosing this option.");
                        System.out.println("========================");
                    }
                    break;

                case 3:
                    System.out.print("\nExiting Program");
                    break;
                
            }
        }
    }
}