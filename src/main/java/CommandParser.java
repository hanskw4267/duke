public class CommandParser
{
    public Command parseCommand(String Input)
    {
        Command cmd = new Command(Commandtype.UNKNOWN, Input);
        try
        {
            if(Input.trim().equals("list"))
            {
                cmd = new Command(Commandtype.LISTTASKS, "list");
            }

            else if(Input.trim().matches("done \\d+"))
            {
                cmd = new Command(Commandtype.MARKDONE, Input.replaceFirst("done\\s*", ""));
            }
            
            else if(Input.matches("find(.*)"))
            {
                cmd = new Command(Commandtype.FINDTASK, Input.replaceFirst("find\\s*", ""));
            }

            else if(Input.trim().matches("delete \\d+"))
            {
                cmd = new Command(Commandtype.DELETETASK, Input.replaceFirst("delete\\s*", ""));
            }

            else if(Input.trim().matches("deadline(.*)"))
            {
                if(Input.matches("deadline.*/by.*"))
                {
                    cmd = new Command(Commandtype.ADDDEADLINE, Input);
                }
                else
                {
                    throw new TaskException("	☹ OOPS!!! Invalid Input. Proper format is (deadline <description> /by <time in dd/MM/yyyy HH/mm>)");
                }
            }

            else if(Input.trim().matches("event(.*)"))
            {
                if(Input.matches("event.*/at.*"))
                {
                    cmd = new Command(Commandtype.ADDEVENT, Input);
                }
                else
                {
                    throw new TaskException("	☹ OOPS!!! Invalid Input. Proper format is (event <description> /at <time in dd/MM/yyyy HH/mm>)");
                }
            }

            else if(Input.trim().matches("todo(.*)"))
            {
                cmd = new Command(Commandtype.ADDTODO, Input.substring(4));
            }

            else
            {
                cmd = new Command(Commandtype.UNKNOWN, Input);
            }
        }
        catch (TaskException e)
        {
            System.out.println(e.getMessage());
        }
        return cmd;
    }
}