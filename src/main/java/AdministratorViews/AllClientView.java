package AdministratorViews;

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
import ComputerManagementFunctionFactory.ClientFactory;
import model.Client;
import model.Employee;

import java.util.List;

public class AllClientView {
    private Employee currentUser;

    public AllClientView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    private Client currentClient;

    public AllClientView(Client u){
        this.currentClient = u;
    }

    public Scene showView(Stage stage) {

        VBox root= new VBox();
        ClientFactory clientFactory= new ClientFactory();
        List<Client> clients =clientFactory.findAllClientList();
        ObservableList<Client> list= FXCollections.observableArrayList(clients);

        TableView<Client> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setCellValueFactory(new PropertyValueFactory("firstName"));
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newFirstName=(String) t.getNewValue();

                currentClient.setFirstName(newFirstName);
                clientFactory.editClient(currentClient);
                clientFactory.deleteClient(currentClient);
            }

        });



        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellValueFactory(new PropertyValueFactory("lastName"));
        lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newLastName=(String) t.getNewValue();

                currentClient.setLastName(newLastName);
                clientFactory.editClient(currentClient);
                clientFactory.deleteClient(currentClient);
            }

        });

        TableColumn emailColumn = new TableColumn("Email");
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
        emailColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newEmail=(String) t.getNewValue();

                currentClient.setEmail(newEmail);
                clientFactory.editClient(currentClient);
                clientFactory.deleteClient(currentClient);
            }

        });

        TableColumn phoneNumberColumn = new TableColumn("Phone Number");
        phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
        phoneNumberColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newPhoneNumber=(String) t.getNewValue();

                currentClient.setPhoneNumber(newPhoneNumber);
                clientFactory.editClient(currentClient);
                clientFactory.deleteClient(currentClient);
            }

        });

        TableColumn addressColumn = new TableColumn("Address ");
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setCellValueFactory(new PropertyValueFactory("address"));
        addressColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newRole=(String) t.getNewValue();

                currentClient.setAddress(newRole);
                clientFactory.editClient(currentClient);
                clientFactory.deleteClient(currentClient);
            }

        });





        table.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn, phoneNumberColumn, addressColumn);

        Button save= new Button("Save");
        save.setOnAction(e->{
            AdministratorHomeView hv = new AdministratorHomeView(currentUser);
            stage.setScene(hv.execute(stage));
        });

//        Button deleteClientButton = new Button("-Delete Client Button-");
//        deleteClientButton.setOnAction(e -> {
//            TableColumn.CellEditEvent t = null;
//            Client currentClient= (Client) t.getTableView().getItems().get(t.getTablePosition().getRow());
//            ClientFactory clientFactory1=new ClientFactory();
//            clientFactory1.deleteClient(currentClient);
//        });

        root.getChildren().addAll(table, save);

        Scene scene= new Scene(root, 450, 450);
        stage.setTitle("All Clients");
        return scene;


    }
}
