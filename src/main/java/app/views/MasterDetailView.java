package app.views;

import app.presenters.MasterDetailPresenter;
import com.google.inject.Inject;
import core.base.BaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MasterDetailView extends BaseViewController
{
    /**
     * Constructor
     * @param masterDetailPresenter
     */
    @Inject
    public MasterDetailView(MasterDetailPresenter masterDetailPresenter)
    {
        super(masterDetailPresenter);
    }

    @Override
    public double getMinHeight()
    {
        return 600;
    }

    @Override
    public double getMinWidth()
    {
        return 800;
    }

    @Override
    public String getTitle()
    {
        return "Address Book";
    }
}
