package CashierView;

import AdministratorViews.AdministratorHomeView;
import ComputerManagementFunctionFactory.*;
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
import model.CartelRecord;
import model.Computers;
import model.Employee;

import java.time.LocalDateTime;

public class CartelRecordRegistrationCashierView {
    private Employee currentUser;
    private Computers currentComputer;
    private Cartel currentCartel;

    public CartelRecordRegistrationCashierView(Cartel currentCartel) {
        this.currentCartel = currentCartel;
    }

    public CartelRecordRegistrationCashierView() {
    }

    public Scene execute(Stage stage) {
        GridPane root1 = new GridPane();
        root1.setHgap(10);
        root1.setVgap(10);
        root1.setPadding(new Insets(10, 10, 10, 10));
        root1.setAlignment(Pos.TOP_CENTER);


        Menu userMenu = new Menu("Cartel Control");
//        userMenu.setStyle("-fx-font-weight: bold;");

//        Label priceLabel = new Label("Price: ");
//        priceLabel.setTextFill(Color.web("white"));
//        priceLabel.setStyle("-fx-font-weight: bold;");
//        root1.add(quantityLabel, 1, 7);
//        root1.add(spinner2,2,7);
//        TextField priceField = new TextField();
//        root1.add(priceField, 2, 8);

        CartelFactory cartelFactory = new CartelFactory();
        ComputerFactory computerFactory = new ComputerFactory();

        Spinner<Integer> spinner1 = new Spinner<>(1, 3000, 2021);

        Spinner<Integer> spinner2 = new Spinner<>(1, 12, 1);

        Spinner<Integer> spinner3 = new Spinner<>(1, 31, 1);

        Spinner<Integer> spinner4 = new Spinner<>(1, 23, 0);

        Spinner<Integer> spinner5 = new Spinner<>(1, 59, 0);

        Spinner<Integer> spinner6 = new Spinner<>(computerFactory.getFirstID(), computerFactory.getLastID(), computerFactory.getFirstID());

        Spinner<Integer> spinner7 = new Spinner<>(cartelFactory.getFirstID(), cartelFactory.getLastID(), cartelFactory.getFirstID());


        Label yearLabel = new Label("Return Year:");
        yearLabel.setTextFill(Color.DEEPSKYBLUE);
        yearLabel.setStyle("-fx-font-weight: bold;");
        root1.add(yearLabel, 1, 1);
        root1.add(spinner1, 2, 1);

        Label returnMonthLabel = new Label("Return Month:");
        returnMonthLabel.setTextFill(Color.DEEPSKYBLUE);
        returnMonthLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnMonthLabel, 1, 2);
        root1.add(spinner2, 2, 2);

        Label returnDayLabel = new Label("Return Day:");
        returnDayLabel.setTextFill(Color.DEEPSKYBLUE);
        returnDayLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnDayLabel, 1, 3);
        root1.add(spinner3, 2, 3);

        Label returnHourLabel = new Label("Hour:");
        returnHourLabel.setTextFill(Color.DEEPSKYBLUE);
        returnHourLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnHourLabel, 1, 4);
        root1.add(spinner4, 2, 4);

        Label returnMinuteLabel = new Label("Minute:");
        returnMinuteLabel.setTextFill(Color.DEEPSKYBLUE);
        returnMinuteLabel.setStyle("-fx-font-weight: bold;");
        root1.add(returnMinuteLabel, 1, 5);
        root1.add(spinner5, 2, 5);

        Label computerIDLabel = new Label("Computer ID: ");
        computerIDLabel.setTextFill(Color.DEEPSKYBLUE);
        computerIDLabel.setStyle("-fx-font-weight: bold;");
        root1.add(computerIDLabel, 1, 6);
        root1.add(spinner6, 2, 6);

        Label clientID = new Label("Cartel ID (ID of Last Cartel): ");
        clientID.setTextFill(Color.DEEPSKYBLUE);
        clientID.setStyle("-fx-font-weight: bold;");
        root1.add(clientID, 1, 7);
        root1.add(spinner7, 2, 7);

        Label createdOnLabel = new Label("Created On (Auto Calc Now): ");
        createdOnLabel.setTextFill(Color.DEEPSKYBLUE);
        createdOnLabel.setStyle("-fx-font-weight: bold;");
        TextField createdOnField = new TextField();
        root1.add(createdOnLabel, 1, 8);
        root1.add(createdOnField, 2, 8);

        Button createCartelRecordButton = new Button("-Cartel Record Registration-");
        createCartelRecordButton.setStyle("-fx-font-weight: bold;"); //letters are written in bold type
        createCartelRecordButton.setTextFill(Color.DEEPSKYBLUE); //Letters of findButton is LIGHTBLUE
        createCartelRecordButton.setId("createCartelRecordButton-button");
        createCartelRecordButton.setStyle("-fx-background-color:#000000;"); //Background is Black
        HBox h1 = new HBox(); //Declare h box
        h1.getChildren().add(createCartelRecordButton); //Adding button inside the hBox
        root1.add(createCartelRecordButton, 2, 9);

        createCartelRecordButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                //String description = descriptionArea.getText();
                // boolean isRememberMe = remember.isSelected();


                CartelRecordFactory cartelRecordFactory = new CartelRecordFactory();
                ClientFactory clientFactory = new ClientFactory();
                EmployeeFactory employeeFactory = new EmployeeFactory();
                CartelRecord cartelRecord = new CartelRecord();
                ComputerFactory computerFactory=new ComputerFactory();
                CartelFactory cartelFactory = new CartelFactory();

                LocalDateTime dataStarted = LocalDateTime.now();
                cartelRecord.setDataStarted(dataStarted);

                Integer returnYear = spinner1.getValue();
                Integer returnMonth = spinner2.getValue();
                Integer returnDay = spinner3.getValue();
                Integer returnHour = spinner4.getValue();
                Integer returnMinute = spinner5.getValue();

                cartelRecord.setEndData(LocalDateTime.of(returnYear, returnMonth, returnDay, returnHour, returnMinute));

                Integer computerID = spinner6.getValue();
                cartelRecord.setComputers(computerFactory.findComputersByID(computerID));

                Integer cartelID = spinner7.getValue();
                cartelRecord.setCartel(cartelFactory.findCartelsByID(cartelID));

