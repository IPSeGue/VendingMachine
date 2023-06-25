public class Item{
    private String name;
    private int price;
    private int quantity;
    private int calories;

    public Item(String name, int price, int quantity, int calories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.calories = calories;
    }   

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCalories() {
        return name;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
    }

}