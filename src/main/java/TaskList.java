import java.io.*;
import java.util.ArrayList;
public class TaskList
{
	ArrayList<Task> myList = new ArrayList<Task>();
	int NumOfTasks = 0;
	File listFile = new File("./Tasks_List");

	public void addTodo(String Name) throws TaskException
	{
		if(!Name.isBlank())
		{
			myList.add(new Todo(Name));
			NumOfTasks++;
			System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description of a todo cannot be empty.");
		}
	}
	public void addEvent(String Name, String DoneBy) throws TaskException
	{
		if(!Name.isBlank() && !DoneBy.isBlank())
		{
			myList.add(new Event(Name, DoneBy));
			NumOfTasks++;
			System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description and/or time of a event cannot be empty.");
		}
	}
	public void addDeadline(String Name, String DoneBy) throws TaskException
	{
		if(!Name.isBlank() && !DoneBy.isBlank())
		{
			myList.add(new Deadline(Name, DoneBy));
			NumOfTasks++;
			System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description and/or time of a deadline cannot be empty.");
		}
	}
	public void printList()
	{
		System.out.println("	Here are the tasks in your list:");
		if(NumOfTasks == 0)
		{
			System.out.println("	Nothing here mate");
		}
		for(int i = 0; i < NumOfTasks; i++)
		{
			int index = i + 1;
			System.out.println("	" + index + "." + myList.get(i).toString());
		}
	}

	public void doneTask(String Index) throws TaskException
	{
		int ListIndex = Integer.parseInt(Index) - 1;
		if(ListIndex >= 0 && ListIndex < NumOfTasks)
		{
			myList.get(ListIndex).markDone();
			System.out.println("	Nice! I have marked this task as done:");
			System.out.println("	" + myList.get(ListIndex).toString());
		}
		else
		{
			throw new TaskException("	Invalid Task number!!!!");
		}
	}

	public void loadList()
	{
		try
		{
			FileInputStream fIS = new FileInputStream(listFile);
			ObjectInputStream oIS = new ObjectInputStream(fIS);
			this.myList = (ArrayList<Task>) oIS.readObject();
			fIS.close();
			oIS.close();
			this.NumOfTasks = this.myList.size();
			System.out.println("			File Loaded");
		}
		catch (FileNotFoundException e)
		{
			this.listFile = new File("./Tasks_List");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public void saveList()
	{
		try
		{
            FileOutputStream fOS = new FileOutputStream(listFile);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(myList);
            oOS.close();
			fOS.close();
			System.out.println("\n 			File saved\n");
		}
		catch (IOException e)
		{
            e.printStackTrace();
        }
	}
}