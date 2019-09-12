package storage;

import java.io.*;
import java.util.ArrayList;
import task.Task;

/**
 * This class is used to load and store the current needed tasks list
 * from memory
 * 
 * @author Hans kurnia
 * 
 */
public class Storage
{
    private File listFile = new File("./Tasks_List");
    private ArrayList<Task> myList = new ArrayList<Task>();

    /**
     * this method attempts to load a exiting list from memory, 
     * failing which it creates a new one
     * 
     * @return the loaded list of tasks
     */
    public ArrayList<Task> loadList()
	{
		try
		{
			FileInputStream fIS = new FileInputStream(listFile);
			ObjectInputStream oIS = new ObjectInputStream(fIS);
			this.myList = (ArrayList<Task>) oIS.readObject();
			fIS.close();
            oIS.close();
		}
		catch (FileNotFoundException e)
		{
			this.listFile = new File("./Tasks_List");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
        return myList;
	}

    /**
     * This method attempts to save a given tasks list to memory
     * 
     * @param list the current loaded task list
     * @return the file that list was saved to
     */
    public File saveList(ArrayList<Task> list)
    {
        try
        {
            FileOutputStream fOS = new FileOutputStream(listFile);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(list);
            oOS.close();
            fOS.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return listFile;
    }
}