public class TaskList
{
	Task[] MyList = new Task[100];
	int NumOfTasks = 0;

	public void newTodo(String Name) throws TaskException
	{
		if(!Name.isBlank())
		{
		MyList[NumOfTasks++] = new Todo(Name);
		System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description of a todo cannot be empty.");
		}
	}
	public void newEvent(String Name, String DoneBy) throws TaskException
	{
		if(!Name.isBlank() && !DoneBy.isBlank())
		{
			MyList[NumOfTasks++] = new Event(Name, DoneBy);
			System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description and/or time of a event cannot be empty.");
		}
	}
	public void newDeadline(String Name, String DoneBy) throws TaskException
	{
		if(!Name.isBlank() && !DoneBy.isBlank())
		{
			MyList[NumOfTasks++] = new Deadline(Name, DoneBy);
			System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
		}
		else
		{
			throw new TaskException("	OOPS!!! The description and/or time of a deadline cannot be empty.");
		}
	}
	public void PrintList()
	{
		System.out.println("	Here are the tasks in your list:");
		if(NumOfTasks == 0)
		{
			System.out.println("	Nothing here mate");
		}
		for(int i = 0; i < NumOfTasks; i++)
		{
			int index = i + 1;
			System.out.println("	" + index + "." + MyList[i].toString());
		}
	}

	public void DoneTask(String Index) throws TaskException
	{
		int ListIndex = Integer.parseInt(Index) - 1;
		if(ListIndex >= 0 && ListIndex < NumOfTasks)
		{
			MyList[ListIndex].IsDone = "[" + "\u2713" + "] ";
			System.out.println("	Nice! I have marked this task as done:");
			System.out.println("	" + MyList[ListIndex].toString());
		}
		else
		{
			throw new TaskException("	Invalid Task number!!!!");
		}
	}
}