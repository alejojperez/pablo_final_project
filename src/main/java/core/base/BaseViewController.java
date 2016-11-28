package core.base;

import app.presenters.MasterDetailPresenter;
import core.contracts.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

abstract public class BaseViewController<T extends BasePresenter> implements View<T>
{
    /**
     * The view's presenter
     */
    protected T presenter;

    /**
     * Constructor
     */
    public BaseViewController() {}

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
     * @return double
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
     * @return double
     */
    public double getMinWidth()
    {
        return 0;
    }

    /**
     * Get the view's presenter
     * @return T
     */
    public T getPresenter()
    {
        return this.presenter;
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
     * Set the view's presenter
     * @param presenter
     */
    public void setPresenter(T presenter)
    {
        this.presenter = presenter;
    }

    /**
     * Display the view
     * @param stage
     */
    public void show(Stage stage)
    {
        String name = this.getClass().getSimpleName()+".fxml";

        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
            loader.setController(this);

            stage.setScene(new Scene(loader.load()));

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
