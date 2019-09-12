package command;

import java.text.ParseException;
import storage.Storage;
import task.TaskList;
import exception.TaskException;
import ui.Ui;

/**
 * Command is the class that stores and executes the user command input
 * 
 * @author Hans kurnia
 */
public class Command
{
    private Commandtype type;
    private String cmd;
    
    public Command(Commandtype type, String cmd)
    {
        this.type = type;
        this.cmd = cmd;
    } 

    /**
     * method to execute a given input command
     * 
     * @param storage the configuration for storing task list 
     * @param taskList the task list containing current loaded list
     * @param ui the current user interface
     */
    public void executeCmd(Storage storage, TaskList taskList, Ui ui)
    {
        String output = "";
        try
        {
            switch(type)
            {
                case LISTTASKS :
                    output = taskList.printList();
                    break;
                case FINDTASK :
                    output = taskList.findTask(cmd);
                    break;
                case DELETETASK :
                    output = taskList.deleteTask(cmd);
                    storage.saveList(taskList.getList());
                    break;
                case MARKDONE :
                    output = taskList.doneTask(cmd);
                    storage.saveList(taskList.getList());
                    break;
                case ADDDEADLINE :
                    output = taskList.addDeadline(cmd.substring(8, cmd.indexOf("/by")), cmd.substring(cmd.indexOf("/by")+3));
                    storage.saveList(taskList.getList());
                    break;
                case ADDEVENT :
                    output = taskList.addEvent(cmd.substring(5, cmd.indexOf("/at")), cmd.substring(cmd.indexOf("/at")+3));
                    storage.saveList(taskList.getList());
                    break;
                case ADDTODO :
                    output = taskList.addTodo(cmd);
                    storage.saveList(taskList.getList());
                    break;
                case UNKNOWN :
                    output = "        ☹ OOPS!!! I'm sorry, but I don't know what that means :-(";
            }
            ui.showOutput(output);
        }
        catch(ParseException e)
        {
            System.out.println("        Invalid Date/Time, Please enter valid date in format of dd/MM/yyy HHmm");
        }
        catch(TaskException e)
        {
            System.out.println(e.getMessage());
        }
    }
}