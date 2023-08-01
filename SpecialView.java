import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Represents the Special View of the Vending Machine.
 * This class extends javax.swing.JFrame and provides the UI for special vending machine operations.
 */
public class SpecialView extends javax.swing.JFrame {
    private int num;
    private int sum;
    private String vmName;
    
    private int quantity;

    /**
     * Constructor for the SpecialView class.
     * Initializes the components for the Special view of the vending machine.
     */
    public SpecialView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        nameInput = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        speciallistItem = new javax.swing.JTextArea();
        displayName1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        displayPrice = new javax.swing.JLabel();
        displayCalories = new javax.swing.JLabel();
        insertPrice = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        button1Peso = new javax.swing.JButton();
        button10Peso = new javax.swing.JButton();
        button5Peso = new javax.swing.JButton();
        button20Peso = new javax.swing.JButton();
        button50Peso = new javax.swing.JButton();
        button100Peso = new javax.swing.JButton();
        button200Peso = new javax.swing.JButton();
        button500Peso = new javax.swing.JButton();
        restButton = new javax.swing.JButton();
        button1000Peso = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Welcome to ");

        jLabel2.setText("Special Vending Machine");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        submitButton.setText("Submit");

        nameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInputActionPerformed(evt);
            }
        });

        speciallistItem.setColumns(20);
        speciallistItem.setRows(5);
        jScrollPane3.setViewportView(speciallistItem);

        displayName1.setText("Name:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(displayName1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submitButton))
                    .addComponent(jScrollPane3))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayName1))
                .addContainerGap())
        );

        displayPrice.setText("Price:");

        displayCalories.setText("Calories:");

        insertPrice.setText("Price Inserted: ");

        button1Peso.setText("1");
        button1Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1PesojButton1Peso(evt);
            }
        });

        button10Peso.setText("10");
        button10Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10PesojButton10Peso(evt);
            }
        });

        button5Peso.setText("5");
        button5Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5PesojButton5Peso(evt);
            }
        });

        button20Peso.setText("20");
        button20Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button20PesoPeso(evt);
            }
        });

        button50Peso.setText("50");
        button50Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button50PesojButton50Peso(evt);
            }
        });

        button100Peso.setText("100");
        button100Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button100PesojButton100Peso(evt);
            }
        });

        button200Peso.setText("200");
        button200Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button200PesojButton200Peso(evt);
            }
        });

        button500Peso.setText("500");
        button500Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button500PesojButton500Peso(evt);
            }
        });

        restButton.setText("Rest");

        button1000Peso.setText("1000");
        button1000Peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1000PesojButton1000Peso(evt);
            }
        });

        continueButton.setText("Continue");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button1Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button5Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button10Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button20Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button50Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button100Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button200Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button500Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1000Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(restButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(continueButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1Peso)
                    .addComponent(button10Peso)
                    .addComponent(button5Peso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button20Peso)
                    .addComponent(button50Peso)
                    .addComponent(button100Peso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button200Peso)
                    .addComponent(button500Peso)
                    .addComponent(button1000Peso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restButton)
                    .addComponent(continueButton))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayCalories, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(displayPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayCalories, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Exit");

        jButton1.setText("Settings");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameInputActionPerformed

     /**
     * Handles the action when the 1 Peso button is clicked.
     * Adds 1 to 1000 Peso to the current sum and updates the insertPrice label.
     *
     * @param evt The action event triggered by clicking the 1 to 1000Peso button.
     */
    private void button1PesojButton1Peso(java.awt.event.ActionEvent evt) {
        num = 1;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button10PesojButton10Peso(java.awt.event.ActionEvent evt) {
        num = 10;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button5PesojButton5Peso(java.awt.event.ActionEvent evt) {
        num = 5;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button20PesoPeso(java.awt.event.ActionEvent evt) {
        num = 20;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button50PesojButton50Peso(java.awt.event.ActionEvent evt) {
        num = 50;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button100PesojButton100Peso(java.awt.event.ActionEvent evt) {
        num = 100;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button200PesojButton200Peso(java.awt.event.ActionEvent evt) {
        num = 200;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button500PesojButton500Peso(java.awt.event.ActionEvent evt) {
        num = 500;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }

    private void button1000PesojButton1000Peso(java.awt.event.ActionEvent evt) {
        num = 1000;
        sum += num;
        insertPrice.setText("Price Inserted: " + sum);
    }
    
    /**
     * ActionListener for the Buy button in the Special View.
     *
     * @param act The ActionListener to be set for the Buy button.
     */
    public void buyBtnListerner(ActionListener act){
        this.continueButton.addActionListener(act);
    }
    
    /**
     * ActionListener for the Add Item button in the Special View.
     *
     * @param act The ActionListener to be set for the Add Item button.
     */
    public void addItemBtnListerner(ActionListener act){
        this.submitButton.addActionListener(act);
    }
    
    /**
     * ActionListener for the Back button in the Special View to go back to the Special Menu.
     *
     * @param act The ActionListener to be set for the Back button.
     */
    public void backSpecialMenuBtnListerner(ActionListener act){
        this.jButton2.addActionListener(act);
    }
    
    /**
     * ActionListener for the Maintenance View button in the Special View.
     *
     * @param act The ActionListener to be set for the Maintenance View button.
     */
    public void maintenanceViewBtnListerner(ActionListener act){
        this.jButton1.addActionListener(act);
    }
    
    /**
     * ActionListener for the Special Reset button in the Special View.
     *
     * @param act The ActionListener to be set for the Special Reset button.
     */
    public void specialResetBtnListerner(ActionListener act){
        this.restButton.addActionListener(act);
    }
    
    /**
     * Updates the speciallistItem JTextArea with the provided vending machine inventory.
     *
     * @param slot The HashMap containing the vending machine inventory with items and their quantities.
     */
    public void updateSTextArea(HashMap<Item, Integer> slot){
        
        speciallistItem.setText("");
        for (Map.Entry<Item, Integer> entry : slot.entrySet()) {
            Item item = entry.getKey();
            quantity = entry.getValue();

            // Append the item information to the JTextArea       
            speciallistItem.append("Name: " + item.getName() + "\n");
            speciallistItem.append("Price: " + item.getPrice() + "\n");
            speciallistItem.append("Calories: " + item.getCalories() + "\n");
            speciallistItem.append("Quantity: " + quantity + "\n");
            speciallistItem.append("\n");
        }
    }
    
    /**
     * Displays the purchase receipt with the provided information.
     *
     * @param list     The list of names of purchased items.
     * @param price    The total price of the purchased items.
     * @param calories The total calories of the purchased items.
     * @param quantity The total quantity of the purchased items.
     * @param change   The change given to the customer.
     */
    public void displaySReceipt(ArrayList<String> list, int price, int calories, int quantity, int change){
        String tempN;
        jTextArea1.setText("");
        
        jTextArea1.append("----------RECEIPT----------\n");
        jTextArea1.append("Name: ");
        for (int i = 0; i < list.size(); i++){
            tempN = list.get(i);
            jTextArea1.append(tempN + ", ");
        }
        jTextArea1.append("\b");
        jTextArea1.append("\n");
        jTextArea1.append("Total Price: " + price + "\n");
        jTextArea1.append("Total Calories: " + calories + "\n");
        jTextArea1.append("Total Quantity: " + quantity + "\n");
        jTextArea1.append("Change: " + change + "\n");
        jTextArea1.append("-------------------------------\n");
        jTextArea1.append("Purchase Successful");
        jTextArea1.append("\n");
    }
    
    /**
     * Sets up the Special View of the vending machine with the provided inventory.
     *
     * @param slot The HashMap containing the vending machine inventory with items and their quantities.
     */
    public void runSpecialThis(HashMap<Item, Integer> slot){
        String welcome = "Welcome to " + this.vmName;
        jLabel1.setText(welcome);
        continueButton.setEnabled(false);
        updateSTextArea(slot);
    }

    /**
     * Sets the name of the vending machine for the Special View.
     *
     * @param name The name of the vending machine.
     */
    public void setSpecialAll(String name){
        this.vmName = name;
    }
    
    /**
     * Gets the name of the selected item in the Special View.
     *
     * @return The name of the selected item.
     */
    public String getOneItemName(){
        return nameInput.getText();
    }
    
    /**
     * Gets the sum of money inserted by the user in the Special View.
     *
     * @return The total sum of money inserted.
     */
    public int getSpecialSum(){
        return this.sum;
    }
    
    /**
     * Sets the sum of money inserted by the user in the Special View.
     *
     * @param num The total sum of money inserted.
     */
    public void setSum(int num){
        this.sum = num;
    }

    private javax.swing.JButton button1000Peso;
    private javax.swing.JButton button100Peso;
    public javax.swing.JButton button10Peso;
    public javax.swing.JButton button1Peso;
    private javax.swing.JButton button200Peso;
    public javax.swing.JButton button20Peso;
    private javax.swing.JButton button500Peso;
    public javax.swing.JButton button50Peso;
    public javax.swing.JButton button5Peso;
    public javax.swing.JButton continueButton;
    public javax.swing.JLabel displayCalories;
    public javax.swing.JLabel displayName1;
    public javax.swing.JLabel displayPrice;
    public javax.swing.JLabel insertPrice;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
    public javax.swing.JTextField nameInput;
    public javax.swing.JButton restButton;
    public javax.swing.JTextArea speciallistItem;
    public javax.swing.JButton submitButton;
}
