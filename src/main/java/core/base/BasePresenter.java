package core.base;

import core.contracts.Presenter;
import javafx.stage.Stage;

abstract public class BasePresenter<T extends BaseViewController> implements Presenter<T>
{
    /**
     * The presenter's view controller
     */
    protected T viewController;

    /**
     * Constructor
     * @param t
     */
    public BasePresenter(T t)
    {
        this.viewController = t;
        this.viewController.setPresenter(this);
    }

    /**
     * Retrieve the presenter's view controller
     * @return T
     */
    public T getViewController()
    {
        return viewController;
    }

    /**
     * Set the presenter's view controller
     * @param viewController
     */
    public void setViewController(T viewController)
    {
        this.viewController = viewController;
    }

    /**
     * Perform all the required actions to display the view
     */
    public void present()
    {
        this.present(new Stage());
    }

    /**
     * Perform all the required actions to display the view
     * @param stage
     */
    public void present(Stage stage)
    {
        this.viewController.show(stage);
    }
}
