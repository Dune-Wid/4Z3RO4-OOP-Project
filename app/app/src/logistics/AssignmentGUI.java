package logistics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentGUI {
    private JFrame frame;
    private JComboBox<Shipment> shipmentBox;
    private JTextArea outputArea;

    private List<Driver> drivers;
    private List<Shipment> shipments;

    public AssignmentGUI() {
        drivers = new ArrayList<>();
        shipments = new ArrayList<>();

        // Sample data
        drivers.add(new Driver("D1", "Alice"));
        drivers.add(new Driver("D2", "Bob"));

        shipments.add(new Shipment("S1", "Electronics"));
        shipments.add(new Shipment("S2", "Books"));

        // Build GUI
        frame = new JFrame("Driver Assignment");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shipmentBox = new JComboBox<>(shipments.toArray(new Shipment[0]));
        JButton assignButton = new JButton("Assign Driver");

        outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);

        assignButton.addActionListener(e -> assignDriver());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Shipment:"));
        panel.add(shipmentBox);
        panel.add(assignButton);
        panel.add(new JScrollPane(outputArea));

        frame.add(panel);
        frame.setVisible(true);
    }

    private void assignDriver() {
        Shipment selectedShipment = (Shipment) shipmentBox.getSelectedItem();
        boolean success = AssignmentManager.assignDriverToShipment(selectedShipment, drivers);
        if (success) {
            Driver assignedDriver = selectedShipment.getAssignedDriver();
            outputArea.append("Driver " + assignedDriver.getName() +
                    " assigned to " + selectedShipment.getShipmentId() + "\n");
        } else {
            outputArea.append("No available drivers for " + selectedShipment.getShipmentId() + "\n");
        }
    }


    public static void main(String[] args) {
        new AssignmentGUI();
    }
}

