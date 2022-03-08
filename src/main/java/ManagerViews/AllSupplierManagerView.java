package ManagerViews;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.SupplierFactory;
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
import model.Supplier;

import java.util.List;

public class AllSupplierManagerView {
    private Employee currentUser;

    public AllSupplierManagerView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene showView(Stage stage) {

        VBox root= new VBox();
        SupplierFactory supplierFactory= new SupplierFactory();
        List<Supplier> suppliers =supplierFactory.findAllSuppliersList();
        ObservableList<Supplier> list= FXCollections.observableArrayList(suppliers);

        TableView<Supplier> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn supplierCompanyName = new TableColumn("Company Name");
        supplierCompanyName.setCellFactory(TextFieldTableCell.forTableColumn());
        supplierCompanyName.setCellValueFactory(new PropertyValueFactory("supplierCompanyName"));
        supplierCompanyName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Supplier currentSupplier= (Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newCompany =(String) t.getNewValue();

                currentSupplier.setSupplierCompanyName(newCompany);
                supplierFactory.editSuppliers(currentSupplier);
            }

        });



        TableColumn product = new TableColumn("Product");
        product.setCellFactory(TextFieldTableCell.forTableColumn());
        product.setCellValueFactory(new PropertyValueFactory("product"));
        product.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Supplier currentSupplier= (Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                String newProduct=(String) t.getNewValue();

                currentSupplier.setProduct(newProduct);
                supplierFactory.editSuppliers(currentSupplier);
            }

        });


        TableColumn quantityColumn = new TableColumn("Quantity ");
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
        quantityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Supplier currentSupplier = (Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newQuantity=(Integer) t.getNewValue();

                currentSupplier.setQuantity(newQuantity);
                supplierFactory.editSuppliers(currentSupplier);
            }

        });


        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        priceColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Supplier currentSupplier= (Supplier) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newPrice=(Integer) t.getNewValue();

                currentSupplier.setPrice(newPrice);
                supplierFactory.editSuppliers(currentSupplier);
            }

        });

        table.getColumns().addAll(supplierCompanyName, product, quantityColumn, priceColumn);//, quantityColumn, priceColumn);


        Button save= new Button("Save");
        save.setOnAction(e->{
            ManagerHomeView hv = new ManagerHomeView(currentUser);
            stage.setScene(hv.execute(stage));
        });

        root.getChildren().addAll(table, save);

        Scene scene= new Scene(root, 450, 450);
        stage.setTitle("All Suppliers");
        return scene;


    }
}
