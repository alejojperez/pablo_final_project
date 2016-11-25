package app.presenters;

import app.views.controllers.MainViewController;
import com.google.inject.Inject;
import core.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainViewController>
{
    /**
     * Constructor
     * @param mainViewController
     */
    @Inject
    public MainPresenter(MainViewController mainViewController)
    {
        super(mainViewController);
    }
}
