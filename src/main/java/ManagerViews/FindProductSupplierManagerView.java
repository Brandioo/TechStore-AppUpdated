package ManagerViews;
import AdministratorViews.FindProductSupplier;
import ComputerManagementFunctionFactory.SupplierFactory;
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
import model.Supplier;

public class FindProductSupplierManagerView {
    private Employee currentUser;
    private Computers currentBook;

    public FindProductSupplierManagerView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public FindProductSupplierManagerView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);

        Label supplierNameLabel = new Label("Product Name: ");
        supplierNameLabel.setTextFill(Color.web("black"));
        supplierNameLabel.setStyle("-fx-font-weight: bold;");
        TextField supplierNameField = new TextField();
        root1.add(supplierNameLabel, 1, 1);
        root1.add(supplierNameField, 2, 1);

        Button findEmployeeButton = new Button("-Find-");
        findEmployeeButton.setTextFill(Color.web("black"));
        findEmployeeButton.setStyle("-fx-font-weight: bold;");
        findEmployeeButton.setId("findEmployeeButton-button");
        findEmployeeButton.setStyle("-fx-background-color:#ea0909;");
        HBox h = new HBox();
        h.getChildren().add(findEmployeeButton);
        root1.add(findEmployeeButton, 2, 5);

        findEmployeeButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String supplierName = supplierNameField.getText();

                SupplierFactory supplierFactory=new SupplierFactory();
                Supplier findSupplier=supplierFactory.findProductByName(supplierName);

                if (findSupplier == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Employee not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Product Found");
                    successAlert.setContentText("The Credentials are okay");
                    successAlert.setContentText("ID: " + findSupplier.getSupplierID() + "\n"
                            + "Company Name: " + findSupplier.getSupplierCompanyName() + "\n"
                            + "Product: " + findSupplier.getProduct() + "\n"
                            + "Quantity: " + findSupplier.getQuantity() + "\n"
                            + "Price: " + findSupplier.getPrice() + " $ " + "\n"
                            + "----------------------------------------");
                    successAlert.showAndWait();
                    successAlert.close();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Home View");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            ManagerHomeView homeView = new ManagerHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label registerComputerLabel = new Label("Register Computer");
        Menu registerComputer = new Menu("", registerComputerLabel);
        registerComputerLabel.setOnMouseClicked(e -> {
            ComputerStockRegistrationManagerView computerStockRegistrationManagerView = new ComputerStockRegistrationManagerView();
            stage.setScene(computerStockRegistrationManagerView.execute(stage));
        });

        menuBar.getMenus().add(registerComputer);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('img_14.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 960, 350);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Find What Suppliers Offer");
        stage.show();

        return scene;

    }

}
