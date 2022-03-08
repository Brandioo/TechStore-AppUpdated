package ManagerViews;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.CartelFactory;
import ComputerManagementFunctionFactory.CartelRecordFactory;
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

public class ManagerCartelCounts {
    private Employee currentUser;
    private Computers currentBook;

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);

        Label employeeNameLabel = new Label("Name Of Employee: ");
        employeeNameLabel.setTextFill(Color.web("white"));
        employeeNameLabel.setStyle("-fx-font-weight: bold;");
        TextField employeeNameField = new TextField();
        root1.add(employeeNameLabel, 3, 1);
        root1.add(employeeNameField, 4, 1);

        Button searchAllInteractionsButton = new Button("-Search All Interactions With Clients-");
        searchAllInteractionsButton.setTextFill(Color.web("black"));
        searchAllInteractionsButton.setStyle("-fx-font-weight: bold;");
        searchAllInteractionsButton.setId("searchAllInteractionsButton-button");
        searchAllInteractionsButton.setStyle("-fx-background-color:#09eab6;");
        HBox h = new HBox();
        h.getChildren().add(searchAllInteractionsButton);
        root1.add(searchAllInteractionsButton, 4, 6);

        searchAllInteractionsButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String employeeNameFieldText = employeeNameField.getText();

                CartelFactory cartelFactory = new CartelFactory();
                CartelRecordFactory cartelRecordFactory=new CartelRecordFactory();
                Integer findCartels =  cartelFactory.countSells(employeeNameFieldText);
                Integer countSells=cartelRecordFactory.countSellsFinal(employeeNameFieldText);

                if (findCartels == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("No Interaction With Any Client");
                    errorAlert.setContentText("Cartels not available");
                    errorAlert.showAndWait();
                } else {

                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Cartels Found");
                    successAlert.setContentText("Product Sold");
                    successAlert.setContentText("Interactions With Clients: " + findCartels + "\n"+
                            "Products Sold: "+countSells+"\n");
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
            ManagerHomeView hw = new ManagerHomeView(currentUser);
            stage.setScene(hw.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);


        root1.setStyle("-fx-background-image: url('img_10.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 626, 387);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("See All Cartels Done By Employee");
        stage.show();

        return scene;

    }
}
