import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * The MaintenanceView class represents the graphical user interface for the maintenance view of the vending machine.
 * It allows users to perform various maintenance operations on the vending machine, such as updating items, adding new items,
 * adding inventory, collecting money, viewing inventory summary, and removing items.
 *
 * This class extends the javax.swing.JFrame class to provide the graphical interface for the maintenance view.
 */
public class MaintenanceView extends javax.swing.JFrame {
    private String vmName;
    private HashMap<Integer, Integer> temp;
    private static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    
    private boolean vending;
    
    /**
     * Constructs a new MaintenanceView object.
     * Initializes the graphical components by calling the initComponents() method.
     * Initializes the temporary storage for vending machine money using a HashMap.
     */
    public MaintenanceView() {
        initComponents();
        temp = new HashMap<>();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nameInput1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listItem = new javax.swing.JTextArea();
        displayName1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        restockField = new javax.swing.JTextField();
        changePriceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        RadioB1 = new javax.swing.JRadioButton();
        RadioB5 = new javax.swing.JRadioButton();
        RadioB10 = new javax.swing.JRadioButton();
        RadioB20 = new javax.swing.JRadioButton();
        RadioB50 = new javax.swing.JRadioButton();
        RadioB100 = new javax.swing.JRadioButton();
        RadioB200 = new javax.swing.JRadioButton();
        RadioB500 = new javax.swing.JRadioButton();
        RadioB1000 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        inputNum = new javax.swing.JTextField();
        addInventory = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        newName = new javax.swing.JTextField();
        newPrice = new javax.swing.JTextField();
        newCalories = new javax.swing.JTextField();
        newQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        addNewItem = new javax.swing.JButton();
        collect = new javax.swing.JButton();
        summary = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Maintenance of the Vending Machine");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nameInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameInput1ActionPerformed(evt);
            }
        });

        listItem.setColumns(20);
        listItem.setRows(5);
        jScrollPane3.setViewportView(listItem);

        displayName1.setText("Name:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(displayName1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayName1))
                .addContainerGap())
        );

        jLabel2.setText("Restocking (integer): ");

        jLabel3.setText("Change Price (integer): ");

        jLabel5.setText("Replenishing Money: ");

        restockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restockFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Total Inventory:");

        buttonGroup1.add(RadioB1);
        RadioB1.setText("1 Peso");
        RadioB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB5);
        RadioB5.setText("5 Peso");
        RadioB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB10);
        RadioB10.setText("10 Peso");
        RadioB10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB10ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB20);
        RadioB20.setText("20 Peso");
        RadioB20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB20ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB50);
        RadioB50.setText("50 Peso");
        RadioB50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB50ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB100);
        RadioB100.setText("100 Peso");
        RadioB100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB100ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB200);
        RadioB200.setText("200 Peso");
        RadioB200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB200ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB500);
        RadioB500.setText("500 Peso");
        RadioB500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB500ActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioB1000);
        RadioB1000.setText("1000 Peso");
        RadioB1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioB1000ActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantity");

        inputNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNumActionPerformed(evt);
            }
        });

        addInventory.setText("Add in");

        jLabel6.setText("Add New Item:");

        jLabel12.setText("Name:");

        jLabel13.setText("Price:");

        jLabel14.setText("Calories: ");

        jLabel15.setText("Quantity:");

        newName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNameActionPerformed(evt);
            }
        });

        jButton1.setText("Update Edit");

        addNewItem.setText("Add New Items");

        collect.setText("Collecting Payment");

        summary.setText("Summary Transactions");

        remove.setText("Remove Items");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNum, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addInventory)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(summary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(collect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newCalories, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(newQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(addNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(restockField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(changePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))))
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioB1)
                                .addGap(18, 18, 18)
                                .addComponent(RadioB5)
                                .addGap(18, 18, 18)
                                .addComponent(RadioB10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioB20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RadioB50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RadioB100))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RadioB200)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioB500)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RadioB1000)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(restockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(changePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(newName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(newCalories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(newQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewItem))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioB1)
                    .addComponent(RadioB5)
                    .addComponent(RadioB10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioB20)
                    .addComponent(RadioB50)
                    .addComponent(RadioB100))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioB1000)
                    .addComponent(RadioB500)
                    .addComponent(RadioB200))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addInventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(collect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(summary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remove)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        receipt.setColumns(20);
        receipt.setRows(5);
        jScrollPane4.setViewportView(receipt);

        exit.setText("Exit");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exit)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameInput1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void restockFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void RadioB1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB5ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB10ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB20ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB50ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB100ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB200ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB500ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void RadioB1000ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void inputNumActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void newNameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * ActionListener for the Update button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Update button.
     */
    public void updateBtnListerner(ActionListener act){
        this.jButton1.addActionListener(act);
    }
    
    /**
     * ActionListener for the Add New Item button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Add New Item button.
     */
    public void addNewItemBtnListerner(ActionListener act){
        this.addNewItem.addActionListener(act);
    }
    
    /**
     * ActionListener for the Add Inventory button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Add Inventory button.
     */
    public void addInventoryBtnListerner(ActionListener act){
        this.addInventory.addActionListener(act);
    }
    
    /**
     * ActionListener for the Collect button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Collect button.
     */
    public void collectBtnListerner(ActionListener act){
        this.collect.addActionListener(act);
    }
    
    /**
     * ActionListener for the Summary button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Summary button.
     */
    public void summaryBtnListerner(ActionListener act){
        this.summary.addActionListener(act);
    }
    
    /**
     * ActionListener for the Remove button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Remove button.
     */
    public void removeBtnListerner(ActionListener act){
        this.remove.addActionListener(act);
    }

    /**
     * ActionListener for the Back to Vending button in the Maintenance View.
     *
     * @param act The ActionListener to be set for the Back to Vending button.
     */
    public void backVendingBtnListerner(ActionListener act){
        this.exit.addActionListener(act);
    }

    /**
     * Updates the listItem JTextArea with the provided vending machine inventory.
     *
     * @param slot The HashMap containing the vending machine inventory with items and their quantities.
     */
    public void updateListItem(HashMap<Item, Integer> slot){
        listItem.setText("");
        for (Map.Entry<Item, Integer> entry : slot.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            // Append the item information to the JTextArea       
            listItem.append("Name: " + item.getName() + "\n");
            listItem.append("Price: " + item.getPrice() + "\n");
            listItem.append("Calories: " + item.getCalories() + "\n");
            listItem.append("Quantity: " + quantity + "\n");
            listItem.append("\n");
        }
    }
    
    /**
     * Sets up the Maintenance View of the vending machine with the provided inventory.
     *
     * @param slot The HashMap containing the vending machine inventory with items and their quantities.
     */
    public void runFirst(HashMap<Item, Integer> slot){
        updateListItem(slot);
    }
    
    /**
     * Checks the inventory of the vending machine and displays it in the receipt JTextArea.
     *
     * @param inventory The Inventory object representing the vending machine's inventory.
     */
    public void checkInventory(Inventory inventory) {
        receipt.setText("");
        temp = inventory.getMoney();
        for(int denomination : DENOMINATIONS){
            int amount = temp.get(denomination);
            receipt.append(denomination + " Peso " + "Total: " + amount);
            receipt.append("\n");
        }    
    
    }
    
    /**
     * Sets the name and vending status of the vending machine for the Maintenance View.
     *
     * @param name  The name of the vending machine.
     * @param check The vending status (true if vending, false if not).
     */
    public void setUserView(String name, boolean check){
        this.vmName = name;
        this.vending = check;
    }
    
    /**
     * Gets the vending status of the vending machine.
     *
     * @return The vending status (true if vending, false if not).
     */
    public boolean getVending(){
        return this.vending;
    }
    
    /**
     * Gets the text input from the nameInput1 field.
     *
     * @return The text input from the nameInput1 field.
     */
    public String getNtext(){
        return nameInput1.getText(); 
    }
    
    /**
     * Gets the text input from the restockField.
     *
     * @return The text input from the restockField.
     */
    public String getRtext(){
        return restockField.getText();
    }
    
    /**
     * Gets the text input from the changePriceField.
     *
     * @return The text input from the changePriceField.
     */
    public String getCtext(){
        return changePriceField.getText();
    }
    
    /**
     * Gets the text input from the newName field.
     *
     * @return The text input from the newName field.
     */
    public String getNewN(){
        return newName.getText();
    }
    
    /**
     * Gets the text input from the newPrice field.
     *
     * @return The text input from the newPrice field.
     */
    public String getNewP(){
        return newPrice.getText();
    }
    
    /**
     * Gets the text input from the newCalories field.
     *
     * @return The text input from the newCalories field.
     */
    public String getNewC(){
        return newCalories.getText();
    }
    
    /**
     * Gets the text input from the newQuantity field.
     *
     * @return The text input from the newQuantity field.
     */
    public String getNewQ(){
        return newQuantity.getText();
    }
    
    /**
     * Gets the text input from the inputNum field.
     *
     * @return The text input from the inputNum field.
     */
    public String getInputNum(){
        return inputNum.getText();
    }
    
    public javax.swing.JRadioButton RadioB1;
    public javax.swing.JRadioButton RadioB10;
    public javax.swing.JRadioButton RadioB100;
    public javax.swing.JRadioButton RadioB1000;
    public javax.swing.JRadioButton RadioB20;
    public javax.swing.JRadioButton RadioB200;
    public javax.swing.JRadioButton RadioB5;
    public javax.swing.JRadioButton RadioB50;
    public javax.swing.JRadioButton RadioB500;
    public javax.swing.JButton addInventory;
    public javax.swing.JButton addNewItem;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JTextField changePriceField;
    public javax.swing.JButton collect;
    public javax.swing.JLabel displayName1;
    public javax.swing.JButton exit;
    public javax.swing.JTextField inputNum;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextArea listItem;
    public javax.swing.JTextField nameInput1;
    public javax.swing.JTextField newCalories;
    public javax.swing.JTextField newName;
    public javax.swing.JTextField newPrice;
    public javax.swing.JTextField newQuantity;
    public javax.swing.JTextArea receipt;
    public javax.swing.JButton remove;
    public javax.swing.JTextField restockField;
    public javax.swing.JButton summary;
}
