package fasttrack.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DriverView {
    // GUI Components (make sure these match your .form file)
    public JPanel Jpanel;
    public JLabel lblname;
    public JLabel lblvehile;
    public JLabel lblavailability;
    public JTextField nameField;
    public JTextField vehicleField;
    public JComboBox<String> availabilityCheck;
    public JButton addDriverButton;
    public JButton updateButton;
    public JButton deleteButton;
    public JScrollPane scrollPane;
    public JTable driverTable;
    private DefaultTableModel tableModel;

    public DriverView() {
        // Initialize table model (columns: ID, Name, Vehicle, Available)
        tableModel = new DefaultTableModel(
                new Object[]{"ID", "Name", "Vehicle", "Available"}, 0);

        // Set model to table (if not already set in createUIComponents)
        if (driverTable != null) {
            driverTable.setModel(tableModel);
        }

        // Configure table behavior
        assert driverTable != null;
        driverTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        driverTable.setAutoCreateRowSorter(true);

        // Populate availability dropdown
        availabilityCheck.addItem("YES");
        availabilityCheck.addItem("NO");
    }

    // Required for GUI designer to initialize custom components
    private void createUIComponents() {
        // Initialize table and model
        tableModel = new DefaultTableModel(
                new Object[]{"ID", "Name", "Vehicle", "Available"}, 0);
        driverTable = new JTable(tableModel);

        // Create scroll pane wrapping the table
        scrollPane = new JScrollPane(driverTable);
    }

    // Getter methods (unchanged)
    public JButton getAddButton() { return addDriverButton; }
    public JButton getUpdateButton() { return updateButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JTextField getNameField() { return nameField; }
    public JTextField getVehicleField() { return vehicleField; }
    public JTable getDriverTable() { return driverTable; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public boolean isAvailableSelected() { return "YES".equals(availabilityCheck.getSelectedItem()); }
    public JPanel getMainPanel() { return Jpanel; }
}