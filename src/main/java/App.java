import app.presenters.MainPresenter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import core.base.BasePresenter;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
    public static final Injector DI = Guice.createInjector(new DependencyInjection());

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BasePresenter presenter = App.DI.getInstance(MainPresenter.class);
        presenter.present();
    }
}
