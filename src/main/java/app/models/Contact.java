package app.models;

import org.javalite.activejdbc.Model;

public class Contact extends Model
{
    /**
     * Get the contact full name
     * @return String
     */
    public String fullName()
    {
        String response = this.get("last_name").toString()+", "+this.get("first_name").toString();

        if(!this.get("middle_name").toString().isEmpty())
            response += " "+this.get("middle_name").toString();

        return response;
    }
}
