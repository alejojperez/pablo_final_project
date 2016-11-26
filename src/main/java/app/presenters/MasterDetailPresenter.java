package app.presenters;

import app.views.MasterDetailView;
import com.google.inject.Inject;
import core.base.BasePresenter;

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
}
