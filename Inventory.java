import java.util.HashMap;


public class Inventory{
    private static int totalMoney = 0;
    private static int userTotalMoney = 0;
    private static HashMap<Integer,Integer> money;
    private static HashMap<Integer,Integer> userMoney;
    
    public Inventory(int totalMoney, int userTotalMoney, HashMap<Integer,Integer> money, HashMap<Integer,Integer> userMoney){
        Inventory.totalMoney = totalMoney;
        Inventory.userTotalMoney = userTotalMoney;
        Inventory.money = money;
        Inventory.userMoney = userMoney;
    }

    public int getTotalMoney(){
        return totalMoney;
    }

    public int getUserTotalMoney(){
        return userTotalMoney;
    }

    public HashMap<Integer,Integer> getMoney(){
        return money;
    }

    public HashMap<Integer,Integer> getUserMoney(){
        return userMoney;
    }

    public void setTotalMoney(int totalMoney){
        Inventory.totalMoney = totalMoney;
    }

    public void setUserTotalMoney(int userTotalMoney){
        Inventory.userTotalMoney = userTotalMoney;
    }


    public void setMoney(int denomination, int quantity){
        Inventory.money.put(denomination, quantity);
    }

    public void setUserMoney(int denomination, int quantity){
        Inventory.userMoney.put(denomination, quantity);
    }
}