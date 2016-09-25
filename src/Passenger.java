/**
 * Created by le on 9/20/16.
 */
public class Passenger
{
    String name;
    String group;

    // group can either belong to some string, or null

    /**
     * Create a passenger that holds a name and a group name
     * @param name
     * @param group
     */
    public Passenger(String name, String group)
    {
        this.name = name;
        this.group = group;
    }

    /**
     * Returns name of passenger
     * @return name f passenger
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns group passenger belong to
     * @return group name
     */
    public String getGroup()
    {
        return group;
    }

}
