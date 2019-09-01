import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TaskList
{
    ArrayList<Task> myList = new ArrayList<Task>();
    int NumOfTasks = 0;
    File listFile = new File("./Tasks_List");
    SimpleDateFormat dateFormatter= new SimpleDateFormat("dd/MM/yyyy HHmm");

    public void addTodo(String name) throws TaskException
    {
        if(!name.isBlank())
        {
            myList.add(new Todo(name));
            NumOfTasks++;
            System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
        }
        else
        {
            throw new TaskException("	OOPS!!! The description of a todo cannot be empty.");
        }
    }
    public void addEvent(String name, String doneAt) throws TaskException, ParseException
    {
        if(!name.isBlank() && !doneAt.isBlank())
        {
            dateFormatter.setLenient(false);
            Date doneAtDate = dateFormatter.parse(doneAt);
            myList.add(new Event(name, doneAtDate));
            NumOfTasks++;
            System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
        }
        else
        {
            throw new TaskException("	OOPS!!! The description and/or time of a event cannot be empty.");
        }
    }
    public void addDeadline(String name, String doneBy) throws TaskException, ParseException
    {
        if(!name.isBlank() && !doneBy.isBlank())
        {
            dateFormatter.setLenient(false);
            Date doneByDate = dateFormatter.parse(doneBy);
            myList.add(new Deadline(name, doneByDate));
            NumOfTasks++;
            System.out.println("	Got it. I've added this task:\n 	" + myList.get(NumOfTasks-1).toString() + "\n 	Now you have " + NumOfTasks + " tasks in the list");
        }
        else
        {
            throw new TaskException("	OOPS!!! The description and/or time of a deadline cannot be empty.");
        }
    }
    public void printList()
    {
        System.out.println("	Here are the tasks in your list:");
        if(NumOfTasks == 0)
        {
            System.out.println("	Nothing here mate");
        }
        for(int i = 0; i < NumOfTasks; i++)
        {
            int index = i + 1;
            System.out.println("	" + index + "." + myList.get(i).toString());
        }
    }

    public void doneTask(String Index) throws TaskException
    {
        int ListIndex = Integer.parseInt(Index) - 1;
        if(ListIndex >= 0 && ListIndex < NumOfTasks)
        {
            myList.get(ListIndex).markDone();
            System.out.println("	Nice! I have marked this task as done:");
            System.out.println("	" + myList.get(ListIndex).toString());
        }
        else
        {
            throw new TaskException("	Invalid Task number!!!!");
        }
    }

    public void findTask(String query)
    {
        System.out.println("        Here are the matching tasks in your list:\n");
        int i = 0;
        for (Task  item : myList)
        {
            if(item.name.contains(query))
            {
                i = myList.indexOf(item) + 1;
                System.out.println("        " + i + "." +  item.toString());
            }
        }
        if(i == 0)
        {
            System.out.println("        No tasks matches your query");
        }
    }

    public void loadList()
    {
        try
        {
            FileInputStream fIS = new FileInputStream(listFile);
            ObjectInputStream oIS = new ObjectInputStream(fIS);
            this.myList = (ArrayList<Task>) oIS.readObject();
            fIS.close();
            oIS.close();
            this.NumOfTasks = this.myList.size();
            System.out.println("		Tasks List Loaded");
        }
        catch (FileNotFoundException e)
        {
            this.listFile = new File("./Tasks_List");
            System.out.println("		New Tasks List Created");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }

    public void saveList()
    {
        try
        {
            FileOutputStream fOS = new FileOutputStream(listFile);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(myList);
            oOS.close();
            fOS.close();
            // System.out.println("\n 		Saved to file " + listFile.getName() + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}