package CashierView;

import AdministratorViews.AdministratorHomeView;
import CashierView.CashierHomeView;
import ComputerManagementFunctionFactory.ClientFactory;
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
import model.Employee;

import java.time.LocalDateTime;

public class ClientSignUpCashierView {
    private Employee currentUser;
    public Scene execute(Stage stage){
        GridPane root1 = new GridPane();
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.CENTER);

        Label firstNameLabel = new Label("First Name: ");
        firstNameLabel.setTextFill(Color.web("black"));
        firstNameLabel.setStyle("-fx-font-weight: bold;");
        TextField firstNameField = new TextField();
        root1.add(firstNameLabel, 1, 2);
        root1.add(firstNameField, 2, 2);

        Label lastNameLabel = new Label("Last Name: ");
        lastNameLabel.setTextFill(Color.web("black"));
        lastNameLabel.setStyle("-fx-font-weight: bold;");
        TextField lastNameField = new TextField();
        root1.add(lastNameLabel, 1, 3);
        root1.add(lastNameField, 2, 3);

        Label emailLabel = new Label("Email: ");
        emailLabel.setTextFill(Color.web("black"));
        emailLabel.setStyle("-fx-font-weight: bold;");
        TextField emailField = new TextField();
        root1.add(emailLabel, 1, 4);
        root1.add(emailField, 2, 4);

        Label phoneNumberLabel = new Label("PhoneNumber: ");
        phoneNumberLabel.setTextFill(Color.web("black"));
        phoneNumberLabel.setStyle("-fx-font-weight: bold;");
        TextField phoneNumberField = new TextField();
        root1.add(phoneNumberLabel, 1, 5);
        root1.add(phoneNumberField, 2, 5);

        Label addressLabel = new Label("Address: ");
        addressLabel.setTextFill(Color.web("black"));
        addressLabel.setStyle("-fx-font-weight: bold;");
        TextField addressField = new TextField();
        root1.add(addressLabel, 1, 6);
        root1.add(addressField, 2, 6);

        Label createdOnLabel = new Label("Created On (Auto Calc. Now): ");
        createdOnLabel.setTextFill(Color.web("black"));
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 7);
        root1.add(createdOnField, 2, 7);

        Button createClientButton = new Button("-Client Creation-");
        createClientButton.setTextFill(Color.web("black"));
        createClientButton.setStyle("-fx-font-weight: bold;");
        root1.add(createClientButton, 2, 18);

        createClientButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String address = addressField.getText();
                LocalDateTime createdOn = LocalDateTime.now();

                ClientFactory clientFactory = new ClientFactory();
                boolean isRegistered = clientFactory.createClientButton(firstName, lastName, email, phoneNumber, address, createdOn);

                if (!isRegistered) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("The password and verify password don't match");
                    errorAlert.showAndWait();
                } else {
                    Employee currentUser=new Employee();
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The user was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new CashierHomeView(currentUser).execute(stage));
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
            CashierHomeView homeView= new CashierHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('img_7.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 1600, 609);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Sign Up Clients");
        stage.show();

        return scene;

    }
}
