import javafx.application.Application;
import javafx.stage.Stage;
import util.HibernateUtils;
import views.FirstView;

public class TechStoreApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HibernateUtils.getSessionFactory().openSession();
        FirstView firstView=new FirstView();
        primaryStage.setScene(firstView.showView(primaryStage));
        primaryStage.show();


    }

    public static void main(String[] args) throws Exception {
        HibernateUtils.getSessionFactory();
        launch(args);

    }
}
