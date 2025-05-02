package fasttrack.controller;

import fasttrack.model.Driver;
import fasttrack.model.DriverModel;
import fasttrack.view.DriverView;
import javax.swing.table.DefaultTableModel;

public class DriverController {
    private DriverModel model;
    private DriverView view;
    private int nextId = 1;

    public DriverController(DriverModel model, DriverView view) {
        this.model = model;
        this.view = view;

        view.getAddButton().addActionListener(e -> addDriver());
        view.getUpdateButton().addActionListener(e -> updateDriver());
        view.getDeleteButton().addActionListener(e -> deleteDriver());

        loadTable();
    }

    private void addDriver() {
        String name = view.getNameField().getText();
        String vehicle = view.getVehicleField().getText();
        boolean available = view.isAvailableSelected();

        Driver newDriver = new Driver(nextId++, name, vehicle, available);
        model.addDriver(newDriver);
        loadTable();
    }

    private void updateDriver() {
        int row = view.getDriverTable().getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(view.getTableModel().getValueAt(row, 0).toString());
        String name = view.getNameField().getText();
        String vehicle = view.getVehicleField().getText();
        boolean available = view.isAvailableSelected();

        Driver updatedDriver = new Driver(id, name, vehicle, available);
        model.updateDriver(updatedDriver);
        loadTable();
    }

    private void deleteDriver() {
        int row = view.getDriverTable().getSelectedRow();
        if (row == -1) return;

        int id = Integer.parseInt(view.getTableModel().getValueAt(row, 0).toString());
        model.removeDriver(id);
        loadTable();
    }

    private void loadTable() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);
        for (Driver d : model.getAllDrivers()) {
            tableModel.addRow(new Object[]{
                    d.getId(), d.getName(), d.getVehicle(), d.isAvailable()
            });
        }
    }
}