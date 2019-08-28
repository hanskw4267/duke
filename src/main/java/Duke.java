import java.text.ParseException;
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
        String lineBreak = "	_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
        System.out.println("Hello!\nI'm Duke\nWhat can i do for you?\n" + lineBreak + "\n");
        String Input = "";
		TaskList myTaskList = new TaskList();
		myTaskList.loadList();
		Scanner in = new Scanner(System.in);
		Input = in.nextLine();
		System.out.println(lineBreak);
        while(!Input.equals("bye"))
        {
			try
			{
				if(Input.equals("list"))
				{
					myTaskList.printList();
				}

				else if(Input.matches("done \\d+"))
				{
					myTaskList.doneTask(Input.replaceFirst("done\\s*", ""));
					myTaskList.saveList();
				}

				else if(Input.matches("deadline(.*)"))
				{
					if(Input.matches("deadline.*/by.*"))
					{
						myTaskList.addDeadline(Input.substring(8, Input.indexOf("/by")), Input.substring(Input.indexOf("/by")+3));
					}
					else
					{
						throw new TaskException("	☹ OOPS!!! Invalid Input. Proper format is (deadline <description> /by <time in dd/MM/yyyy HH/mm>)");
					}
					myTaskList.saveList();
				}

				else if(Input.matches("event(.*)"))
				{
					if(Input.matches("event.*/at.*"))
					{
						myTaskList.addEvent(Input.substring(5, Input.indexOf("/at")), Input.substring(Input.indexOf("/at")+3));
					}
					else
					{
						throw new TaskException("	☹ OOPS!!! Invalid Input. Proper format is (event <description> /at <time in dd/MM/yyyy HH/mm>)");
					}
					myTaskList.saveList();
				}

				else if(Input.matches("todo(.*)"))
				{
					myTaskList.addTodo(Input.substring(4));
					myTaskList.saveList();
				}

				else
				{
					throw new TaskException("	☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
				}
			}
			catch (TaskException e)
			{
				System.out.println(e.getMessage());
			}
			catch (ParseException e)
			{
				System.out.println("Time must be in the correct format of (dd/MM/yyyy HHmm)");
			}
			System.out.println(lineBreak);
			Input = in.nextLine();
			System.out.println(lineBreak);
		}
		myTaskList.saveList();
		System.out.println(lineBreak);
		in.close();
        System.out.println("	Bye. Hope to see you again soon!"+ "\n");
    }
}
