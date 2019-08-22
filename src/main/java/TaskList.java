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
		for(int i = 0; i < NumOfTasks; i++)
		{
			int index = i + 1;
			System.out.println("	" + index + ". " +MyList[i].Name);
		}
	}
}