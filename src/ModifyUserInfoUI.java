import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

public class ModifyUserInfoUI {
    public JFrame view;

    public JButton btnSave = new JButton("Save");
    public JButton btnCancel = new JButton("Cancel");

    public JTextField txtUsername = new JTextField(10);
    public JTextField txtPassword = new JTextField(10);

    public JLabel labUsername = new JLabel("Product Price: ");
    public JLabel labPassword = new JLabel("Date of Purchase: ");

    UserModel user;

    public ModifyUserInfoUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Modify User");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel line = new JPanel(new FlowLayout());
        line.add(new JLabel("Username "));
        line.add(txtUsername);
        line.add(labUsername);
        view.getContentPane().add(line);

        line = new JPanel(new FlowLayout());
        line.add(new JLabel("Password "));
        line.add(txtPassword);
        line.add(labPassword);
        view.getContentPane().add(line);

        line = new JPanel(new FlowLayout());
        line.add(btnSave);
        line.add(btnCancel);
        view.getContentPane().add(line);

//        txtUsername.addFocusListener(new ProductIDFocusListener());
//        txtPassword.addFocusListener(new CustomerIDFocusListener());

        btnSave.addActionListener(new SaveButtonListener());
    }

    public void run() {
        user = new UserModel();
        view.setVisible(true);
    }

//    private class ProductIDFocusListener implements FocusListener {
//        @Override
//        public void focusGained(FocusEvent focusEvent) {
//
//        }
//
//        @Override
//        public void focusLost(FocusEvent focusEvent) {
//            process();
//        }
//
//        private void process() {
//            String s = txtProductID.getText();
//            Gson gson = new Gson();
//
//            if (s.length() == 0) {
//                labProductName.setText("Product Name: [not specified!]");
//                return;
//            }
//
//            System.out.println("ProductID = " + s);
//
//            try {
//                purchase.mProductID = Integer.parseInt(s);
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: Invalid ProductID", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            try {
//                MessageModel msg = new MessageModel();
//                msg.code = MessageModel.GET_PRODUCT;
//                msg.data = Integer.toString(purchase.mProductID);
//
//                msg = StoreManager.getInstance().getNetworkAdapter().exchange(msg, "localhost", 1000);
//
//                if (msg.code == MessageModel.OPERATION_FAILED) {
//                    JOptionPane.showMessageDialog(null, "Product does not exist!");
//                }
//                else {
//                    product = gson.fromJson(msg.data, ProductModel.class);
//                    /*txtName.setText(product.mName);
//                    txtPrice.setText(Double.toString(product.mPrice));
//                    txtQuantity.setText(Double.toString(product.mQuantity));*/
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            if (product == null) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: No product with id = " + purchase.mProductID + " in store!", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                labProductName.setText("Product Name: ");
//
//                return;
//            }
//
//            labProductName.setText("Product Name: " + product.mName);
//            purchase.mPrice = product.mPrice;
//            labPrice.setText("Product Price: " + product.mPrice);
//
//        }
//
//    }
//
//    private class CustomerIDFocusListener implements FocusListener {
//        @Override
//        public void focusGained(FocusEvent focusEvent) {
//
//        }
//
//        @Override
//        public void focusLost(FocusEvent focusEvent) {
//            process();
//        }
//
//        private void process() {
//            String s = txtCustomerID.getText();
//            Gson gson = new Gson();
//
//            if (s.length() == 0) {
//                labCustomerName.setText("Customer Name: [not specified!]");
//                return;
//            }
//
//            System.out.println("CustomerID = " + s);
//
//            try {
//                purchase.mCustomerID = Integer.parseInt(s);
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: Invalid CustomerID", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            try {
//                MessageModel msg = new MessageModel();
//                msg.code = MessageModel.GET_CUSTOMER;
//                msg.data = Integer.toString(purchase.mCustomerID);
//
//                msg = StoreManager.getInstance().getNetworkAdapter().exchange(msg, "localhost", 1000);
//
//                if (msg.code == MessageModel.OPERATION_FAILED) {
//                    JOptionPane.showMessageDialog(null, "Customer NOT exists!");
//                }
//                else {
//                    customer = gson.fromJson(msg.data, CustomerModel.class);
//                    /*txtName.setText(customer.mName);
//                    txtPhone.setText(customer.mPhone);
//                    txtAddress.setText(customer.mAddress);*/
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            if (customer == null) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: No customer with id = " + purchase.mCustomerID + " in store!", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                labCustomerName.setText("Customer Name: ");
//
//                return;
//            }
//
//            labCustomerName.setText("Product Name: " + customer.mName);
//
//        }
//
//    }
//
//    private class QuantityChangeListener implements DocumentListener {
//        public void changedUpdate(DocumentEvent e) {
//            process();
//        }
//
//        public void removeUpdate(DocumentEvent e) {
//            process();
//        }
//
//        public void insertUpdate(DocumentEvent e) {
//            process();
//        }
//
//        private void process() {
//            String s = txtQuantity.getText();
//
//            if (s.length() == 0) {
//                //labCustomerName.setText("Customer Name: [not specified!]");
//                return;
//            }
//
//            System.out.println("Quantity = " + s);
//
//            try {
//                purchase.mQuantity = Double.parseDouble(s);
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: Please enter an invalid quantity", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            if (purchase.mQuantity <= 0) {
//                JOptionPane.showMessageDialog(null,
//                        "Error: Please enter an invalid quantity", "Error Message",
//                        JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            if (purchase.mQuantity > product.mQuantity) {
//                JOptionPane.showMessageDialog(null,
//                        "Not enough available products!", "Information",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//
//            purchase.mCost = purchase.mQuantity * product.mPrice;
//            purchase.mTax = purchase.mCost * 0.09;
//            purchase.mTotal = purchase.mCost + purchase.mTax;
//
//            labCost.setText("Cost: $" + String.format("%8.2f", purchase.mCost).trim());
//            labTax.setText("Tax: $" + String.format("%8.2f", purchase.mTax).trim());
//            labTotalCost.setText("Total: $" + String.format("%8.2f", purchase.mTotal).trim());
//
//        }
//    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

//            MessageModel msg = new MessageModel();
//            msg.code = MessageModel.GET_ACTIVE_USER;

            String username = txtUsername.getText();
            String password = txtPassword.getText();
            Gson gson = new Gson();

            if (username.length() == 0) {
//                username = StoreServer.
                JOptionPane.showMessageDialog(null, "Username field left empty. Previous " +
                        "username will be stored.");
                return;
            }
            if (password.length() == 0) {
//                password =
                JOptionPane.showMessageDialog(null, "Password field left empty. Previous " +
                        "user password will be stored.");
            }

//            try {
//                purchase.mPurchaseID = Integer.parseInt(id);
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "PurchaseID is invalid!");
//                return;
//            }

            try {
                MessageModel msg = new MessageModel();
                msg.code = MessageModel.PUT_USER;
                msg.data = gson.toJson(user);

                msg = StoreManager.getInstance().getNetworkAdapter().exchange(msg, "localhost", 1000);

                if (msg.code == MessageModel.OPERATION_FAILED) {
                    JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "User is SAVED successfully!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

