package task;

import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import exception.TaskException;
import task.TaskList;


/**
 * This class stores the current loaded tasks list and is the primary way to 
 * modify and interact with that list
 * 
 * @author Hans kurnia
 */
public class TaskList
{
    private ArrayList<Task> myList = new ArrayList<Task>();
    private int NumOfTasks = 0;
    private SimpleDateFormat dateFormatter= new SimpleDateFormat("dd/MM/yyyy HHmm");
    private String output = "";
    
    /**
     * constructor to create a new TaskList object
     * @param list the list of tasks loaded from memory
     */
    public TaskList(ArrayList<Task> list)
    {
        this.myList = list;
        this.NumOfTasks = list.size();
    }

    /**
     * method used to get current loaded list
     * @return current loaded list
     */
    public ArrayList<Task> getList()
    {
        return myList;
    }

    /**
     * method to add a new Todo task to the current list
     * 
     * @param name description of the task
     * @return output to be displayed to user from ui
     * @throws TaskException when description is blank
     */
    public String addTodo(String name) throws TaskException
    {
        if(!name.isBlank())
        {
            myList.add(new Todo(name));
            NumOfTasks++;
            output = "	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list";
        }
        else
        {
            output = "";
            throw new TaskException("	OOPS!!! The description of a todo cannot be empty.");
        }
        return output;
    }

    /**
     * method to add new Event task to the current list
     * 
     * @param name description of the task
     * @param doneAt the timing of the task
     * @return output to be displayed to user from ui
     * @throws TaskException when input is in incorrect format
     * @throws ParseException when datetime format is incorrect
     */
    public String addEvent(String name, String doneAt) throws TaskException, ParseException
    {
        if(!name.isBlank() && !doneAt.isBlank())
        {
            dateFormatter.setLenient(false);
            Date doneAtDate = dateFormatter.parse(doneAt);
            myList.add(new Event(name, doneAtDate));
            NumOfTasks++;
            output = "	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list";
        }
        else
        {
            output = "";
            throw new TaskException("	OOPS!!! The description and/or time of a event cannot be empty.");
        }
        return output;
    }

    /**
     * method to add new Deadline task to the current list
     * 
     * @param name description of the task
     * @param doneBy the deadline of the task
     * @return output to be displayed to user from ui
     * @throws TaskException when input is in incorrect format
     * @throws ParseException when datetime format is incorrect
     */
    public String addDeadline(String name, String doneBy) throws TaskException, ParseException
    {
        if(!name.isBlank() && !doneBy.isBlank())
        {
            dateFormatter.setLenient(false);
            Date doneByDate = dateFormatter.parse(doneBy);
            myList.add(new Deadline(name, doneByDate));
            NumOfTasks++;
            output = "	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list";
        }
        else
        {
            output = "";
            throw new TaskException("	OOPS!!! The description and/or time of a deadline cannot be empty.");
        }
        return output;
    }

    /**
     * this method prints the current loaded list
     * 
     * @return output to be displayed to user from ui
     */
    public String printList()
    {
        output = "        Here are the tasks in your list:\n";
        if(NumOfTasks == 0)
        {
            output += " 	Nothing here mate\n";
        }
        for(int i = 0; i < NumOfTasks; i++)
        {
            int index = i + 1;
            output += " 	" + index + "." + myList.get(i).toString() + "\n";
        }
        return output;
    }

    /**
     * method to mark a given task as done
     * 
     * @param Index task's index in the current list
     * @return output to be displayed to user from ui
     * @throws TaskException when index given is out of range
     */
    public String doneTask(String Index) throws TaskException
    {
        int ListIndex = Integer.parseInt(Index) - 1;
        if(ListIndex >= 0 && ListIndex < NumOfTasks)
        {
            myList.get(ListIndex).markDone();
            output = "	Nice! I have marked this task as done:";
            output += "	" + myList.get(ListIndex).toString();
        }
        else
        {
            output = "";
            throw new TaskException("	Invalid Task number!!!!");
        }
        return output;
    }

    /**
     * method to find tasks' descriptions in the current loaded list that
     * contains a given query
     * 
     * @param query string to find in list
     * @return output to be displayed to user from ui
     */
    public String findTask(String query)
    {
        output = "        Here are the matching tasks in your list:\n";
        int i = 0;
        for (Task  item : myList)
        {
            if(item.getName().contains(query))
            {
                i = myList.indexOf(item) + 1;
                output += "        " + i + "." +  item.toString() + "\n";
            }
        }
        if(i == 0)
        {
            output += "        No tasks matches your query";
        }
        return output;
    }

	/**
     * method to remove a task from the current loaded list
     * 
     * @param Index task's index in the current list
     * @return output to be displayed to user from ui
     * @throws TaskException when index given is out of range
     */
	public String deleteTask(String Index) throws TaskException
	{
		int listIndex = Integer.parseInt(Index) - 1;
		if(listIndex >= 0 && listIndex < NumOfTasks)
		{
			String msg = myList.get(listIndex).toString();
			myList.remove(listIndex);
			output = "	Nice! I have removed this task:";
			output +="	" + msg  + "\n 	Now you have " + --NumOfTasks + " tasks in the list";
		}
		else
		{
            output = "";
			throw new TaskException("	Invalid Task number!!!!");
        }
        return output;
	}
}