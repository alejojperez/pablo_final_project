package app.presenters;

import app.models.Contact;
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
     * Edit contact
     * @param contact
     * @return
     */
    public Contact editContact(Contact contact)
    {
        contact.saveIt();
        return contact;
    }

    /**
     * Get a list of all contacts
     * @return
     */
    public List<Contact> getContactsList()
    {
        return Contact.findAll();
    }

    /**
     * Get a list of all letters
     * @return List<Letter>
     */
    public List<Letter> getLettersList()
    {
        return Letter.findAll();
    }

    /**
     * Create contact
     * @param contact
     * @return
     */
    public Contact createContact(Contact contact)
    {
        contact.saveIt();
        return contact;
    }
}
