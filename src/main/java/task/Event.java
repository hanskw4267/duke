package task;

import java.io.Serializable;
import java.util.Date;

/**
 * This class defines the "Event" type Task
 * 
 * @author Hans kurnia
 * @see Task
 */
public class Event extends Task implements Serializable
{
    private Date DoneAt;
    
    /**
     * method to create a new event object
     * 
     * @param name the description of the event
     * @param doneAt the date of the event
     */
	public Event(String name, Date doneAt)
	{
		super(name);
		this.DoneAt = doneAt;
	}

	@Override
	public String toString()
	{
		return "[E]" + super.toString() + " (at: " + DoneAt + ")";
	}
}