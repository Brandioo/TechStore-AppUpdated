package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FirstView {
    public Scene showView(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.BOTTOM_CENTER);

        Button enterButton = new Button(" ENTER To The Tech Store App - Art ");
        enterButton.setTextFill(Color.web("black"));
        enterButton.setStyle("-fx-font-weight: bold;");
        enterButton.setId("enterButton-button");
        enterButton.setStyle("-fx-background-color:#00ffa8;");
        HBox h = new HBox();
        h.getChildren().add(enterButton);
        root.add(enterButton, 0, 0);

        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                successAlert.setHeaderText("Successful Click");
                successAlert.setContentText("Second Stage");
//                    HomeView homeView=new HomeView(loggedIn);
//                    stage.setScene(homeView.execute(stage));
                successAlert.showAndWait();
                stage.setScene(new SecondView().showView(stage));
                successAlert.close();

            }
        });

        root.setStyle("-fx-background-image: url('home.png')");
        Scene scene = new Scene(root, 994, 657);
        scene.getStylesheets().add("style.css");
        stage.setTitle("Welcome To Our Company");
        return scene;
    }
}
