package com.ijse.layeredarchitecture.controller;

import com.ijse.layeredarchitecture.bo.BOFactory;
import com.ijse.layeredarchitecture.bo.custom.GuestBO;
import com.ijse.layeredarchitecture.dto.GuestDTO;
import com.ijse.layeredarchitecture.view.tdm.GuestTM;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ManageGuestFormController {
    public Button btnCancel;
    public Button btnEdit;
    public Button btnAddGuest;
    public TableView<GuestTM> tblGuests;
    public TableColumn<GuestTM, String> colGuestId;
    public TableColumn<GuestTM, String> colName;
    public TableColumn<GuestTM, LocalDate> colDOB;
    public TableColumn<GuestTM, String> colAddress;
    public TableColumn<GuestTM, String> colContact;
    public TableColumn<GuestTM, String> colEmail;
    public TableColumn<GuestTM, LocalDate> colRegistrationDate;
    public TableColumn<GuestTM, String> colLoyaltyStatus;
    public Label lblGuestId;
    public TextField txtName;
    public DatePicker dpDOB;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public DatePicker dpRegistrationDate;
    public ComboBox<String> cmLoyaltyStatus;
    public Button btnSave;
    public TextField txtSearch;
    public Button btnSearch;

    GuestBO guestBO = (GuestBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.GUEST);

    public void initialize() throws SQLException, ClassNotFoundException {
        tblGuests.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("guestId"));
        tblGuests.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblGuests.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblGuests.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblGuests.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblGuests.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));
        tblGuests.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        tblGuests.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("loyaltyStatus"));

//        initUI();

        tblGuests.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnCancel.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                lblGuestId.setText(newValue.getGuestId());
                txtName.setText(newValue.getName());
                dpDOB.setValue(newValue.getDob());
                txtAddress.setText(newValue.getAddress());
                txtContact.setText(newValue.getContact());
                txtEmail.setText(newValue.getEmail());
                dpRegistrationDate.setValue(newValue.getRegistrationDate());
                cmLoyaltyStatus.setValue(newValue.getLoyaltyStatus());

                enableFields(true);
            }
        });
        
        txtAddress.setOnAction(event -> btnSave.fire());
        loadAllGuests();
    }

    private void enableFields(boolean b) {
        lblGuestId.setDisable(true);
        txtName.setDisable(!b);
        txtEmail.setDisable(!b);
        txtContact.setDisable(!b);
        txtAddress.setDisable(!b);
        dpDOB.setDisable(!b);
        dpRegistrationDate.setDisable(!b);
        cmLoyaltyStatus.setDisable(!b);
    }

    private void loadAllGuests() {
        tblGuests.getItems().clear();
        try{
            ArrayList<GuestDTO> allGuest = guestBO.getAllGuest();
            for (GuestDTO guestDTO : allGuest) {
                tblGuests.getItems().add(
                        new GuestTM(guestDTO.getGuestId(),guestDTO.getName(), guestDTO.getDob(),guestDTO.getAddress(),guestDTO.getContact(),guestDTO.getEmail(), guestDTO.getRegistrationDate(),guestDTO.getLoyaltyStatus()));
            }
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK).showAndWait();
        }
    }

