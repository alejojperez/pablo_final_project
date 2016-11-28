import app.presenters.MasterDetailPresenter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.stage.Stage;
import org.javalite.activejdbc.Base;

public class App extends Application
{
    /**
     * Dependency Injection Injector
     */
    public static Injector DI;

    /**
     * Main application entry point
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    /**
     * FXML Application entry point
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.initializeApplication();

        App.DI.getInstance(MasterDetailPresenter.class).present();
    }

    /**
     * Called before disposing the class
     */
    public void finalize()
    {
        this.closeApplication();
    }

    /**
     * Perform all actions needed before closing the app
     */
    private void closeApplication()
    {
        Base.close();
    }

    /**
     * Perform all actions needed before initializing the app
     */
    private void initializeApplication()
    {
        /**
         * Register the Dependency Injection module
         */
        App.DI = Guice.createInjector(new AppModule());

        /**
         * Open the database connection
         */
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:src/main/java/database/address_book.db", "", "");
    }
}
