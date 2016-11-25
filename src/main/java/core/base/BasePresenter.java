package core.base;

import javafx.stage.Stage;

abstract public class BasePresenter<T extends BaseViewController>
{
    /**
     * The presenter's view controller
     */
    private T viewController;

    /**
     * Constructor
     * @param t
     */
    public BasePresenter(T t)
    {
        this.viewController = t;
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
        Stage stage = new Stage();
        this.present(stage);
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
