package ManagerViews;

import AdministratorViews.AdministratorLoginView;
import ComputerManagementFunctionFactory.EmployeeFactory;
import ComputerManagementFunctionFactory.SupplierFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Computers;
import model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterSuppliersManagerView {
    private Employee currentUser;

    public RegisterSuppliersManagerView() {
    }

    public Scene execute(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);

        Label companyNameLabel = new Label("Company Name");
        companyNameLabel.setTextFill(Color.WHITE);
        companyNameLabel.setStyle("-fx-font-weight: bold;");
        TextField companyNameField = new TextField();
        root.add(companyNameLabel, 1, 1);
        root.add(companyNameField, 2, 1);

        Label productLabel = new Label("Product");
        productLabel.setTextFill(Color.WHITE);
        productLabel.setStyle("-fx-font-weight: bold;");
        TextField productField = new TextField();
        root.add(productLabel, 1, 2);
        root.add(productField, 2, 2);

        Spinner<Integer> spinner1 = new Spinner<>(1, 1000, 1);

        Spinner<Integer> spinner2 = new Spinner<>(1, 1000, 1);

        Label quantityLabel=new Label("Quantity:    ");
        quantityLabel.setTextFill(Color.WHITE);
        quantityLabel.setStyle("-fx-font-weight: bold;");
        root.add(quantityLabel,1,3);
        root.add(spinner1,2,3);

        Label priceLabel=new Label("Price:    ");
        priceLabel.setTextFill(Color.WHITE);
        priceLabel.setStyle("-fx-font-weight: bold;");
        root.add(priceLabel,1,4);
        root.add(spinner2,2,4);


        Label createdOnLabel = new Label("Creation (Auto Calc. Now): ");
        createdOnLabel.setTextFill(Color.WHITE);
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root.add(createdOnLabel, 1, 5);
        root.add(createdOnField, 2, 5);

        Button registerSupplier = new Button("Register Supplier");
        registerSupplier.setStyle("-fx-font-weight: bold;");
        root.add(registerSupplier, 2, 7);

        registerSupplier.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String companyName = companyNameField.getText();
                String product = productField.getText();
                LocalDateTime createdOn = LocalDateTime.now();
                Integer quantity = spinner1.getValue();
                Integer price = spinner2.getValue();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                SupplierFactory supplierFactory = new SupplierFactory();
                boolean isRegistered = supplierFactory.createSupplierSection(companyName, product, quantity, price, createdOn);
                if (!isRegistered) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Supplier Not Registered");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The Supplier was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new ManagerHomeView(currentUser).execute(stage));
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel=new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back=new Menu("", backLabel);

        backLabel.setOnMouseClicked(e->{
            stage.setScene(new ManagerHomeView(currentUser).execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('img_12.png')");
        mainPane.setCenter(root);

        Scene scene = new Scene(mainPane, 960, 480);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Register Suppliers!");
        stage.show();

        return scene;
    }
}
