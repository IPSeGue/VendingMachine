public class Transaction{
    private String name;
    private int itemprice;
    private int quantity;

    public Transaction(String name, int itemprice, int quantity){
        this.name = name;
        this.itemprice = itemprice;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return itemprice;
    }

    public int getQuantity(){
        return quantity;
    }
}