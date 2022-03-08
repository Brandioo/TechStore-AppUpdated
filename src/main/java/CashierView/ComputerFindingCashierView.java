package CashierView;

import ComputerManagementFunctionFactory.ComputerFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Cartel;
import model.Computers;
import model.Employee;

public class ComputerFindingCashierView {
    private Employee currentUser;
    private Computers currentBook;
    private Cartel currentCartel;

    public ComputerFindingCashierView(Computers currentBook) {
        this.currentBook = currentBook;
    }

    public ComputerFindingCashierView(Employee currentUser) {
        this.currentUser = currentUser;
    }
//    public BookFindingView(Book currentBook) {
//        this.currentBook = currentBook;
//    }


    public ComputerFindingCashierView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);

        Label computerNameLabel = new Label("Computer Name: ");
        computerNameLabel.setTextFill(Color.web("white"));
        computerNameLabel.setStyle("-fx-font-weight: bold;");
        TextField computerNameField = new TextField();
        root1.add(computerNameLabel, 1, 1);
        root1.add(computerNameField, 2, 1);

        Button findComputerButton = new Button("-Find-");
        findComputerButton.setTextFill(Color.web("black"));
        findComputerButton.setStyle("-fx-font-weight: bold;");
        findComputerButton.setId("findComputerButton-button");
        findComputerButton.setStyle("-fx-background-color:#09eab6;");
        HBox h = new HBox();
        h.getChildren().add(findComputerButton);
        root1.add(findComputerButton, 2, 5);

        findComputerButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String computerName = computerNameField.getText();

                ComputerFactory computerFactory = new ComputerFactory();
                Computers findComputer = computerFactory.findComputersByName(computerName);

                if (findComputer == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Computer not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Computer Found");
                    successAlert.setContentText("The Credentials are okay");
                    successAlert.setContentText("Computer ID: " + findComputer.getComputerID() + "\n"
                            + "Name: " + findComputer.getComputerName() + "\n"
                            + "Genere: " + findComputer.getComputerType() + "\n"
                            + "Quantity: " + findComputer.getQuantity() + "\n"
                            + "Price: " + findComputer.getPrice() + "\n"
                            + "ISBN: (ISBN Code Used For Buying)->" + findComputer.getIsbn() + "\n");
                    successAlert.showAndWait();
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Home View");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            CashierHomeView homeView = new CashierHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);


        Label buyComputerLabel = new Label("Buy Computer");
        buyComputerLabel.setStyle("-fx-font-weight: bold;");
        Menu buyComputer = new Menu("", buyComputerLabel);
        buyComputerLabel.setOnMouseClicked(e -> {
            BuyComputerCashierView buyComputerView = new BuyComputerCashierView(currentUser);
            stage.setScene(buyComputerView.execute(stage));
        });

        menuBar.getMenus().add(buyComputer);
        mainPane.setTop(menuBar);

        Label buyComputerCreditLabelView = new Label("Buy With Credit Card");
        buyComputerCreditLabelView.setStyle("-fx-font-weight: bold;");
        Menu buyComputerCredit = new Menu("", buyComputerCreditLabelView);
        buyComputerCreditLabelView.setOnMouseClicked(e -> {
            BuyOnlineComputerCashierView buyComputerView = new BuyOnlineComputerCashierView(currentUser);
            stage.setScene(buyComputerView.execute(stage));
        });

        menuBar.getMenus().add(buyComputerCredit);
        mainPane.setTop(menuBar);

        Label cartelRecordRegistrationViewLabel = new Label("Cartel Record Registration View");
        cartelRecordRegistrationViewLabel.setStyle("-fx-font-weight: bold;");
        Menu registerCartelRecord = new Menu("", cartelRecordRegistrationViewLabel);
        cartelRecordRegistrationViewLabel.setOnMouseClicked(e -> {
            CartelRecordRegistrationCashierView cartelRecordRegistrationView = new CartelRecordRegistrationCashierView(currentCartel);
            stage.setScene(cartelRecordRegistrationView.execute(stage));
        });

        menuBar.getMenus().add(registerCartelRecord);
        mainPane.setTop(menuBar);



        root1.setStyle("-fx-background-image: url('img_4.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 626, 386);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Find Computers");
        stage.show();

        return scene;

    }
}
