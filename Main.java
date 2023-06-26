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
            System.out.println("Choose an option: ");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test Vending Machine");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    if (created){
                        System.out.println("You have created your own vending machine");
                        break;
                    }
                    // Name, price, calories
                    Item Water = new Item("Water", 21, 10);
                    Item Coke = new Item("Coke", 99, 10);
                    Item Chocolate = new Item("Chocolate", 198, 10);
                    Item Coffe = new Item("Coffe", 57, 10);
                    Item Tea = new Item("Tea", 226, 10);
                    Item IcedTea = new Item("IcedTea", 555, 10);
                    Item Milk = new Item("Milk", 1374, 10);
                    Item Wine = new Item("Wine", 23, 10);
                    Item Soda = new Item("Soda", 72, 10);
                    Item Juice = new Item("Juice", 90, 10);
                    
                    System.out.println("How many quantities are you want for all");
                    while ((num = sc.nextInt()) < 10){
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    sc.nextLine();
                    
                    // Name, Quantity
                    slot.put(Water,num);
                    slot.put(Coke,num);
                    slot.put(Chocolate,num);
                    slot.put(Coffe,num);
                    slot.put(Tea,num);
                    slot.put(IcedTea,num);
                    slot.put(Milk,num);
                    slot.put(Wine,num);
                    slot.put(Soda,num);
                    slot.put(Juice,num);
                    
                    vendingMachine.create(slot);
                    System.out.println("Successfully created");
                    created = true;
                    break;
                    
                case 2:
                    if (created) {
                        vendingMachine.test();
                    }
                    break;

                case 3:
                    System.out.print("\nExiting Program");
                    break;
                
            }
        }
    }
}