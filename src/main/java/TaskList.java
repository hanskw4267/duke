import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TaskList
{
    ArrayList<Task> myList = new ArrayList<Task>();
    int NumOfTasks = 0;
    File listFile = new File("./Tasks_List");
    SimpleDateFormat dateFormatter= new SimpleDateFormat("dd/MM/yyyy HHmm");
    String output = "";

    public TaskList(ArrayList<Task> list)
    {
        this.myList = list;
        this.NumOfTasks = list.size();
    }
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

    public String findTask(String query)
    {
        output = "        Here are the matching tasks in your list:\n";
        int i = 0;
        for (Task  item : myList)
        {
            if(item.name.contains(query))
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