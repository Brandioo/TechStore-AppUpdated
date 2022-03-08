package views;

import AdministratorViews.AdministratorLoginView;
import CashierView.CashierLoginView;
import ManagerViews.ManagerLoginView;
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

public class SecondView {
    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER_RIGHT);

        Button administratorButton = new Button("Administrator Entrance");
        administratorButton.setTextFill(Color.BLACK);
        //loginButton.setStyle("-fx-font-weight: bold;");
        administratorButton.setId("administratorButton-button");
        administratorButton.setStyle("-fx-background-color:#fcfcfc;");
        HBox h = new HBox();
        h.getChildren().add(administratorButton);
        root.add(administratorButton, 5, 1);

        administratorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Administrator Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new AdministratorLoginView().showView(stage));
                successAlert.close();

            }
        });

        Button managerButton = new Button("  Manager Entrance  ");
        managerButton.setTextFill(Color.BLACK);
        //loginButton.setStyle("-fx-font-weight: bold;");
        managerButton.setId("managerButton-button");
        managerButton.setStyle("-fx-background-color:#fcfcfc;");
        HBox h1 = new HBox();
        h1.getChildren().add(managerButton);
        root.add(managerButton, 5, 2);

        managerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Manager Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new ManagerLoginView().showView(stage));
                successAlert.close();

            }
        });

        Button cashierButton = new Button("   Cashier Entrance   ");
        cashierButton.setTextFill(Color.BLACK);
        //loginButton.setStyle("-fx-font-weight: bold;");
        cashierButton.setId("cashierButton-button");
        cashierButton.setStyle("-fx-background-color:#fcfcfc;");
        HBox h2 = new HBox();
        h2.getChildren().add(cashierButton);
        root.add(cashierButton, 5, 3);

        cashierButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Operator Section Is Clicked");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new CashierLoginView().showView(stage));
                successAlert.close();

            }
        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            FirstView firstView = new FirstView();
            stage.setScene(firstView.showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('lockSec.png')");
        mainPane.setCenter(root);
        Scene scene = new Scene(mainPane, 994, 658);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Welcome To Tech Store Art");
        return scene;
    }
}
