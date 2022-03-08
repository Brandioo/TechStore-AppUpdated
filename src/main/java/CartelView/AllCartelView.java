package CartelView;

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
import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.CartelFactory;
import ComputerView.BuyComputerView;
import ComputerView.BuyOnlineComputerView;
import model.Cartel;
import model.Client;
import model.Computers;
import model.Employee;

import java.util.List;

public class AllCartelView {
    private Employee currentUser;

    public AllCartelView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    private Client currentClient;

    public AllCartelView(Client u){
        this.currentClient = u;
    }

    private Computers currentComputer;

    public AllCartelView(Computers u){
        this.currentComputer = u;
    }
    public Scene showView(Stage stage) {

        VBox root= new VBox();
        CartelFactory cartelFactory= new CartelFactory();
        List<Cartel> cartels =cartelFactory.findAllCartelsList();
        ObservableList<Cartel> list= FXCollections.observableArrayList(cartels);

        TableView<Cartel> table = new TableView();
        table.setItems(list);
        table.setEditable(true);


        TableColumn cartelIDColumn = new TableColumn("Cartel ID ");
        cartelIDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        cartelIDColumn.setCellValueFactory(new PropertyValueFactory("cartelId"));
        cartelIDColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                Cartel currentCartel= (Cartel) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                Integer newCartelID=(Integer) t.getNewValue();

                currentCartel.setCartelId(newCartelID);
                cartelFactory.editCartel(currentCartel);
            }

        });


        Button save= new Button("Save");
        save.setOnAction(e->{
            AdministratorHomeView hv = new AdministratorHomeView(currentUser);
            stage.setScene(hv.execute(stage));
        });

        Button buyBook= new Button("Buy Computer");
        buyBook.setOnAction(e->{
            BuyComputerView buyBookView = new BuyComputerView(currentUser);
            stage.setScene(buyBookView.execute(stage));
        });

        Button buyBookOnline= new Button("Buy Computer With Credit Card");
        buyBookOnline.setOnAction(e->{
            BuyOnlineComputerView buyOnlineComputerView = new BuyOnlineComputerView(currentUser);
            stage.setScene(buyOnlineComputerView.execute(stage));
        });

        root.getChildren().addAll(table, save, buyBook, buyBookOnline);

        Scene scene= new Scene(root, 450, 450);
        stage.setTitle("All Cartels");
        return scene;


    }
}
