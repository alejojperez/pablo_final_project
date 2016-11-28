package app.views;

import app.models.Contact;
import app.models.Letter;
import app.presenters.MasterDetailPresenter;
import core.base.BaseViewController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.awt.print.Book;
import java.net.URL;
import java.util.ResourceBundle;

public class MasterDetailView extends BaseViewController<MasterDetailPresenter> implements Initializable
{
    //<editor-fold desc="FXML Components">
    @FXML
    public TextField txtFind;
    @FXML
    public Button btnFind;
    @FXML
    public ListView lvAlphabet;
    @FXML
    public TableView tvContacts;
    @FXML
    public TableColumn<Contact, String> tcContactName;
    @FXML
    public Button btnDelete;

    @FXML
    public TextField txtFirstName;
    @FXML
    public TextField txtMiddleName;
    @FXML
    public TextField txtLastName;
    @FXML
    public TextField txtHomePhone;
    @FXML
    public TextField txtMobilePhone;
    @FXML
    public TextField txtWorkPhone;
    @FXML
    public TextField txtCountry;
    @FXML
    public TextField txtState;
    @FXML
    public TextField txtCity;
    @FXML
    public TextField txtZip;
    @FXML
    public TextField txtAddress;
    @FXML
    public TextField txtPersonalEmail;
    @FXML
    public TextField txtWorkEmail;
    @FXML
    public TextField txtSchoolEmail;
    //</editor-fold>

    //<editor-fold desc="Properties">
    protected FilteredList<Contact> filteredContacts;
    //</editor-fold>

    //<editor-fold desc="Selected Model">
    protected SimpleIntegerProperty selected_id = new SimpleIntegerProperty(0);
    protected SimpleStringProperty selected_first_name = new SimpleStringProperty();
    protected SimpleStringProperty selected_middle_name = new SimpleStringProperty();
    protected SimpleStringProperty selected_last_name = new SimpleStringProperty();
    protected SimpleStringProperty selected_country = new SimpleStringProperty();
    protected SimpleStringProperty selected_state = new SimpleStringProperty();
    protected SimpleStringProperty selected_city = new SimpleStringProperty();
    protected SimpleStringProperty selected_zip = new SimpleStringProperty();
    protected SimpleStringProperty selected_address = new SimpleStringProperty();
    protected SimpleStringProperty selected_home_phone = new SimpleStringProperty();
    protected SimpleStringProperty selected_mobile_phone = new SimpleStringProperty();
    protected SimpleStringProperty selected_work_phone = new SimpleStringProperty();
    protected SimpleStringProperty selected_personal_email = new SimpleStringProperty();
    protected SimpleStringProperty selected_work_email = new SimpleStringProperty();
    protected SimpleStringProperty selected_school_email = new SimpleStringProperty();
    //</editor-fold>

