import java.io.Serializable;
import java.util.Date;
public class Deadline extends Task implements Serializable
{
	Date doneBy;
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