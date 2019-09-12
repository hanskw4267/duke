package task;

import java.io.Serializable;

/**
 * This class defines the "Event" type Task
 * 
 * @author Hans kurnia
 * @see Task
 */
public class Todo extends Task implements Serializable
{

    /**
     * method to create a new Todo task object
     * 
     * @param name decription of task
     */
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