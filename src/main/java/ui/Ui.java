package ui;

import java.util.Scanner;
import java.io.File;
import storage.Storage;
import task.TaskList;

/**
 * This class displays the prompts and outputs needed to the user
 * 
 * @author Hans kurnia
 */
public class Ui
{
    private String logo = "          ____        _        \n"
    + "         |  _ \\ _   _| | _____ \n"
    + "         | | | | | | | |/ / _ \\\n"
    + "         | |_| | |_| |   <  __/\n"
    + "         |____/ \\__,_|_|\\_\\___|\n\n";
    private String lineBreak = "	_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
    private String Input = "";
    private Scanner  in  = new Scanner(System.in);;

    /**
     * method to display the welcome message to the user
     */
    public void showWelcome()
    {
        System.out.println(logo + "         Hello!\n         I'm Duke\n         What can i do for you?\n" + lineBreak + "\n");
    }

    /**
     * method to show the goodbye message to the user and saves the lists
     * 
     * @param storage configuration of storage
     * @param myTaskList holding the current tasks list
     */
    public void showGoodbye(Storage storage, TaskList myTaskList)
    {
        
        File listFile = storage.saveList(myTaskList.getList());
        System.out.println("\n 	Saved to file " + listFile.getName() + "\n");
        System.out.println("	Bye. Hope to see you again soon!"+ "\n");
    }

    /**
     * method to show the output from the different methods to the user
     * 
     * @param output message output to be printed out
     */
    public void showOutput(String output)
    {
        System.out.println(lineBreak);
        System.out.println(output);
        System.out.println(lineBreak);
    }

    /**
     * method to read the next command input from user
     * 
     * @return command input from user
     */
    public String readInput()
    {
        Input = in.nextLine();
        return Input;
    }

}