public class TaskList
{
	Task[] MyList = new Task[100];
	int NumOfTasks = 0;

	public void newTodo(String Name)
	{
		MyList[NumOfTasks++] = new Todo(Name);
		System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
	}
	public void newEvent(String Name, String DoneBy)
	{
		MyList[NumOfTasks++] = new Event(Name, DoneBy);
		System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
	}
	public void newDeadline(String Name, String DoneBy)
	{
		MyList[NumOfTasks++] = new Deadline(Name, DoneBy);
		System.out.println("	Got it. I've added this task:\n 	" + MyList[NumOfTasks-1].toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
	}
	public void PrintList()
	{
		System.out.println("	Here are the taks in your list:");
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
	//TODO: Replace YES with a unicode tick
	public void DoneTask(String Index)
	{
		int ListIndex = Integer.parseInt(Index) - 1;
		MyList[ListIndex].IsDone = "[" + "YES" + "] ";
		System.out.println("	Nice! I have marked this task as done:");
		System.out.println("	" + MyList[ListIndex].toString());
	}
}