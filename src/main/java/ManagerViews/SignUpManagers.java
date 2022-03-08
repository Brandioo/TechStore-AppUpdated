package ManagerViews;

import AdministratorViews.AdministratorLoginView;
import ComputerManagementFunctionFactory.EmployeeFactory;
import ManagerViews.ManagerLoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class SignUpManagers {
    private Employee currentUser;
    private Computers currentBook;

    public SignUpManagers(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public SignUpManagers() {
    }

    private static boolean isValidOrNot(String password) {
        return password.length() >= 8 && password.matches(".*\\d.*\\d.*");
        //&& password.matches("^[a-zA-Z0-9]$");
    }

    public Scene execute(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Label firstNameLabel = new Label("First Name: ");
        firstNameLabel.setTextFill(Color.BLACK);
        firstNameLabel.setStyle("-fx-font-weight: bold;");
        TextField firstNameField = new TextField();
        root.add(firstNameLabel, 1, 2);
        root.add(firstNameField, 2, 2);

        Label lastNameLabel = new Label("Last Name: ");
        lastNameLabel.setTextFill(Color.BLACK);
        lastNameLabel.setStyle("-fx-font-weight: bold;");
        TextField lastNameField = new TextField();
        root.add(lastNameLabel, 1, 3);
        root.add(lastNameField, 2, 3);

        Label dateOfBirthLabel = new Label("DateOfBirth: ");
        dateOfBirthLabel.setTextFill(Color.BLACK);
        dateOfBirthLabel.setStyle("-fx-font-weight: bold;");
        DatePicker dateOfBirthField = new DatePicker();
        root.add(dateOfBirthLabel, 1, 4);
        root.add(dateOfBirthField, 2, 4);

        Label emailLabel = new Label("Email:");
        emailLabel.setTextFill(Color.BLACK);
        emailLabel.setStyle("-fx-font-weight: bold;");
        TextField emailField = new TextField();
        root.add(emailLabel, 1, 5);
        root.add(emailField, 2, 5);

        Label phoneNumberLabel = new Label("PhoneNumber:");
        phoneNumberLabel.setTextFill(Color.BLACK);
        phoneNumberLabel.setStyle("-fx-font-weight: bold;");
        TextField phoneNumberField = new TextField();
        root.add(phoneNumberLabel, 1, 6);
        root.add(phoneNumberField, 2, 6);

        Label professionLabel = new Label("Role: ");
        professionLabel.setTextFill(Color.BLACK);
        professionLabel.setStyle("-fx-font-weight: bold;");
        root.add(professionLabel, 1, 7);
        ComboBox professionDropDown = new ComboBox();
        professionDropDown.getItems().add("Manager");
        root.add(professionDropDown, 2, 7);

        Label userLabel = new Label("User:");
        userLabel.setTextFill(Color.BLACK);
        userLabel.setStyle("-fx-font-weight: bold;");
        TextField userField = new TextField();
        root.add(userLabel, 1, 8);
        root.add(userField, 2, 8);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.BLACK);
        passwordLabel.setStyle("-fx-font-weight: bold;");
        PasswordField passwordField = new PasswordField();
        root.add(passwordLabel, 1, 9);
        root.add(passwordField, 2, 9);

        Label verifiedPasswordLabel = new Label("Verify Password:");
        verifiedPasswordLabel.setTextFill(Color.BLACK);
        verifiedPasswordLabel.setStyle("-fx-font-weight: bold;");
        PasswordField verifiedPasswordField = new PasswordField();
        root.add(verifiedPasswordLabel, 1, 10);
        root.add(verifiedPasswordField, 2, 10);

        Spinner<Integer> spinner1 = new Spinner<>(1, 1000, 1);

        Label salaryLabel = new Label("Salary: ");
        salaryLabel.setTextFill(Color.BLACK);
        salaryLabel.setStyle("-fx-font-weight: bold;");
        root.add(salaryLabel, 1, 11);
        root.add(spinner1, 2, 11);

        Label descriptionLabel = new Label("Description: ");
        descriptionLabel.setTextFill(Color.BLACK);
        descriptionLabel.setStyle("-fx-font-weight: bold;");
        root.add(descriptionLabel, 1, 12);
        TextArea descriptionArea = new TextArea();
        root.add(descriptionArea, 2, 12);

        Button signupButton = new Button("Sign up");
        signupButton.setStyle("-fx-font-weight: bold;");
        root.add(signupButton, 2, 15);

        signupButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                LocalDate dateOfBirth = dateOfBirthField.getValue();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String role = (String) professionDropDown.getValue();
                String user = userField.getText();
                Integer salary = spinner1.getValue();
                String password = passwordField.getText();
                String verfiedPassword = verifiedPasswordField.getText();
                LocalDateTime createdOn = LocalDateTime.now();
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();

                EmployeeFactory employeeFactory = new EmployeeFactory();
                boolean isRegistered = employeeFactory.signUp(firstName, lastName, dateOfBirth, email, phoneNumber,
                        role, user, password, verfiedPassword, salary, createdOn);
                if (isRegistered) {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("The user was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new ManagerLoginView().showView(stage));
                    successAlert.close();
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("You have not inputted all the requirements correctly. " + "\n" + "OR" + "\n" +
                            "Your password doesnt match with verified password." + "\n" + "OR" + "\n" +
                            "Password length should be bigger than 8!");
                    errorAlert.showAndWait();
                }

            }

        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Log-In Page");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);

        backLabel.setOnMouseClicked(e -> {
            stage.setScene(new ManagerLoginView().showView(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        root.setStyle("-fx-background-image: url('img.png')");
        mainPane.setCenter(root);

        Scene scene = new Scene(mainPane, 1400, 1400);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Sign up Managers!");
        stage.show();

        return scene;
    }
}
