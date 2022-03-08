package CartelRecordView;

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
import javafx.util.converter.LocalDateTimeStringConverter;
import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.CartelRecordFactory;
import ComputerView.BuyComputerView;
import ComputerView.BuyOnlineComputerView;
import model.CartelRecord;
import model.Computers;
import model.Employee;

import java.time.LocalDateTime;
import java.util.List;

public class AllCartelRecordView {
    private Employee currentUser;

    public AllCartelRecordView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    private Computers currentComputer;

    public AllCartelRecordView(Computers u){
        this.currentComputer = u;
    }
    public Scene showView(Stage stage) {

        VBox root= new VBox();
        CartelRecordFactory cartelRecordFactory= new CartelRecordFactory();
        List<CartelRecord> cartelRecordList =cartelRecordFactory.findAllCartelRecordList();
        ObservableList<CartelRecord> list= FXCollections.observableArrayList(cartelRecordList);

        TableView<CartelRecord> table = new TableView();
        table.setItems(list);
        table.setEditable(true);

        TableColumn endData = new TableColumn("End Data");
        endData.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateTimeStringConverter()));
        endData.setCellValueFactory(new PropertyValueFactory("endData"));
        endData.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>(){

            @Override
            public void handle(TableColumn.CellEditEvent t) {
                // TODO Auto-generated method stub

                CartelRecord currentCartelRecord= (CartelRecord) t.getTableView().getItems().get(t.getTablePosition().getRow());
                int pos= table.getSelectionModel().getSelectedIndex();
                LocalDateTime newEndData= (LocalDateTime) t.getNewValue();

                currentCartelRecord.setEndData(newEndData);
                cartelRecordFactory.editCartelRecord(currentCartelRecord);
            }

        });

        table.getColumns().addAll(endData);

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
        stage.setTitle("All Cartel-Records");
        return scene;


    }
}
