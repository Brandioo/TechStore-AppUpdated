package CashierView;

import AdministratorViews.AllSupplierView;
import ClientView.ClientFindingViewCashier;
import ComputerView.AllComputerView;
import ComputerView.ComputerFindingView;
import ComputerView.ComputerStockRegistrationView;
import ClientView.ClientFindingView;
import ComputerManagementFunctionFactory.*;
import EmployeesView.AllUsersView;
import EmployeesView.FindEmployeeView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Employee;

public class CashierHomeView {
    private Employee currentUser;

    public CashierHomeView(Employee currentUser) {
        this.currentUser = currentUser;
    }

    public Scene execute(Stage stage) {
        //StackPane root = new StackPane();

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu userMenu = new Menu("User Control");
        userMenu.setStyle("-fx-font-weight: bold;");
        Menu createMenu = new Menu("Registration");
        createMenu.setStyle("-fx-font-weight: bold;");
        Menu findBookOrClient = new Menu("Find-Options");
        findBookOrClient.setStyle("-fx-font-weight: bold;");

        GridPane root1 = new GridPane();
        root1.setAlignment(Pos.CENTER);


        MenuItem getAllClientTable = new MenuItem("-Get All Client Table-");
        getAllClientTable.setStyle("-fx-font-weight: bold;");
        getAllClientTable.setId("getAllClientTable-button");
        getAllClientTable.setStyle("-fx-background-color:#01FFFF;");
        getAllClientTable.setOnAction(event -> {
            AllClientCashierView av = new AllClientCashierView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllCartels = new MenuItem("-Get All Cartel Info-");
        getAllCartels.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelFactory cartelFactory = new CartelFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels Information");
                successAlert.setContentText(cartelFactory.findAllCartels());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllCartelRecord = new MenuItem("-Get All Cartel-Record Info-");
        getAllCartelRecord.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelRecordFactory cartelRecordFactory = new CartelRecordFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels-Record Information");
                successAlert.setContentText(cartelRecordFactory.findAllCartelRecord());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });


        MenuItem getAllComputerTable = new MenuItem("-Get All Computers Table-");
        getAllComputerTable.setStyle("-fx-font-weight: bold;");
        getAllComputerTable.setId("getAllComputerTable-button");
        getAllComputerTable.setStyle("-fx-background-color:#01FFFF;");
        getAllComputerTable.setOnAction(event -> {
            AllComputerCashierView av = new AllComputerCashierView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getUser = new MenuItem("-Get Current User Info-");
        getUser.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("ID: " + this.currentUser.getEmployeesId() + "\n" +
                    "Name: " + this.currentUser.getFirstName() + "\n" +
                    "Surname: " + this.currentUser.getLastName() + "\n" +
                    "Role: " + this.currentUser.getRole() + "\n" +
                    "Email: " + this.currentUser.getEmail() + "\n" +
                    "Date Of Birth: " + this.currentUser.getDateOfBirth() + "\n" +
                    "Phone Number: " + this.currentUser.getPhoneNumber() + "\n" +
                    "User: " + this.currentUser.getUser() + "\n");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        userMenu.getItems().addAll(getAllClientTable,
                getAllComputerTable, getUser);

        Label logOutLabel = new Label("Log Out");
        Menu logout = new Menu("", logOutLabel);
        logOutLabel.setOnMouseClicked(e -> {
            CashierLoginView lv = new CashierLoginView();
            stage.setScene(lv.showView(stage));
        });

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);


        Button buyComputer = new Button("-Buy Computer-");
        buyComputer.setStyle("-fx-font-weight: bold;");
        root1.add(buyComputer, 2, 3);
//        root.getChildren().add(getAllUser);

        buyComputer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Buying Computer");
                successAlert.showAndWait();
                stage.setScene(new PaymentTypeCashier().showView(stage));
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem findComputer = new MenuItem("-Find Computer-");
        findComputer.setStyle("-fx-font-weight: bold;");
        findComputer.setId("findComputer-button");
        findComputer.setStyle("-fx-background-color:#01FFFF;");
        findComputer.setOnAction(e -> {
            stage.setScene(new ComputerFindingCashierView().execute(stage));
        });

        MenuItem findEmployee = new MenuItem("-Find Employee-");
        findEmployee.setStyle("-fx-font-weight: bold;");
        findEmployee.setId("findComputer-button");
        findEmployee.setStyle("-fx-background-color:#01FFFF;");
        findEmployee.setOnAction(e -> {
            stage.setScene(new FindEmployeeCashiersView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findComputer, findEmployee);
        mainPane.setTop(menuBar);

        MenuItem findClients = new MenuItem("-Find Clients-");
        findClients.setStyle("-fx-font-weight: bold;");
        findClients.setId("findClients-button");
        findClients.setStyle("-fx-background-color:#01FFFF;");
        findClients.setOnAction(e -> {
            stage.setScene(new ClientFindingViewCashier().execute(stage));
        });

        findBookOrClient.getItems().addAll(findClients);
        mainPane.setTop(menuBar);


        MenuItem getVerificationStatus = new MenuItem("-Verification Status-");
        getVerificationStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your Account Is Verified*");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        MenuItem createClientButton = new MenuItem("-Create Client Button-");
        createClientButton.setOnAction(e -> {
            stage.setScene(new ClientSignUpCashierView().execute(stage));
        });

        MenuItem createComputerButton = new MenuItem("-Create Computer Button-");
        createComputerButton.setOnAction(e -> {
            stage.setScene(new ComputerStockRegistrationCashierView().execute(stage));
        });

        createMenu.getItems().addAll(getVerificationStatus, createClientButton, createComputerButton);

        menuBar.getMenus().add(createMenu);
        menuBar.getMenus().add(findBookOrClient);
        menuBar.getMenus().add(logout);
        mainPane.setTop(menuBar);

        mainPane.setCenter(root1);

        HBox hBox = new HBox();

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.ROSYBROWN,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        root1.setBackground(background);


        root1.setStyle("-fx-background-image: url('img_6.png')");
        Scene sc = new Scene(mainPane, 650, 974);
        sc.getStylesheets().add("style.css");
        stage.setTitle("Cashier Home");

        return sc;
    }
}
