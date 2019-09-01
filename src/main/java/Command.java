import java.text.ParseException;

public class Command
{
    Commandtype type;
    String cmd;
    
    public Command(Commandtype type, String cmd)
    {
        this.type = type;
        this.cmd = cmd;
    } 

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
                    storage.saveList(taskList.myList);
                    break;
                case MARKDONE :
                    output = taskList.doneTask(cmd);
                    storage.saveList(taskList.myList);
                    break;
                case ADDDEADLINE :
                    output = taskList.addDeadline(cmd.substring(8, cmd.indexOf("/by")), cmd.substring(cmd.indexOf("/by")+3));
                    storage.saveList(taskList.myList);
                    break;
                case ADDEVENT :
                    output = taskList.addEvent(cmd.substring(5, cmd.indexOf("/at")), cmd.substring(cmd.indexOf("/at")+3));
                    storage.saveList(taskList.myList);
                    break;
                case ADDTODO :
                    output = taskList.addTodo(cmd);
                    storage.saveList(taskList.myList);
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