package core.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

abstract public class BaseViewController<T extends BasePresenter>
{
    /**
     * The view's presenter
     */
    protected T presenter;

    /**
     * Constructor
     * @param t
     */
    public BaseViewController(T t)
    {
        this.presenter = t;
    }

    /**
     * The min height
     * @return double
     */
    public double getMaxHeight()
    {
        return 0;
    }

    /**
     * The min Width
     * @return
     */
    public double getMaxWidth()
    {
        return 0;
    }

    /**
     * The min height
     * @return double
     */
    public double getMinHeight()
    {
        return 0;
    }

    /**
     * The min Width
     * @return
     */
    public double getMinWidth()
    {
        return 0;
    }

    /**
     * The resizable property
     * @return boolean
     */
    public boolean getResizable()
    {
        return true;
    }

    /**
     * The title of the stage
     * @return String
     */
    public abstract String getTitle();

    /**
     * Display the view
     * @param stage
     */
    public void show(Stage stage)
    {
        String name = this.getClass().getSimpleName()+".fxml";

        try
        {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(name))));

            stage.setResizable(this.getResizable());
            stage.setTitle(this.getTitle());
            if(this.getMaxHeight() > 0) stage.setMaxHeight(this.getMaxHeight());
            if(this.getMaxWidth() > 0) stage.setMaxWidth(this.getMaxWidth());
            if(this.getMinHeight() > 0) stage.setMinHeight(this.getMinHeight());
            if(this.getMinWidth() > 0) stage.setMinWidth(this.getMinWidth());

            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
