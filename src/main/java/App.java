import app.presenters.MasterDetailPresenter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import core.base.BasePresenter;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    public static final Injector DI = Guice.createInjector(new AppModule());

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        App.DI.getInstance(MasterDetailPresenter.class).present();
    }
}
