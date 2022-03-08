package ManagerViews;

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

public class ComputerFindingManagerView {
    private Employee currentUser;
    private Computers currentComputer;
    private Cartel currentCartel;

    public ComputerFindingManagerView(Computers currentBook) {
        this.currentComputer = currentBook;
    }

    public ComputerFindingManagerView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public ComputerFindingManagerView() {
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
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

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
//        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            ManagerHomeView homeView = new ManagerHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
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
