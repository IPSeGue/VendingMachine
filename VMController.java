import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author o_0
 */
public class VMController {
    private StartView startView;
    private CreateVending createVending;
    private RegularView regularView;
    private SpecialView specialView;
    private MaintenanceView userView;
    
    private VMModel vmModel;
    
    public VMController(StartView startView, CreateVending createVending, RegularView regularView, SpecialView specialView, MaintenanceView userView, VMModel model){
        this.startView = startView;
        this.createVending = createVending;
        this.regularView = regularView;
        this.specialView = specialView;
        this.userView = userView;
        this.vmModel = model;
        
        this.startView.setCreateListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                createVending.confirmButton.setEnabled(false);
                createVending.setVisible(true);
                startView.setVisible(false);
            }
        });
        
        this.startView.setTestListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                boolean vTest = model.check();
                if (vTest){
                    specialView.setSpecialAll(model.getName());
                    specialView.runSpecialThis(model.getSlots());
                    specialView.setVisible(true);
                }
                else if (!vTest){
                    regularView.setRegularAll(model.getName());
                    regularView.runRegularThis(model.getSlots());
                    regularView.setVisible(true);
                }
                startView.setVisible(false);
            }
        });
        
        this.createVending.confirmButton(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
                String text = createVending.getName();
                model.defaultItem(text);
                boolean check;
                if (createVending.jRadioButton1.isSelected()){
                    check = false;
                    model.create(model.getSlots(),model.getInventory(),text, check);
                }
                else if (createVending.jRadioButton2.isSelected()){
                    check = true;
                    model.create(model.getSlots(),model.getInventory(),text, check);
                } 
                startView.test.setEnabled(true);
                startView.create.setEnabled(false);
                startView.setVisible(true); 
                createVending.setVisible(false);
                 
            }
        });
        
        this.createVending.resetButton(new ActionListener(){
            public void actionPerformed(ActionEvent e) { 
                model.resetStartInventory();
                createVending.jLabel3.setText("Total Inventory: " + 0);
                createVending.setDisplay(model.getInventory());
                 
            }
        });
        
        this.createVending.addBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = createVending.getAmount();
                model.addStartInventory(text);
                createVending.jLabel3.setText("Total Inventory: " + model.getTotal());
                createVending.jTextField2.setText("");
                createVending.setDisplay(model.getInventory());

            }
        });   
        
        this.createVending.backBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startView.setVisible(true);
                createVending.setVisible(false);

            }
        });  
        
        this.regularView.findBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textName = regularView.getInputName();
                for (Map.Entry<Item, Integer> entry : model.getSlots().entrySet()) {
                    Item item = entry.getKey();
                    if (item.getName().equalsIgnoreCase(textName)){
                        int quantity = entry.getValue();
                        regularView.displayName.setText("Name: " + item.getName());
                        regularView.displayPrice.setText("Price: " +item.getPrice());
                        regularView.displayCalories.setText("Calories: " + item.getCalories());
                    }
                }
                regularView.continueButton.setEnabled(true);
            }
        });  
        
        this.regularView.continueBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean display = false;
                String text = regularView.getInputName();
                display = model.regularBuy(text, regularView.getSum());
                if (display){
                    regularView.displayReceipt(model.getItemName(), model.getPrice(), model.getCalories(), 1, model.getChange());
                    regularView.updateTextArea(model.getSlots()); 
                }
                regularView.setSum(0);
                regularView.nameInput.setText("");
                regularView.displayName.setText("Name: ");
                regularView.displayPrice.setText("Price: ");
                regularView.displayCalories.setText("Calories: ");
                regularView.insertPrice.setText("Price Inserted: ");
                regularView.continueButton.setEnabled(false);
                
            }
        });  
        
        this.regularView.backRegularMenuBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startView.setVisible(true);
                regularView.setVisible(false);
            }
        }); 
        
        this.regularView.maintenanceViewBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userView.setUserView(model.getName(),false);
                userView.runFirst(model.getSlots());
                userView.checkInventory(model.getInventory());
                userView.setVisible(true);
                regularView.setVisible(false);
            }
        }); 
        
        this.regularView.restItemBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularView.insertPrice.setText("Price Inserted: ");
                regularView.displayName.setText("Name: ");
                regularView.displayPrice.setText("Price: ");
                regularView.displayCalories.setText("Calories: ");
                regularView.setSum(0);
            }
        }); 
        
        
        this.specialView.addItemBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean display = false;
                specialView.jTextArea1.setText("");
                String text = specialView.getOneItemName();
                display = model.addBuyItem(text);
                if (display){
                    specialView.displayPrice.setText("Price: " + model.getValueP());
                    specialView.displayCalories.setText("Calories: " + model.getValueC());
                    specialView.jTextArea2.append("Name: " + model.getName() + "\n");
                    specialView.jTextArea2.append("Price: " + model.getPrice() + "\n");
                    specialView.jTextArea2.append("Calories: " + model.getCalories() + "\n" + "\n");
                }
                
                specialView.nameInput.setText("");
                specialView.continueButton.setEnabled(true);
            }
        });
        
        this.specialView.buyBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean display = false;
                String text = specialView.getOneItemName();
                display = model.sellerBuy(text, specialView.getSpecialSum());
                if (display){
                    specialView.displaySReceipt(model.getListItem(), model.getPrice(), model.getCalories(), model.getCount(), model.getChange());
                    specialView.updateSTextArea(model.getSlots());
                }
                specialView.setSum(0);
                model.setTempSlot();
                model.setTListName();
                specialView.nameInput.setText("");
                specialView.displayPrice.setText("Price: ");
                specialView.displayCalories.setText("Calories: ");
                specialView.insertPrice.setText("Price Inserted: ");
                specialView.jTextArea2.setText("");
                specialView.continueButton.setEnabled(false);
            }
        }); 
        
        this.specialView.backSpecialMenuBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startView.setVisible(true);
                specialView.setVisible(false);
            }
        }); 
        
        this.specialView.maintenanceViewBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userView.setUserView(model.getName(), true);
                userView.runFirst(model.getSlots());
                userView.checkInventory(model.getInventory());
                userView.setVisible(true);
                specialView.setVisible(false);
            }
        }); 
        
        this.specialView.specialResetBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                specialView.insertPrice.setText("Price Inserted: ");
                specialView.displayPrice.setText("Price: ");
                specialView.displayCalories.setText("Calories: ");
                specialView.jTextArea1.setText("");
                specialView.jTextArea2.setText("");
                model.setTempSlot();
                specialView.setSum(0);
                model.setValueP(0);
                model.setValueC(0);
            }
        }); 
        
        this.userView.updateBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n = userView.getNtext();
                String r = userView.getRtext();
                String c = userView.getCtext();
                model.updateInfo(n, r, c);
                userView.updateListItem(model.getSlots());
                userView.nameInput1.setText("");
                userView.restockField.setText("");
                userView.changePriceField.setText("");
            }
        }); 
        
        this.userView.addNewItemBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n = userView.getNewN();
                String p = userView.getNewP();
                String c = userView.getNewC();
                String q = userView.getNewQ();
                model.addNewItem(n, p, c, q);
                userView.updateListItem(model.getSlots());
                userView.newName.setText("");
                userView.newPrice.setText("");
                userView.newCalories.setText("");
                userView.newQuantity.setText("");
            }
        }); 
        
        this.userView.addInventoryBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = userView.getInputNum();
                int num = Integer.parseInt(text);
                int tempM, tempQ = 0, total;
                total = model.getInventory().getTotalMoney();
                HashMap<Integer, Integer> money = model.getInventory().getMoney();
                for (Map.Entry<Integer, Integer> entry : money.entrySet()) {
                    tempM = entry.getKey();
                    tempQ = entry.getValue();

                    if (userView.RadioB1.isSelected() && !(text.equals("") && tempM == 1)){
                        tempQ += num;
                        money.put(1, tempQ);
                        total +=  1 * num;
                    }
                    else if (userView.RadioB5.isSelected() && !(text.equals("") && tempM == 5)){
                        tempQ += num;
                        money.put(5, tempQ);
                        total +=  5 * num;
                    }
                    else if (userView.RadioB10.isSelected() && !(text.equals("") && tempM == 10)){
                        tempQ += num;
                        money.put(10, tempQ);
                        total +=  10 * num;
                    }
                    else if (userView.RadioB20.isSelected() && !(text.equals("") && tempM == 20)){
                        tempQ += num;
                        money.put(20, tempQ);
                        total +=  20 * num;
                    }
                    else if (userView.RadioB50.isSelected() && !(text.equals("") && tempM == 50)){
                        tempQ += num;
                        money.put(50, tempQ);
                        total +=  50 * num;
                    }
                    else if (userView.RadioB100.isSelected() && !(text.equals("") && tempM == 100)){
                        tempQ += num;
                        money.put(100, tempQ);
                        total +=  100 * num;
                    }
                    else if (userView.RadioB200.isSelected() && !(text.equals("") && tempM == 200)){
                        tempQ += num;
                        money.put(200, tempQ);
                        total +=  200 * num;
                    }
                    else if (userView.RadioB500.isSelected() && !(text.equals("") && tempM == 500)){
                        tempQ += num;
                        money.put(500, tempQ);
                        total +=  500 * num;
                    }
                    else if (userView.RadioB1000.isSelected() && !(text.equals("") && tempM == 1000)){
                        tempQ += num;
                        money.put(1000, tempQ);
                        total +=  1000 * num;
                    }

                }
                HashMap<Integer, Integer> userMoney = model.getInventory().getUserMoney();
                Inventory newInventory = new Inventory(0,total,money,userMoney);

                model.setInventory(newInventory);
                
                userView.inputNum.setText("");
                userView.checkInventory(model.getInventory());
            }
        }); 
        
        this.userView.collectBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int payment = 0;
                userView.receipt.setText("");
                userView.receipt.append("Collecting Payment: \n");

                for (Transaction transaction : model.getSales()) {
                    String itemName = transaction.getName();
                    int price = transaction.getPrice();
                    int quantity = transaction.getQuantity();
                    int totalAmount = price * quantity;
                    payment += totalAmount;
                }
                userView.receipt.append("Total payment collected: " + payment + " Peso\n");
            }
        }); 
        
        this.userView.summaryBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userView.receipt.setText("");
                userView.receipt.append("Transaction Summary: \n");

                for (Transaction transaction : model.getSales()) {
                    String itemName = transaction.getName();
                    int price = transaction.getPrice();
                    int quantity = transaction.getQuantity();
                    int totalAmount = price * quantity;

                    userView.receipt.append("Item: " + itemName + "\n");
                    userView.receipt.append("Price: " + price + "\n");
                    userView.receipt.append("Quantity: " + quantity + "\n");
                    userView.receipt.append("Total Amount: " + totalAmount + "\n");
                    userView.receipt.append("=========================\n");
                }
            }
        }); 
        
        this.userView.removeBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n = userView.getNtext();
                model.removeItem(n);
                userView.updateListItem(model.getSlots());
            }
        }); 
        
        this.userView.backVendingBtnListerner(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean vTest = userView.getVending();
                if (vTest){
                    specialView.setSpecialAll(model.getName());
                    specialView.runSpecialThis(model.getSlots());
                    specialView.setVisible(true);
                }
                else if (!vTest){
                    regularView.setRegularAll(model.getName());
                    regularView.runRegularThis(model.getSlots());
                    regularView.setVisible(true);
                }
                userView.setVisible(false);
            }
        }); 
        
    }
    
    
    public static void main(String [] args){
        StartView startView = new StartView();
        CreateVending createVending = new CreateVending();
        RegularView rview = new RegularView();
        SpecialView sview = new SpecialView();
        MaintenanceView userView = new MaintenanceView();
        VMModel model = new VMModel();
        
        VMController controller = new VMController(startView, createVending,rview, sview, userView, model);
        startView.setVisible(true);
    }
}
