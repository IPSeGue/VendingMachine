import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RegularVendingMachine {
    private HashMap<Integer, ItemSlot> itemSlots;
    private HashMap<Integer, Integer> denominations;
    private int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    private List<Transaction> transactions;
    private Scanner scanner;

    public RegularVendingMachine(HashMap<Integer, ItemSlot> itemSlots) {
        this.itemSlots = itemSlots;
        denominations = new HashMap<>();
        transactions = new ArrayList<>();
        initializeDenominations();
        scanner = new Scanner(System.in);
    }

    public void initializeDenominations() {
        for (int denomination : DENOMINATIONS) {
            denominations.put(denomination, 0);
        }
    }

    public void addItem(Item item, int slotNumber, int quantity) {
        ItemSlot itemSlot = itemSlots.get(slotNumber);
        if (itemSlot != null) {
            itemSlot.setItem(item);
            itemSlot.setQuantity(quantity);
        }
    }

    public void removeItem(int slotNumber) {
        ItemSlot itemSlot = itemSlots.get(slotNumber);
        if (itemSlot != null) {
            itemSlot.setItem(null);
            itemSlot.setQuantity(0);
        }
    }

    public ItemSlot getItemSlot(int slotNumber) {
        return itemSlots.get(slotNumber);
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        for (Map.Entry<Integer, ItemSlot> entry : itemSlots.entrySet()) {
            int slotNumber = entry.getKey();
            ItemSlot itemSlot = entry.getValue();
            Item item = itemSlot.getItem();
            if (item != null) {
                System.out.println(slotNumber + ": " + item.getName() + " - Price: " + item.getPrice());
            } else {
                System.out.println(slotNumber + ": Empty");
            }
        }
    }

    public void updateQuantitySold(Item item, int quantity) {
        for (Transaction transaction : transactions) {
            transaction.updateQuantitySold(item, quantity);
        }
    }

    public void updateTotalAmountCollected(int amount) {
        for (Transaction transaction : transactions) {
            transaction.updateTotalAmountCollected(amount);
        }
    }

    public void replenishMoney() {
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            int denomination = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Enter the quantity of " + denomination + " denomination:");
            int newQuantity = Integer.parseInt(scanner.nextLine());
            denominations.put(denomination, quantity + newQuantity);
        }
        System.out.println("Money replenished successfully.");
    }

    public void printSummary() {
        System.out.println("Transaction Summary:");
        for (Transaction transaction : transactions) {
            transaction.printSummary();
        }
    }

    public void maintenance() {
        int choice = 0;
        boolean found = false;

        while (choice != 6) {
            System.out.println("1: Restocking");
            System.out.println("2: Change Price");
            System.out.println("3: Collecting Payment");
            System.out.println("4: Replenishing Money");
            System.out.println("5: Printing Summary of the transactions");
            System.out.println("6: Exit");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayAvailableItems();
                    System.out.println("Enter the Slot Number");
                    int slotNumber = Integer.parseInt(scanner.nextLine());
                    ItemSlot itemSlot = getItemSlot(slotNumber);
                    if (itemSlot != null) {
                        System.out.println("What quantity do you want to apply to " + itemSlot.getItem().getName());
                        int quantity = Integer.parseInt(scanner.nextLine());
                        itemSlot.setQuantity(quantity);
                        found = true;
                    } else {
                        System.out.println("Invalid Slot Number");
                    }
                    break;
                case 2:
                    displayAvailableItems();
                    System.out.println("Enter the Slot Number");
                    slotNumber = Integer.parseInt(scanner.nextLine());
                    itemSlot = getItemSlot(slotNumber);
                    if (itemSlot != null) {
                        System.out.println("Enter the new price for " + itemSlot.getItem().getName());
                        int newPrice = Integer.parseInt(scanner.nextLine());
                        itemSlot.getItem().setPrice(newPrice);
                        found = true;
                    } else {
                        System.out.println("Invalid Slot Number");
                    }
                    break;
                case 3:
                    System.out.println("Collecting payment");
                    break;
                case 4:
                    replenishMoney();
                    break;
                case 5:
                    printSummary();
                    break;
                case 6:
                    System.out.println("Exiting maintenance mode");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (found) {
                System.out.println("Success");
            }
        }
    }
}