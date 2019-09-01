import java.io.Serializable;
import java.util.Date;
public class Event extends Task implements Serializable
{
	Date DoneAt;
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