    //<editor-fold desc="Initializable">
    /**
     * Initialize view
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        if(this.getPresenter() == null) {
            System.out.println("ERROR: The MasterDetailView does not have a presenter.");
            return;
        }

        this.initializeLists();
        this.initializeBinders();
    }

    /**
     * Initialize all binders
     */
    protected void initializeBinders()
    {
        this.tvContacts.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == null)
                this.resetSelectedModel();
            else
                this.setSelectedModel((Contact) newValue);
        });

        this.btnFind.disableProperty().bind(this.txtFind.textProperty().isEmpty());
        this.btnDelete.disableProperty().bind(this.selected_id.greaterThan(0).not());

        /**
         * Bind the text fields
         */
        this.txtFirstName.textProperty().bindBidirectional(this.selected_first_name);
        this.txtMiddleName.textProperty().bindBidirectional(this.selected_middle_name);
        this.txtLastName.textProperty().bindBidirectional(this.selected_last_name);
        this.txtCountry.textProperty().bindBidirectional(this.selected_country);
        this.txtState.textProperty().bindBidirectional(this.selected_state);
        this.txtCity.textProperty().bindBidirectional(this.selected_city);
        this.txtZip.textProperty().bindBidirectional(this.selected_zip);
        this.txtAddress.textProperty().bindBidirectional(this.selected_address);
        this.txtHomePhone.textProperty().bindBidirectional(this.selected_home_phone);
        this.txtMobilePhone.textProperty().bindBidirectional(this.selected_mobile_phone);
        this.txtWorkPhone.textProperty().bindBidirectional(this.selected_work_phone);
        this.txtPersonalEmail.textProperty().bindBidirectional(this.selected_personal_email);
        this.txtSchoolEmail.textProperty().bindBidirectional(this.selected_school_email);
        this.txtWorkEmail.textProperty().bindBidirectional(this.selected_work_email);
    }

    /**
     * Initialize all lists
     */
    protected void initializeLists()
    {
        /**
         * Set up the table view with all the contacts
         */
        this.tcContactName.setCellValueFactory(
                (TableColumn.CellDataFeatures<Contact, String> cell) -> new SimpleStringProperty(cell.getValue().fullName())
        );
        ObservableList<Contact> contacts = FXCollections.observableList(this.getPresenter().getContactsList());
        this.filteredContacts = new FilteredList<>(contacts, contact -> true);
        this.tvContacts.setItems(this.filteredContacts);

        /**
         * Set up the list containing all the letters
         */
        this.lvAlphabet.setItems(FXCollections.observableList(this.getPresenter().getLettersList()));
        this.lvAlphabet.setCellFactory(new Callback<ListView<Letter>, ListCell<Letter>>() {

            @Override
            public ListCell<Letter> call(ListView<Letter> param) {
                ListCell<Letter> cell = new ListCell<Letter>() {

                    @Override
                    protected void updateItem(Letter item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item != null) {
                            setText(item.get("letter").toString());
                        }
                    }
                };

                return cell;
            }
        });
        this.lvAlphabet.setOnMouseClicked(event -> {
            Letter letter = (Letter)this.lvAlphabet.getSelectionModel().getSelectedItem();

            if(letter == null || letter.get("letter").toString().equals("ALL"))
                this.filteredContacts.setPredicate(contact -> true);
            else {
                this.txtFind.setText("");
                this.filteredContacts.setPredicate(contact -> contact.get("last_name").toString().toLowerCase().startsWith(letter.get("letter").toString().toLowerCase()));
            }
        });
    }
    //</editor-fold>

    //<editor-fold desc="View Functionalities">
    /**
     * Filter contacts based on search criteria
     * @param event
     */
    public void find(ActionEvent event)
    {
        if(!this.txtFind.getText().isEmpty())
        {
            this.lvAlphabet.getSelectionModel().clearSelection();
            this.filteredContacts.setPredicate(contact -> contact.fullName().toLowerCase().contains(this.txtFind.getText().toLowerCase()));
        }
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

    //<editor-fold desc="Helpers">
    /**
     * Reset the selected model values
     */
    protected void resetSelectedModel()
    {
        this.selected_id.setValue(0);
        this.selected_first_name.setValue("");
        this.selected_middle_name.setValue("");
        this.selected_last_name.setValue("");
        this.selected_country.setValue("");
        this.selected_state.setValue("");
        this.selected_city.setValue("");
        this.selected_zip.setValue("");
        this.selected_address.setValue("");
        this.selected_home_phone.setValue("");
        this.selected_mobile_phone.setValue("");
        this.selected_work_phone.setValue("");
        this.selected_personal_email.setValue("");
        this.selected_work_email.setValue("");
        this.selected_school_email.setValue("");
    }

    /**
     * Set the selected model values
     * @param contact
     */
    protected void setSelectedModel(Contact contact)
    {
        Integer id = (contact.get("id") != null) ? (Integer) contact.get("id") : 0;
        this.selected_id.setValue(id);

        String first_name = contact.get("first_name") != null ? contact.get("first_name").toString() : "";
        this.selected_first_name.setValue(first_name);

        String middleName = contact.get("middle_name") != null ? contact.get("middle_name").toString() : "";
        this.selected_middle_name.setValue(middleName);

        String last_name = contact.get("last_name") != null ? contact.get("last_name").toString() : "";
        this.selected_last_name.setValue(last_name);

        String country = contact.get("country") != null ? contact.get("country").toString() : "";
        this.selected_country.setValue(country);

        String state = contact.get("state") != null ? contact.get("state").toString() : "";
        this.selected_state.setValue(state);

        String city = contact.get("city") != null ? contact.get("city").toString() : "";
        this.selected_city.setValue(city);

        String zip = contact.get("zip") != null ? contact.get("zip").toString() : "";
        this.selected_zip.setValue(zip);

        String address = contact.get("address") != null ? contact.get("address").toString() : "";
        this.selected_address.setValue(address);

        String home_phone = contact.get("home_phone") != null ? contact.get("home_phone").toString() : "";
        this.selected_home_phone.setValue(home_phone);

        String mobile_phone = contact.get("mobile_phone") != null ? contact.get("mobile_phone").toString() : "";
        this.selected_mobile_phone.setValue(mobile_phone);

        String work_phone = contact.get("work_phone") != null ? contact.get("work_phone").toString() : "";
        this.selected_work_phone.setValue(work_phone);

        String personal_email = contact.get("personal_email") != null ? contact.get("personal_email").toString() : "";
        this.selected_personal_email.setValue(personal_email);

        String work_email = contact.get("work_email") != null ? contact.get("work_email").toString() : "";
        this.selected_work_email.setValue(work_email);

        String school_email = contact.get("school_email") != null ? contact.get("school_email").toString() : "";
        this.selected_school_email.setValue(school_email);
    }
    //</editor-fold>
}
