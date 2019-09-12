package task;

import java.io.Serializable;

/**
 * This class is the super abstract class to store tasks
 * 
 * @author Hans kurnia
 */
public abstract class Task implements Serializable
{
    /**
     *  The description and status of a given task
     */
	private String name;
	private String isDone;

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
    
    public String getName()
    {
        return name;
    }
}