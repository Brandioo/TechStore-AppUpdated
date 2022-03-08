package CashierView;

import ComputerView.BuyComputerView;
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
import model.Employee;

public class PaymentTypeCashier {
    private Employee currentUser;
    private Cartel currentCartel;

    public PaymentTypeCashier(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public PaymentTypeCashier() {
    }

    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER_LEFT);



        Button creditCardPaymentButton = new Button("Credit Card Payment");
        creditCardPaymentButton.setTextFill(Color.DEEPSKYBLUE);
        creditCardPaymentButton.setId("creditCardPaymentButton-button");
        creditCardPaymentButton.setStyle("-fx-background-color:#000000;");
        HBox h = new HBox();
        h.getChildren().add(creditCardPaymentButton);
        root.add(creditCardPaymentButton, 2, 1);

        creditCardPaymentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Credit Card Payment Section Is Clicked");
                successAlert.showAndWait();
                BuyOnlineComputerCashierView buyBookView=new BuyOnlineComputerCashierView();
                buyBookView.execute(stage);
                successAlert.close();

            }
        });

        Button cashPaymentButton = new Button("Cash Payment");
        cashPaymentButton.setTextFill(Color.DEEPSKYBLUE);
        cashPaymentButton.setId("cashPaymentButton-button");
        cashPaymentButton.setStyle("-fx-background-color:#000000;");
        HBox h1 = new HBox();
        h1.getChildren().add(cashPaymentButton);
        root.add(cashPaymentButton, 2, 2);

        cashPaymentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Success Click");
                successAlert.setContentText("The Cash Payment Section Is Clicked");
                BuyComputerCashierView buyBookView=new BuyComputerCashierView();
                buyBookView.execute(stage);
                successAlert.showAndWait();
                successAlert.close();

            }
        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);
        backLabel.setOnMouseClicked(e->{
            CashierHomeView homeView= new CashierHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('cash.png')");
        mainPane.setCenter(root);
        Scene scene = new Scene(mainPane, 994, 342);
        // scene.getStylesheets().add("style.css");
        stage.setTitle("Payment");
        return scene;
    }
}
