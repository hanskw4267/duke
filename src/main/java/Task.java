public class Task
{
	String Name;
	String IsDone;

	//TODO: Replace NO with a unicode cross
	public Task(String Name)
	{
		this.Name = Name;
		this.IsDone = "[" + "NO" + "] ";
	}

	public String toString()
	{
		return IsDone + Name;
	}
}

class Todo extends Task
{
	public Todo(String Name)
	{
		super(Name);
	}
	@Override
	public String toString()
	{
		return "[T]" + super.toString();
	}
}

class Deadline extends Task
{
	String DoneBy;
	public Deadline(String Name, String DoneBy)
	{
		super(Name);
		this.DoneBy = DoneBy;
	}

	@Override
	public String toString()
	{
		return "[D]" + super.toString() + " (by: " + DoneBy + ")";
	}
}

class Event extends Task
{
	String DoneAt;
	public Event(String Name, String DoneBy)
	{
		super(Name);
		this.DoneAt = DoneBy;
	}

	@Override
	public String toString()
	{
		return "[E]" + super.toString() + " (at: " + DoneAt + ")";
	}
}