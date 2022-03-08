package AdministratorViews;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import CartelRecordView.AllCartelRecordView;
import CartelView.AllCartelView;
import CartelView.CartelCounts;
import ClientView.ClientFindingView;
import ComputerManagementFunctionFactory.*;
import ComputerView.AllComputerView;
import ComputerView.ComputerFindingView;
import ComputerView.ComputerStockRegistrationView;
import EmployeesView.AllUsersView;
import EmployeesView.FindEmployeeView;
import model.Employee;

public class AdministratorHomeView {
    private final Employee currentUser;

    public AdministratorHomeView(Employee currentUser) {
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
        Menu countOptions = new Menu("Count-Options");
        countOptions.setStyle("-fx-font-weight: bold;");

        GridPane root1 = new GridPane();
        root1.setAlignment(Pos.CENTER);

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

        MenuItem getAllUser = new MenuItem("-Get All User Info-");
        getAllUser.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                EmployeeFactory employeeFactory = new EmployeeFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Users Information");
                successAlert.setContentText(employeeFactory.findAllEmployees());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllUserTable = new MenuItem("-Get All User Table-");
        getAllUserTable.setStyle("-fx-font-weight: bold;");
        getAllUserTable.setId("findComputer-button");
        getAllUserTable.setStyle("-fx-background-color:#01FFFF;");
        getAllUserTable.setOnAction(event -> {
            AllUsersView av = new AllUsersView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });


        MenuItem getAllClients = new MenuItem("-Get All Client Info-");
        getAllClients.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                ClientFactory clientFactory = new ClientFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Clients Information");
                successAlert.setContentText(clientFactory.findAllClient());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllClientTable = new MenuItem("-Get All Client Table-");
        getAllClientTable.setStyle("-fx-font-weight: bold;");
        getAllClientTable.setId("getAllClientTable-button");
        getAllClientTable.setStyle("-fx-background-color:#01FFFF;");
        getAllClientTable.setOnAction(event -> {
            AllClientView av = new AllClientView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllComputerTable = new MenuItem("-Get All Computers Table-");
        getAllComputerTable.setStyle("-fx-font-weight: bold;");
        getAllComputerTable.setId("getAllComputerTable-button");
        getAllComputerTable.setStyle("-fx-background-color:#01FFFF;");
        getAllComputerTable.setOnAction(event -> {
            AllComputerView av = new AllComputerView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllSuppliersTable = new MenuItem("-Get All Supplier Table-");
        getAllSuppliersTable.setStyle("-fx-font-weight: bold;");
        getAllSuppliersTable.setId("getAllSuppliersTable-button");
        getAllSuppliersTable.setStyle("-fx-background-color:#01FFFF;");
        getAllSuppliersTable.setOnAction(event -> {
            AllSupplierView av = new AllSupplierView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllCartelRecordTable = new MenuItem("-Get All Cartel Record Table-");
        getAllCartelRecordTable.setStyle("-fx-font-weight: bold;");
        getAllCartelRecordTable.setId("getAllCartelRecordTable-button");
        getAllCartelRecordTable.setStyle("-fx-background-color:#01FFFF;");
        getAllCartelRecordTable.setOnAction(event -> {
            AllCartelRecordView av = new AllCartelRecordView(currentUser);
            Scene scene = av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllCartelTable = new MenuItem("-Get All Cartel Table-");
        getAllCartelTable.setStyle("-fx-font-weight: bold;");
        getAllCartelTable.setId("getAllCartelTable-button");
        getAllCartelTable.setStyle("-fx-background-color:#01FFFF;");
        getAllCartelTable.setOnAction(event -> {
            AllCartelView av = new AllCartelView(currentUser);
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


        MenuItem getAllComputers = new MenuItem("-Get All Computers Info-");
//        root.getChildren().add(getAllUser);

        getAllComputers.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ComputerFactory bookFactory = new ComputerFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Computers Information");
                successAlert.setContentText(bookFactory.findAllComputers());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem getAllSuppliers = new MenuItem("-Get All Suppliers Info-");

        getAllSuppliers.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                SupplierFactory bookFactory = new SupplierFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Suppliers Information");
                successAlert.setContentText(bookFactory.findAllSuppliers());
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

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

        userMenu.getItems().addAll(getUser, getAllUser, getAllClients, getAllComputers, getAllSuppliers,
                getAllCartels, getAllUserTable, getAllClientTable, getAllComputerTable, getAllSuppliersTable,
                getAllCartelTable, getAllCartelRecordTable);

        Label logOutLabel = new Label("Log Out");
        Menu logout = new Menu("", logOutLabel);
        logOutLabel.setOnMouseClicked(e -> {
            AdministratorLoginView lv = new AdministratorLoginView();
            stage.setScene(lv.showView(stage));
        });

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);


        Button buyComputer = new Button("-Buy Computer-");
        buyComputer.setStyle("-fx-font-weight: bold;");
        root1.add(buyComputer, 2, 3);

        buyComputer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Buying Computer");
                successAlert.showAndWait();
                stage.setScene(new PaymentTypeAdministrator().showView(stage));
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        MenuItem findComputer = new MenuItem("-Find Computer-");
        findComputer.setStyle("-fx-font-weight: bold;");
        findComputer.setId("findComputer-button");
        findComputer.setStyle("-fx-background-color:#01FFFF;");
        findComputer.setOnAction(e -> {
            stage.setScene(new ComputerFindingView().execute(stage));
        });

        MenuItem findEmployee = new MenuItem("-Find Employee-");
        findEmployee.setStyle("-fx-font-weight: bold;");
        findEmployee.setId("findComputer-button");
        findEmployee.setStyle("-fx-background-color:#01FFFF;");
        findEmployee.setOnAction(e -> {
            stage.setScene(new FindEmployeeView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findComputer, findEmployee);
        mainPane.setTop(menuBar);

        MenuItem findClients = new MenuItem("-Find Clients-");
        findClients.setStyle("-fx-font-weight: bold;");
        findClients.setId("findClients-button");
        findClients.setStyle("-fx-background-color:#01FFFF;");
        findClients.setOnAction(e -> {
            stage.setScene(new ClientFindingView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findClients);
        mainPane.setTop(menuBar);

        MenuItem findSuppliers = new MenuItem("-Find Suppliers-");
        findSuppliers.setStyle("-fx-font-weight: bold;");
        findSuppliers.setId("findSuppliers-button");
        findSuppliers.setStyle("-fx-background-color:#01FFFF;");
        findSuppliers.setOnAction(e -> {
            stage.setScene(new FindSupplierView().execute(stage));
        });

        MenuItem findProductsOfSuppliers = new MenuItem("-Find Product Offered By Suppliers-");
        findProductsOfSuppliers.setStyle("-fx-font-weight: bold;");
        findProductsOfSuppliers.setId("findProductsOfSuppliers-button");
        findProductsOfSuppliers.setStyle("-fx-background-color:#01FFFF;");
        findProductsOfSuppliers.setOnAction(e -> {
            stage.setScene(new FindProductSupplier().execute(stage));
        });

        findBookOrClient.getItems().addAll(findSuppliers, findProductsOfSuppliers);
        mainPane.setTop(menuBar);

        MenuItem countSalaries = new MenuItem("-Get Current Cost-");
        countSalaries.setStyle("-fx-font-weight: bold;");
        countSalaries.setId("countSalaries-button");
        countSalaries.setStyle("-fx-background-color:#01FFFF;");
        countSalaries.setOnAction(e -> {
            EmployeeFactory employeeFactory = new EmployeeFactory();
            SupplierFactory supplierFactory = new SupplierFactory();
            int sum = 0;
            sum = employeeFactory.countSalaries() + supplierFactory.countCost();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sum Of Salaries-" + employeeFactory.countSalaries() + " $ " + "\n" +
                    "Cost Of Products From Suppliers-" + supplierFactory.countCost() + " $ " + "\n" +
                    "All Cost For This Month Is-" + sum + " $ ");
            alert.setHeaderText("The Cost Of Business Information");
            alert.showAndWait();

        });

        countOptions.getItems().addAll(countSalaries);
        mainPane.setTop(menuBar);

        MenuItem findCartelsByEmployees = new MenuItem("-Count Sells By One Employee-");
        findCartelsByEmployees.setStyle("-fx-font-weight: bold;");
        findCartelsByEmployees.setId("findCartelsByEmployees-button");
        findCartelsByEmployees.setStyle("-fx-background-color:#01FFFF;");
        findCartelsByEmployees.setOnAction(e -> {
            stage.setScene(new CartelCounts().execute(stage));
        });

        countOptions.getItems().addAll(findCartelsByEmployees);
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
            stage.setScene(new ClientSignUpView().execute(stage));
        });

        MenuItem createComputerButton = new MenuItem("-Create Computer Button-");
        createComputerButton.setOnAction(e -> {
            stage.setScene(new ComputerStockRegistrationView().execute(stage));
        });

        MenuItem createSupplierButton = new MenuItem("-Create Supplier Button-");
        createSupplierButton.setOnAction(e -> {
            stage.setScene(new RegisterSuppliersAdministratorView().execute(stage));
        });

        createMenu.getItems().addAll(getVerificationStatus, createClientButton, createComputerButton, createSupplierButton);

        menuBar.getMenus().add(createMenu);
        menuBar.getMenus().add(findBookOrClient);
        menuBar.getMenus().add(countOptions);
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


        root1.setStyle("-fx-background-image: url('img_1.png')");
        Scene sc = new Scene(mainPane, 626, 417);
        sc.getStylesheets().add("style.css");
        stage.setTitle("Administrator Home");

        return sc;
    }

}
