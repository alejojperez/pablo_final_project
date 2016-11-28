package app.views;

import app.presenters.MasterDetailPresenter;
import core.base.BaseViewController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MasterDetailView extends BaseViewController<MasterDetailPresenter> implements Initializable
{
    //<editor-fold desc="FXML Fields">

    @FXML
    public ListView lvAlphabet;

    //</editor-fold>

    //<editor-fold desc="Initializable">

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if(this.getPresenter() == null) {
            System.out.println("ERROR: The MasterDetailView does not have a presenter.");
            return;
        }

        this.initializeLists();
    }

    protected void initializeLists()
    {
        this.lvAlphabet.setItems(FXCollections.observableList(this.getPresenter().getLettersList()));
    }

    //</editor-fold>

    //<editor-fold desc="BaseViewController">

    @Override
    public double getMinHeight()
    {
        return 622;
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

    //</editor-fold>
}
