import java.io.Serializable;
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