import java.util.Scanner;
/*
    String logo = " ____        _        \n"
    + "|  _ \\ _   _| | _____ \n"
    + "| | | | | | | |/ / _ \\\n"
    + "| |_| | |_| |   <  __/\n"
    + "|____/ \\__,_|_|\\_\\___|\n";
    System.out.println("Hello from\n" + logo +"\n");
*/
public class Duke
{
    public static void main(String[] args)
    {
        String LineBreak = "	_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
        System.out.println("Hello!\nI'm Duke\nWhat can i do for you?\n" + LineBreak + "\n");
        String Input = " ";
		TaskList MyTaskList = new TaskList();
		Scanner in = new Scanner(System.in);
        while(!Input.equals("bye"))
        {
			try
			{
				Input = in.nextLine();
				System.out.println(LineBreak);

				if(Input.equals("list"))
				{
					MyTaskList.PrintList();
				}

				else if(Input.matches("done\\d+"))
				{
					MyTaskList.DoneTask(Input.replaceFirst("done\\s*", ""));
				}

				else if(Input.matches("deadline(.*)"))
				{
					if(Input.matches("deadline.*/by.*"))
					{
						MyTaskList.newDeadline(Input.substring(8, Input.indexOf("/by")), Input.substring(Input.indexOf("/by")+3));
					}
					else
					{
						throw new TaskException("☹ OOPS!!! Invalid Input. Proper format is (deadline <description> /by <time>)");
					}
				}

				else if(Input.matches("event(.*)"))
				{
					if(Input.matches("event.*/at.*"))
					{
						MyTaskList.newEvent(Input.substring(5, Input.indexOf("/at")), Input.substring(Input.indexOf("/at")+3));
					}
					else
					{
						throw new TaskException("☹ OOPS!!! Invalid Input. Proper format is (event <description> /at <time>)");
					}
				}

				else if(Input.matches("todo(.*)"))
				{
					MyTaskList.newTodo(Input.replaceFirst("todo\\s*", ""));
				}

				else
				{
					throw new TaskException(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
				}
			}
			catch (TaskException e)
			{
				System.out.println(e.getMessage());
			}
			System.out.println(LineBreak);
		}
		in.close();
        System.out.println("	Bye. Hope to see you again soon!"+ "\n");
    }
}
