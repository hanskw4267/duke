import java.io.Serializable;
public class Task implements Serializable
{
	String Name;
	String IsDone;

	public Task(String Name)
	{
		this.Name = Name;
		this.IsDone = "[" + "\u2718" + "] ";
	}

	public String toString()
	{
		return IsDone + Name;
	}
	
	public void markDone()
	{
		this.IsDone = "[" + "\u2713" + "] ";
	}
}

class Todo extends Task implements Serializable
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

class Deadline extends Task implements Serializable
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

class Event extends Task implements Serializable
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