//    private void initUI() throws SQLException, ClassNotFoundException {
//        lblGuestId.setText(guestBO.generateNewGuestID());
//        txtName.clear();
//        txtEmail.clear();
//        txtContact.clear();
//        txtAddress.clear();
//        dpDOB.setValue(null);
//        dpRegistrationDate.setValue(LocalDate.now());
//        cmLoyaltyStatus.setItems(FXCollections.observableArrayList("Gold", "Silver", "Bronze"));
//        cmLoyaltyStatus.setValue(null);
//
//        enableFields(false);
//        btnSave.setDisable(true);
//        btnCancel.setDisable(true);
//    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        String guestId = lblGuestId.getText();
        try {
            if (!existGuest(guestId)) {
                new Alert(Alert.AlertType.ERROR,"This guest does not exist",ButtonType.OK).showAndWait();
                return;
            }
            guestBO.deleteGuest(guestId);
            tblGuests.getItems().removeIf(g -> g.getGuestId().equals(guestId));
//            initUI();
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String guestId = lblGuestId.getText();
        String name = txtName.getText();
        LocalDate dob = dpDOB.getValue();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        LocalDate regDate = dpRegistrationDate.getValue();
        String loyalty = cmLoyaltyStatus.getValue();

        if (!name.matches("[A-Za-z ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name").show();
            txtName.requestFocus();
            return;
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid email").show();
            txtEmail.requestFocus();
            return;
        }
        if (!contact.matches("[0-9]{10}")) {
            new Alert(Alert.AlertType.ERROR, "Invalid contact number").show();
            txtContact.requestFocus();
            return;
        }

        if (dob == null) {new Alert(Alert.AlertType.ERROR, "Select a date of birth").show();}
        if (regDate == null) {new Alert(Alert.AlertType.ERROR, "Select a registration date").show();}
        if (loyalty == null) {new Alert(Alert.AlertType.ERROR, "Select loyalty status").show();}

        GuestDTO guest = new GuestDTO(guestId, name, dob, address, contact, email, regDate, loyalty);

        if (btnSave.getText().equalsIgnoreCase("Save")) {
            try {
                if (existGuest(guestId)) {
                    new Alert(Alert.AlertType.ERROR, guestId + " already exists").show();
                    return;
                }
                guestBO.saveGuest(guest);
                tblGuests.getItems().add(new GuestTM(
                        guestId, name, dob, address, contact, email, regDate, loyalty
                ));
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to save guest: " + e.getMessage()).show();
            }
        }else {
            try {
                guestBO.updateGuest(guest);
                GuestTM guestTM = tblGuests.getSelectionModel().getSelectedItem();
                guestTM.setName(name);
                guestTM.setDob(dob);
                guestTM.setAddress(address);
                guestTM.setContact(contact);
                guestTM.setEmail(email);
                guestTM.setRegistrationDate(regDate);
                guestTM.setLoyaltyStatus(loyalty);
                tblGuests.refresh();
//                initUI();
            }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Failed to update guest: "+e.getMessage()).show();}
        }
    }

    private boolean existGuest(String guestId) throws SQLException, ClassNotFoundException {
        return guestBO.existerGuest(guestId);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String keyword = txtSearch.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            loadAllGuests();
            return;
        }
        try {
            List<GuestTM> allGuests = new ArrayList<>(tblGuests.getItems());
            List<GuestTM> filteredList = allGuests.stream()
                    .filter(guest ->
                            guest.getGuestId().toLowerCase().contains(keyword) ||
                                    guest.getName().toLowerCase().contains(keyword) ||
                                    guest.getAddress().toLowerCase().contains(keyword) ||
                                    guest.getContact().toLowerCase().contains(keyword) ||
                                    guest.getEmail().toLowerCase().contains(keyword) ||
                                    guest.getLoyaltyStatus().toLowerCase().contains(keyword)
                    )
                    .collect(toList());
            tblGuests.setItems(FXCollections.observableList(filteredList));
            if (filteredList.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "No guests found").show();
            }
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR,"Search failed: " + e.getMessage()).show();
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
        GuestTM selected = tblGuests.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.ERROR, "Please select a guest to edit.").show();
            return;
        }
        lblGuestId.setText(selected.getGuestId());
        txtName.setText(selected.getName());
        dpDOB.setValue(selected.getDob());
        txtAddress.setText(selected.getAddress());
        txtContact.setText(selected.getContact());
        txtEmail.setText(selected.getEmail());
        dpRegistrationDate.setValue(selected.getRegistrationDate());
        cmLoyaltyStatus.setValue(selected.getLoyaltyStatus());

        enableFields(true);
        btnSave.setDisable(false);
        btnSave.setText("Update");
    }

    public void btnAddNewGuestOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        initUI();
        enableFields(true);
        try {
            lblGuestId.setText(generateNewGuestId());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate ID: " + e.getMessage()).show();
        }
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblGuests.getSelectionModel().clearSelection();
    }

    private String generateNewGuestId() throws SQLException, ClassNotFoundException {
        return guestBO.generateNewGuestID();
    }
}
