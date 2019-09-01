import java.util.Scanner;
import java.io.File;
public class Ui
{
    String logo = "          ____        _        \n"
    + "         |  _ \\ _   _| | _____ \n"
    + "         | | | | | | | |/ / _ \\\n"
    + "         | |_| | |_| |   <  __/\n"
    + "         |____/ \\__,_|_|\\_\\___|\n\n";
    String lineBreak = "	_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
    String Input = "";
    Scanner  in  = new Scanner(System.in);;

    public void showWelcome()
    {
        System.out.println(logo + "         Hello!\n         I'm Duke\n         What can i do for you?\n" + lineBreak + "\n");
    }

    public void showGoodbye(Storage storage, TaskList myTaskList)
    {
        
        File listFile = storage.saveList(myTaskList.myList);
        System.out.println("\n 	Saved to file " + listFile.getName() + "\n");
        System.out.println("	Bye. Hope to see you again soon!"+ "\n");
    }

    public void showOutput(String output)
    {
        System.out.println(lineBreak);
        System.out.println(output);
        System.out.println(lineBreak);
    }

    public String readInput()
    {
        Input = in.nextLine();
        return Input;
    }

}