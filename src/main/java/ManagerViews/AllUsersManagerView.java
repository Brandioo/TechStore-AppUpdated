package ManagerViews;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.EmployeeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import model.Employee;

import java.time.LocalDate;
import java.util.List;

public class AllUsersManagerView {
    private Employee currentEmployee;

    public AllUsersManagerView(Employee u){
        this.currentEmployee = u;
    }

    public Scene showView(Stage stage) {

        VBox root= new VBox();
        EmployeeFactory employeeFactory= new EmployeeFactory();
        List<Employee> employees =employeeFactory.findAllEmployeeList();
        ObservableList<Employee> list= FXCollections.observableArrayList(employees);

        TableView<Employee> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newFirstName=(String) t.getNewValue();

                currentEmployee.setFirstName(newFirstName);
                employeeFactory.editEmployee(currentEmployee);
            }

        });



        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newLastName=(String) t.getNewValue();

                currentUser.setLastName(newLastName);
                employeeFactory.editEmployee(currentUser);
            }

        });

        TableColumn dateOfBirth = new TableColumn("Date Of Birth");
        dateOfBirth.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory("dateOfBirth"));
        dateOfBirth.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentUser= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                LocalDate newDateOfBirth= (LocalDate) t.getNewValue();

                currentUser.setDateOfBirth(newDateOfBirth);
                employeeFactory.editEmployee(currentUser);
            }

        });

        TableColumn emailColumn = new TableColumn("Email");
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        emailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newEmail=(String) t.getNewValue();

                currentEmployee.setEmail(newEmail);
                employeeFactory.editEmployee(currentEmployee);
            }

        });

        TableColumn phoneNumberColumn = new TableColumn("Phone Number");
        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        phoneNumberColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newPhoneNumber=(String) t.getNewValue();

                currentEmployee.setPhoneNumber(newPhoneNumber);
                employeeFactory.editEmployee(currentEmployee);
            }

        });

        TableColumn roleColumn = new TableColumn("Role ");
        roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        roleColumn.setCellValueFactory(new PropertyValueFactory("role"));
        roleColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newRole=(String) t.getNewValue();

                currentEmployee.setRole(newRole);
                employeeFactory.editEmployee(currentEmployee);
            }

        });

        TableColumn userColumn = new TableColumn("User ");
        userColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        userColumn.setCellValueFactory(new PropertyValueFactory("user"));
        userColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newUser=(String) t.getNewValue();

                currentEmployee.setUser(newUser);
                employeeFactory.editEmployee(currentEmployee);
            }

        });

        TableColumn passwordColumn = new TableColumn("Password");
        passwordColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordColumn.setCellValueFactory(new PropertyValueFactory("password"));
        passwordColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newPassword=(String) t.getNewValue();

                currentEmployee.setPassword(newPassword);
                employeeFactory.editEmployee(currentEmployee);
            }

        });

        TableColumn priceColumn = new TableColumn("Salary");
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceColumn.setCellValueFactory(new PropertyValueFactory("salary"));
        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub
                Employee currentEmployee= (Employee) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newPrice=(Integer) t.getNewValue();

                currentEmployee.setSalary(newPrice);
                employeeFactory.editEmployee(currentEmployee);
            }

        });



        table.getColumns().addAll(firstNameColumn, lastNameColumn, dateOfBirth, emailColumn, phoneNumberColumn,
                roleColumn, userColumn, passwordColumn, priceColumn);

        Button save= new Button("Save");
        save.setOnAction(e->{
            ManagerHomeView hv = new ManagerHomeView(currentEmployee);
            stage.setScene(hv.execute(stage));
        });

        root.getChildren().addAll(table, save);

        Scene scene= new Scene(root, 450, 450);
        stage.setTitle("All Users");
        return scene;


    }
}
