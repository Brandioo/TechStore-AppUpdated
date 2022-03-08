package AbstractFactory;

import javafx.stage.Stage;
import model.Employee;

import java.util.Optional;

public interface StatusCategory {
    void start(Stage primaryStage) throws Exception;

    Optional<Employee> getAction() throws Exception;

}
