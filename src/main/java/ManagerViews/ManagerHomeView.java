package ManagerViews;

import AdministratorViews.FindProductSupplier;
import ClientView.ClientFindingManagerView;
import ComputerManagementFunctionFactory.*;
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

public class ManagerHomeView {
    private Employee currentUser;

    public ManagerHomeView(Employee currentUser) {
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

        MenuItem getAllUserTable = new MenuItem("-Get All User Table-");
        getAllUserTable.setStyle("-fx-font-weight: bold;");
        getAllUserTable.setId("findComputer-button");
        getAllUserTable.setStyle("-fx-background-color:#01FFFF;");
        getAllUserTable.setOnAction(event -> {
            AllUsersManagerView av= new AllUsersManagerView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllClientTable = new MenuItem("-Get All Client Table-");
        getAllClientTable.setStyle("-fx-font-weight: bold;");
        getAllClientTable.setId("getAllClientTable-button");
        getAllClientTable.setStyle("-fx-background-color:#01FFFF;");
        getAllClientTable.setOnAction(event -> {
            AllClientManagerView av= new AllClientManagerView(currentUser);
            Scene scene= av.showView(stage);
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


        MenuItem getAllComputerTable = new MenuItem("-Get All Computers Table-");
        getAllComputerTable.setStyle("-fx-font-weight: bold;");
        getAllComputerTable.setId("getAllComputerTable-button");
        getAllComputerTable.setStyle("-fx-background-color:#01FFFF;");
        getAllComputerTable.setOnAction(event -> {
            AllComputerManagerView av= new AllComputerManagerView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getAllSuppliersTable = new MenuItem("-Get All Supplier Table-");
        getAllSuppliersTable.setStyle("-fx-font-weight: bold;");
        getAllSuppliersTable.setId("getAllSuppliersTable-button");
        getAllSuppliersTable.setStyle("-fx-background-color:#01FFFF;");
        getAllSuppliersTable.setOnAction(event -> {
            AllSupplierManagerView av= new AllSupplierManagerView(currentUser);
            Scene scene= av.showView(stage);
            stage.setScene(scene);
        });

        MenuItem getUser = new MenuItem("-Get Current User Info-");
        getUser.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("ID: "+this.currentUser.getEmployeesId()+"\n"+
                    "Name: "+this.currentUser.getFirstName()+"\n"+
                    "Surname: "+this.currentUser.getLastName()+"\n"+
                    "Role: "+this.currentUser.getRole()+"\n"+
                    "Email: "+this.currentUser.getEmail()+"\n"+
                    "Date Of Birth: "+this.currentUser.getDateOfBirth()+"\n"+
                    "Phone Number: "+this.currentUser.getPhoneNumber()+"\n"+
                    "User: "+this.currentUser.getUser()+"\n");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        userMenu.getItems().addAll(getUser, getAllUserTable, getAllClientTable,
                getAllComputerTable, getAllSuppliersTable, getAllCartels);

        Label logOutLabel=new Label("Log Out");
        Menu logout=new Menu("", logOutLabel);
        logOutLabel.setOnMouseClicked(e->{
            ManagerLoginView lv= new ManagerLoginView();
            stage.setScene(lv.showView(stage));
        });

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);

        MenuItem findComputer = new MenuItem("-Find Computer-");
        findComputer.setStyle("-fx-font-weight: bold;");
        findComputer.setId("findComputer-button");
        findComputer.setStyle("-fx-background-color:#01FFFF;");
        findComputer.setOnAction(e->{
            stage.setScene(new ComputerFindingManagerView().execute(stage));
        });

        MenuItem findEmployee = new MenuItem("-Find Employee-");
        findEmployee.setStyle("-fx-font-weight: bold;");
        findEmployee.setId("findComputer-button");
        findEmployee.setStyle("-fx-background-color:#01FFFF;");
        findEmployee.setOnAction(e->{
            stage.setScene(new FindEmployeeManagerView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findComputer, findEmployee);
        mainPane.setTop(menuBar);

        MenuItem findClients = new MenuItem("-Find Clients-");
        findClients.setStyle("-fx-font-weight: bold;");
        findClients.setId("findClients-button");
        findClients.setStyle("-fx-background-color:#01FFFF;");
        findClients.setOnAction(e->{
            stage.setScene(new ClientFindingManagerView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findClients);
        mainPane.setTop(menuBar);

        MenuItem findSuppliers = new MenuItem("-Find Suppliers-");
        findSuppliers.setStyle("-fx-font-weight: bold;");
        findSuppliers.setId("findSuppliers-button");
        findSuppliers.setStyle("-fx-background-color:#01FFFF;");
        findSuppliers.setOnAction(e -> {
            stage.setScene(new FindSupplierManagerView().execute(stage));
        });

        MenuItem findProductsOfSuppliers = new MenuItem("-Find Product Offered By Suppliers-");
        findProductsOfSuppliers.setStyle("-fx-font-weight: bold;");
        findProductsOfSuppliers.setId("findProductsOfSuppliers-button");
        findProductsOfSuppliers.setStyle("-fx-background-color:#01FFFF;");
        findProductsOfSuppliers.setOnAction(e -> {
            stage.setScene(new FindProductSupplierManagerView().execute(stage));
        });

        findBookOrClient.getItems().addAll(findSuppliers, findProductsOfSuppliers);
        mainPane.setTop(menuBar);

        MenuItem getVerificationStatus = new MenuItem("-Verification Status-");
        getVerificationStatus.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your Account Is Verified*");
            alert.setHeaderText("The user Information");
            alert.showAndWait();

        });

        MenuItem createSupplierButton = new MenuItem("-Create Supplier Button-");
        createSupplierButton.setOnAction(e -> {
            stage.setScene(new RegisterSuppliersManagerView().execute(stage));
        });

        MenuItem createComputerButton = new MenuItem("-Create Computer Button-");
        createComputerButton.setOnAction(e->{
            stage.setScene(new ComputerStockRegistrationManagerView().execute(stage));
        });

        MenuItem findCartelsByEmployees = new MenuItem("-Count Sells By One Employee-");
        findCartelsByEmployees.setStyle("-fx-font-weight: bold;");
        findCartelsByEmployees.setId("findCartelsByEmployees-button");
        findCartelsByEmployees.setStyle("-fx-background-color:#01FFFF;");
        findCartelsByEmployees.setOnAction(e->{
            stage.setScene(new ManagerCartelCounts().execute(stage));
        });

        countOptions.getItems().addAll(findCartelsByEmployees);
        mainPane.setTop(menuBar);

        createMenu.getItems().addAll(getVerificationStatus, createSupplierButton, createComputerButton);

        menuBar.getMenus().add(createMenu);
        menuBar.getMenus().add(findBookOrClient);
        menuBar.getMenus().add(countOptions);
        menuBar.getMenus().add(logout);
        mainPane.setTop(menuBar);

        mainPane.setCenter(root1);

        HBox hBox=new HBox();

        // create a background fill
        BackgroundFill background_fill = new BackgroundFill(Color.ROSYBROWN,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        // set background
        root1.setBackground(background);



        root1.setStyle("-fx-background-image: url('img_5.png')");
        Scene sc = new Scene(mainPane, 650, 978);
        sc.getStylesheets().add("style.css");
        stage.setTitle("Manager Home");

        return sc;
    }
}
