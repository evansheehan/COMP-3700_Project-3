import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUsersUI {
    public JFrame view;

    public JButton btnAdd = new JButton("Add User");
    public JButton btnDelete = new JButton("Delete User");
    public JButton btnUpdateClass = new JButton("Update Class");

    public JTextField txtUsername = new JTextField(20);
    public JTextField txtPassword = new JTextField(20);
    public JTextField txtFullName = new JTextField(20);
    public JTextField txtClass = new JTextField(20);

    public ManageUsersUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Update User Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Username "));
        line1.add(txtUsername);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Password "));
        line2.add(txtPassword);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Full Name "));
        line3.add(txtFullName);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Class "));
        line3.add(txtClass);
        view.getContentPane().add(line4);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnUpdateClass);
        view.getContentPane().add(panelButtons);

        btnAdd.addActionListener(new AddUserListener());
        btnUpdateClass.addActionListener(new UpdateClassListener());
    }

    public void run() {
        view.setVisible(true);
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            MessageModel msg = new MessageModel();
            Gson gson = new Gson();
            UserModel user = new UserModel();

            user.mUsername = txtUsername.getText();
            user.mPassword = txtPassword.getText();
            user.mFullname = txtFullName.getText();
            user.mUserType = Integer.parseInt(txtClass.getText());

            msg.code = MessageModel.PUT_USER;
            msg.data = gson.toJson(user);

            try {
                msg = StoreManager.getInstance().getNetworkAdapter().exchange(msg, "localhost", 1000);

                if (msg.code == MessageModel.OPERATION_FAILED) {
                    JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "User is SAVED successfully!");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class UpdateClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            MessageModel msg = new MessageModel();
            Gson gson = new Gson();
            UserModel user = new UserModel();

            user.mUsername = txtUsername.getText();
            user.mUserType = Integer.parseInt(txtClass.getText());

            msg.code = MessageModel.PUT_USER;
            msg.data = gson.toJson(user);

            try {
                msg = StoreManager.getInstance().getNetworkAdapter().exchange(msg, "localhost", 1000);

                if (msg.code == MessageModel.OPERATION_FAILED) {
                    JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "User is SAVED successfully!");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
