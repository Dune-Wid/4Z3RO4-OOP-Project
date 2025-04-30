package fasttrack.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DriverView extends JFrame {
    public JTextField nameField;
    public JTextField vehicleField;
    public JComboBox availabilityCheck;

    public JButton addButton;
    public JButton updateButton;
    public JButton deleteButton;
    private JLabel lblname;

    public JTable driverTable;
    public DefaultTableModel tableModel;

    public DriverView() {
        setTitle("Delivery Personnel Management");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        nameField = new JTextField();
        vehicleField = new JTextField();
        availabilityCheck = new JCheckBox("Available");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Vehicle:"));
        formPanel.add(vehicleField);
        formPanel.add(new JLabel("Available:"));
        formPanel.add(availabilityCheck);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        formPanel.add(addButton);
        formPanel.add(updateButton);
        formPanel.add(deleteButton);

        add(formPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"ID", "Name", "Vehicle", "Available"};
        tableModel = new DefaultTableModel(columnNames, 0);
        driverTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(driverTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JButton getAddButton() { return addButton; }
    public JButton getUpdateButton() { return updateButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JTable getDriverTable() { return driverTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
}