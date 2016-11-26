/**
 * Created by Alejandro Perez on 11/26/16
 * github page: https://github.com/alejojperez
 */
package core.contracts;

import core.base.BasePresenter;
import javafx.stage.Stage;

public interface View<T extends BasePresenter>
{
    /**
     * The min height
     * @return double
     */
    double getMaxHeight();

    /**
     * The min Width
     * @return double
     */
    double getMaxWidth();

    /**
     * The min height
     * @return double
     */
    double getMinHeight();

    /**
     * The min Width
     * @return double
     */
    double getMinWidth();

    /**
     * Get the view's presenter
     * @return T
     */
    T getPresenter();

    /**
     * The resizable property
     * @return boolean
     */
    boolean getResizable();

    /**
     * The title of the stage
     * @return String
     */
    String getTitle();

    /**
     * Set the view's presenter
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * Display the view
     * @param stage
     */
    void show(Stage stage);
}
