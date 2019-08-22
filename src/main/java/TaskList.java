public class TaskList
{
	Task[] MyList = new Task[100];
	int NumOfTasks = 0;

	public void NewTask(String Name)
	{
		MyList[NumOfTasks++] = new Task(Name);
	}

	public void PrintList()
	{
		if(NumOfTasks == 0)
		{
			System.out.println("	Nothing here mate");
		}
		for(int i = 0; i < NumOfTasks; i++)
		{
			int index = i + 1;
			System.out.println("	" + index + "." + MyList[i].IsDone + MyList[i].Name);
		}
	}
	//TODO: Replace YES with a unicode tick
	public void DoneTask(String Index)
	{
		int ListIndex = Integer.parseInt(Index) - 1;
		MyList[ListIndex].IsDone = " [" + "YES" + "] ";
		System.out.println("	Nice! I have marked this task as done:");
		System.out.println("	[" + "YES" + "]	" + MyList[ListIndex].Name);
	}
}