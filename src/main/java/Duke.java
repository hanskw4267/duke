import storage.Storage;
import task.TaskList;
import ui.Ui;
import command.Command;
import command.CommandParser;

/**
 * This is the main class we use to interacting with Duke
 * 
 * @author Hans Kurnia
 */
public class Duke
{   
    private Storage storage;
    private TaskList myTaskList;
    private Ui ui;
    
    public Duke()
    {
        storage = new Storage();
        myTaskList = new TaskList(storage.loadList());
        ui = new Ui();
    }

    public void run()
    {
        String Input = "";
        Command cmd;
        ui.showWelcome();
        Input = ui.readInput();

        while(!Input.equals("bye"))
        {
            cmd = CommandParser.parseCommand(Input);
            cmd.executeCmd(storage, myTaskList, ui);
            Input = ui.readInput();
        }
        ui.showGoodbye(storage, myTaskList);
    }

    public static void main(String[] args)
    {
        new Duke().run();
    }
}
