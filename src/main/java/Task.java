import java.io.Serializable;
import java.util.Date;
public class Task implements Serializable
{
	String name;
	String isDone;

	public Task(String name)
	{
		this.name = name;
		this.isDone = "[" + "\u2718" + "] ";
	}

	public String toString()
	{
		return isDone + name;
	}
	
	public void markDone()
	{
		this.isDone = "[" + "\u2713" + "] ";
	}
}

class Todo extends Task implements Serializable
{

	public Todo(String name)
	{
		super(name);
	}

	@Override
	public String toString()
	{
		return "[T]" + super.toString();
	}
}

class Deadline extends Task implements Serializable
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

class Event extends Task implements Serializable
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