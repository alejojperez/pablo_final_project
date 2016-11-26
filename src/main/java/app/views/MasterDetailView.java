package app.views;

import core.base.BaseViewController;

public class MasterDetailView extends BaseViewController
{
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
