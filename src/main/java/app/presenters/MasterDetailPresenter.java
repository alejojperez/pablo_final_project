package app.presenters;

import app.models.Letter;
import app.views.MasterDetailView;
import com.google.inject.Inject;
import core.base.BasePresenter;

import java.util.List;

public class MasterDetailPresenter extends BasePresenter<MasterDetailView>
{
    /**
     * Constructor
     * @param mainViewController
     */
    @Inject
    public MasterDetailPresenter(MasterDetailView mainViewController)
    {
        super(mainViewController);
    }

    /**
     * Get a list of all letters
     * @return List<Letter>
     */
    public List<Letter> getLettersList()
    {
        return Letter.findAll();
    }
}
