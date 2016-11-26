import com.google.inject.AbstractModule;
import org.javalite.activejdbc.Base;

public class AppModule extends AbstractModule
{
    public AppModule()
    {
        this.initializeDatabaseConnection();
    }

    @Override
    protected void configure()
    {
    }

    private void initializeDatabaseConnection()
    {
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:src/main/java/database/address_book.db", "", "");
    }
}
