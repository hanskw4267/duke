
public class Duke
{   
    Storage storage;
    TaskList myTaskList;
    CommandParser cmdParser;
    Ui ui;
    
    public Duke()
    {
        storage = new Storage();
        myTaskList = new TaskList(storage.loadList());
        cmdParser = new CommandParser();
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
            cmd = cmdParser.parseCommand(Input);
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
