package fasttrack.controller;

import fasttrack.model.DriverModel;

public class DriverController {
    private DriverModel Model;
    private DriverView View;
    private int nextId = 1;

    public DriverController(DriverModel model, DriverView view) {
        this.Model = model;
        this.View = view;

        view.getAddButton().addActionListener(e -> addDriver());
        view.getUpdateButton().addActionListener(e -> updateDriver());
        view.getDeleteButton().addActionListener(e -> deleteDriver());

        loadTable();
    }

    private void addDriver() {
        String name = View.nametxt.getText();
        String vehicle = View.vehicletxt.getText();
        boolean available = View.availableBox.isSelected();

        Driver newDriver = new Driver(nextId++, name, vehicle, available);
        Model.addDriver(newDriver);
        loadTable();
    }

    private void updateDriver() {
        int row = View.getDriverTable().getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(View.getTableModel().getValueAt(row, 0).toString());
        String name = View.nameField.getText();
        String vehicle = View.vehicleField.getText();
        boolean available = View.availableBox.isSelected();

        Driver updatedDriver = new Driver(id, name, vehicle, available);
        model.updateDriver(updatedDriver);
        loadTable();
    }

    private void deleteDriver() {
        int row = View.getDriverTable().getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(View.getTableModel().getValueAt(row, 0).toString());
        model.removeDriver(id);
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel tableModel = View.getTableModel();
        tableModel.setRowCount(0);
        for (Driver d : model.getAllDrivers()) {
            tableModel.addRow(new Object[]{
                    d.getId(), d.getName(), d.getVehicle(), d.isAvailable()
            });
        }
    }
}
