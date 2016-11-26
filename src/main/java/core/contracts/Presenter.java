/**
 * Created by Alejandro Perez on 11/25/16
 * github page: https://github.com/alejojperez
 */
package core.contracts;

import core.base.BaseViewController;
import javafx.stage.Stage;

public interface Presenter<T extends BaseViewController>
{
    /**
     * Retrieve the presenter's view controller
     * @return T
     */
    T getViewController();

    /**
     * Set the presenter's view controller
     * @param viewController
     */
    void setViewController(T viewController);

    /**
     * Perform all the required actions to display the view
     */
    void present();

    /**
     * Perform all the required actions to display the view
     * @param stage
     */
    public void present(Stage stage);
}
