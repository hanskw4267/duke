import java.io.Serializable;
import java.util.Date;

/**
 * This class defines the "Deadline" type task
 * 
 * @author Hans kurnia
 * @see Task
 */
public class Deadline extends Task implements Serializable
{
    private Date doneBy;
    
    /**
     * method to create a new Deadline object
     * 
     * @param name the decription of the deadline task
     * @param doneBy the deadline of the task
     */
	public Deadline(String name, Date doneBy)
	{
		super(name);
		this.doneBy = doneBy;
	}

	@Override
	public String toString()
	{
		return "[D]" + super.toString() + " (by: " + doneBy + ")";
	}
}