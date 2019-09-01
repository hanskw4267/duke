import java.io.*;
import java.util.ArrayList;

public class Storage
{
    File listFile = new File("./Tasks_List");
    ArrayList<Task> myList = new ArrayList<Task>();
    public ArrayList<Task> loadList()
	{
		try
		{
			FileInputStream fIS = new FileInputStream(listFile);
			ObjectInputStream oIS = new ObjectInputStream(fIS);
			this.myList = (ArrayList<Task>) oIS.readObject();
			fIS.close();
            oIS.close();
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
        return myList;
	}

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