package CashierView;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.ComputerFactory;
import ComputerView.BuyComputerView;
import ComputerView.BuyOnlineComputerView;
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
import model.Client;
import model.Computers;
import model.Employee;

import java.util.List;

public class AllComputerCashierView {
    private Employee currentUser;

    public AllComputerCashierView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    private Client currentClient;

    public AllComputerCashierView(Client u){
        this.currentClient = u;
    }

    private Computers currentBook;

    public AllComputerCashierView(Computers u){
        this.currentBook = u;
    }
    public Scene showView(Stage stage) {

        VBox root= new VBox();
        ComputerFactory computerFactory= new ComputerFactory();
        List<Computers> computers =computerFactory.findAllComputerList();
        ObservableList<Computers> list= FXCollections.observableArrayList(computers);

        TableView<Computers> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn computerName = new TableColumn("Computer Name");
        computerName.setCellFactory(TextFieldTableCell.forTableColumn());
        computerName.setCellValueFactory(new PropertyValueFactory("computerName"));
        computerName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentBook= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newComputerName=(String) t.getNewValue();

                currentBook.setComputerName(newComputerName);
                computerFactory.editComputers(currentBook);
            }

        });



        TableColumn computerType = new TableColumn("Computer Type");
        computerType.setCellFactory(TextFieldTableCell.forTableColumn());
        computerType.setCellValueFactory(new PropertyValueFactory("computerType"));
        computerType.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentComputerType= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newComputerType=(String) t.getNewValue();

                currentComputerType.setComputerType(newComputerType);
                computerFactory.editComputers(currentComputerType);
            }

        });

        TableColumn ISBNColumn = new TableColumn("ISBN");
        ISBNColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ISBNColumn.setCellValueFactory(new PropertyValueFactory("isbn"));
        ISBNColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentISBN= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newIsbn =(String) t.getNewValue();

                currentISBN.setIsbn(newIsbn);
                computerFactory.editComputers(currentISBN);
            }

        });

        TableColumn quantityColumn = new TableColumn("Quantity ");
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentComputer= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newQuantity=(Integer) t.getNewValue();

                currentComputer.setQuantity(newQuantity);
                computerFactory.editComputers(currentComputer);
            }

        });


        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Computers currentComputer= (Computers) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newPrice=(Integer) t.getNewValue();

                currentComputer.setPrice(newPrice);
                computerFactory.editComputers(currentComputer);
            }

        });

        table.getColumns().addAll(computerName, computerType, ISBNColumn, quantityColumn, priceColumn);//, quantityColumn, priceColumn);


        Button save= new Button("Save");
        save.setOnAction(e->{
            CashierHomeView hv = new CashierHomeView(currentUser);
            stage.setScene(hv.execute(stage));
        });

        Button buyBook= new Button("Buy Computer");
        buyBook.setOnAction(e->{
            BuyComputerView buyBookView = new BuyComputerView(currentUser);
            stage.setScene(buyBookView.execute(stage));
        });

        Button buyBookOnline= new Button("Buy Computer With Credit Card");
        buyBookOnline.setOnAction(e->{
            BuyOnlineComputerCashierView buyOnlineComputerView = new BuyOnlineComputerCashierView(currentUser);
            stage.setScene(buyOnlineComputerView.execute(stage));
        });

        root.getChildren().addAll(table, save, buyBook, buyBookOnline);

        Scene scene= new Scene(root, 450, 450);
        stage.setTitle("All Computers");
        return scene;


    }
}
