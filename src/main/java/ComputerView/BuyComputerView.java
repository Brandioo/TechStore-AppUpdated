package ComputerView;

import CartelView.CartelRegistrationView;
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
import model.Computers;
import model.Employee;
import AdministratorViews.PaymentTypeAdministrator;

public class BuyComputerView {
    private Employee currentUser;
    private Computers currentBook;

    public BuyComputerView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public BuyComputerView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);

        Label computerISBNLabel = new Label("ISBN Of Computer: ");
        computerISBNLabel.setTextFill(Color.web("white"));
        computerISBNLabel.setStyle("-fx-font-weight: bold;");
        TextField computerISBNField = new TextField();
        root1.add(computerISBNLabel, 3, 1);
        root1.add(computerISBNField, 4, 1);

        Button buyBookButton = new Button("-Buy-");
        buyBookButton.setTextFill(Color.web("black"));
        buyBookButton.setStyle("-fx-font-weight: bold;");
        buyBookButton.setId("buyBookButton-button");
        buyBookButton.setStyle("-fx-background-color:#09eab6;");
        HBox h = new HBox();
        h.getChildren().add(buyBookButton);
        root1.add(buyBookButton, 4, 6);

        buyBookButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String isbn = computerISBNField.getText();

                ComputerFactory computerFactory = new ComputerFactory();
                Computers findComputer = computerFactory.findComputersByIsbn(isbn);


                if (findComputer == null || findComputer.getQuantity() <= 0) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Computer not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Computer Found");
                    successAlert.setContentText("The Credentials are okay");
                    findComputer.setQuantity(findComputer.getQuantity()-1);
                    computerFactory.editComputers(findComputer);
                    stage.setScene(new CartelRegistrationView(findComputer).execute(stage));
                    if (findComputer.getQuantity() <= 5) {
                        successAlert.setContentText("Computer Is Found..." + "\n"
                                + "Time To Buy New Computers ! " + "\n"
                                + "Quantity Left Is Limited: " + findComputer.getQuantity() + "\n"
                                + "You Paid: " + findComputer.getPrice() + " $ ");
                    } else {
                        successAlert.setContentText("Computer Is Found..." + "\n"
                                + "Quantity Left: " + findComputer.getQuantity() + "\n"
                                + "You Paid: " + findComputer.getPrice() + " $ ");
                    }
                    successAlert.showAndWait();
                    successAlert.close();
                }
            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            PaymentTypeAdministrator paymentTypeView = new PaymentTypeAdministrator();
            stage.setScene(paymentTypeView.showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label allComputersView = new Label("All Computers");
        Menu allComputers = new Menu("", allComputersView);
        allComputersView.setOnMouseClicked(e -> {
            AllComputerView allComputerView = new AllComputerView(currentUser);
            stage.setScene(allComputerView.showView(stage));
        });

        menuBar.getMenus().add(allComputers);
        mainPane.setTop(menuBar);


        Label findComputersLabel = new Label("Find Computers");
        Menu findComputer = new Menu("", findComputersLabel);
        findComputersLabel.setOnMouseClicked(e -> {
            ComputerFindingView computerFindingView = new ComputerFindingView(currentUser);
            stage.setScene(computerFindingView.execute(stage));
        });

        menuBar.getMenus().add(findComputer);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('purchase.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 563, 209);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Welcome to GONLINE Vending Machine");
        stage.show();

        return scene;

    }
}