//                cartelRecord.setCartel(currentCartel);
//
//                cartelRecord.setBook(currentBook);

                LocalDateTime createdOn = LocalDateTime.now();
                cartelRecord.setCreatedOn(createdOn);

                cartelRecordFactory.createCartelRecord(cartelRecord);
                boolean isRegistered = cartelRecordFactory.createOfCartelRecord(cartelRecordFactory);

                if (isRegistered) {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setHeaderText("Success");
                    successAlert.setContentText("The Cartel Record was registered successfully");
                    successAlert.showAndWait();
                    stage.setScene(new CashierHomeView(currentUser).execute(stage));
                    successAlert.close();
                }  else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("There was an error");
                    errorAlert.setContentText("You have not inputted all the requirements correctly.");
                    errorAlert.showAndWait();
                }
            }


        });

        BorderPane mainPane = new BorderPane();
        MenuBar menuBar = new MenuBar();

        Label backLabel = new Label("Back");
        backLabel.setStyle("-fx-font-weight: bold;");
        Menu back = new Menu("", backLabel);
        backLabel.setOnMouseClicked(e -> {
            CartelRegistrationCashierView cartelRegistrationView = new CartelRegistrationCashierView(currentComputer);
            stage.setScene(cartelRegistrationView.execute(stage));
        });

        menuBar.getMenus().add(back);
        mainPane.setTop(menuBar);

        Label buyComputerViewLabel = new Label("Buy Computer View");
//        buyComputerViewLabel.setStyle("-fx-font-weight: bold;");
        Menu buyComputer = new Menu("", buyComputerViewLabel);
        buyComputerViewLabel.setOnMouseClicked(e -> {
            BuyComputerCashierView buyBookView = new BuyComputerCashierView(currentUser);
            stage.setScene(buyBookView.execute(stage));
        });

        menuBar.getMenus().add(buyComputer);
        mainPane.setTop(menuBar);

        Label homeViewLabel = new Label("Home View");
//        homeViewLabel.setStyle("-fx-font-weight: bold;");
        Menu homeview = new Menu("", homeViewLabel);
        homeViewLabel.setOnMouseClicked(e -> {
            CashierHomeView homeView = new CashierHomeView(currentUser);
            stage.setScene(homeView.execute(stage));
        });

        menuBar.getMenus().add(homeview);
        mainPane.setTop(menuBar);

        Label findComputerIDLabel = new Label("Find Computer ID");
//        findEmployeeViewLabel.setStyle("-fx-font-weight: bold;");
        Menu findComputer = new Menu("", findComputerIDLabel);
        findComputerIDLabel.setOnMouseClicked(e -> {
            ComputerFindingCashierView findBookView = new ComputerFindingCashierView(currentComputer);
            stage.setScene(findBookView.execute(stage));
        });

        menuBar.getMenus().add(findComputer);
        mainPane.setTop(menuBar);

        MenuItem getAllCartels = new MenuItem("-Last Cartel Number-");
        getAllCartels.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                CartelFactory cartelFactory = new CartelFactory();
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("All Cartels Information");
                successAlert.setContentText(String.valueOf(cartelFactory.getLastID()));
                successAlert.showAndWait();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }

        });

        userMenu.getItems().addAll(getAllCartels);
        mainPane.setTop(menuBar);

        menuBar.getMenus().add(userMenu);
        mainPane.setTop(menuBar);

        root1.setStyle("-fx-background-image: url('img17.png')");
        mainPane.setCenter(root1);
        Scene scene = new Scene(mainPane, 960, 350);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Register Cartel Records");
        stage.show();

        return scene;
    }
}
