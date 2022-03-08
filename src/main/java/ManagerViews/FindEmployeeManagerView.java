package ManagerViews;

import AdministratorViews.AdministratorHomeView;
import CartelView.CartelRegistrationView;
import ComputerManagementFunctionFactory.EmployeeFactory;
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

public class FindEmployeeManagerView {
    private Employee currentUser;

    public FindEmployeeManagerView() {
    }

    public Scene execute(Stage stage) {

        GridPane root1 = new GridPane();

        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);

        Label employeeNameLabel = new Label("Employee Name: ");
        employeeNameLabel.setTextFill(Color.web("black"));
        employeeNameLabel.setStyle("-fx-font-weight: bold;");
        TextField employeeNameField = new TextField();
        root1.add(employeeNameLabel, 1, 1);
        root1.add(employeeNameField, 2, 1);

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
                String employeeName = employeeNameField.getText();

                EmployeeFactory employeeFactory = new EmployeeFactory();
                Employee findEmployee = employeeFactory.findEmployeeByName(employeeName);

                if (findEmployee == null) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("Employee not available");
                    errorAlert.showAndWait();
                } else {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Employee Found");
                    successAlert.setContentText("The Credentials are okay");
                    successAlert.setContentText("ID: " + findEmployee.getEmployeesId() + "\n"
                            + "Name: " + findEmployee.getFirstName() + "\n"
                            + "Last Name: " + findEmployee.getLastName() + "\n"
                            + "Role: " + findEmployee.getRole() + "\n"
                            + "User: " + findEmployee.getUser() + "\n");
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

        root1.setStyle("-fx-background-image: url('findemp.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 1000, 667);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Find Employee");
        stage.show();

        return scene;

    }
}
