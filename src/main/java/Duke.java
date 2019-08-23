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
        do
        {
            Input = in.nextLine();
            System.out.println(LineBreak);
            if(Input.equals("list"))
            {
                MyTaskList.PrintList();
			}
			else if(Input.matches("done \\d+"))
			{
				String[] Tokens = Input.split(" ");
				MyTaskList.DoneTask(Tokens[1]);
			}
			else if(Input.matches("deadline (.*)"))
			{
				String[] Tokens = Input.replaceFirst("deadline ", "").split("/by");
				MyTaskList.newDeadline(Tokens[0], Tokens[1]);
			}
			else if(Input.matches("event (.*)"))
			{
				String[] Tokens = Input.replaceFirst("event ", "").split("/at");
				MyTaskList.newEvent(Tokens[0], Tokens[1]);
			}
            else if(Input.matches("todo (.*)"))
            {
				MyTaskList.newTodo(Input.replaceFirst("todo ", ""));
			}
			System.out.println(LineBreak);
		}while(!Input.equals("bye"));
		in.close();
        System.out.println("	Bye. Hope to see you again soon!"+ "\n");
    }
}
