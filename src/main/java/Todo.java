import java.io.Serializable;
public class Todo extends Task implements Serializable
{

	public Todo(String name)
	{
		super(name);
	}

	@Override
	public String toString()
	{
		return "[T]" + super.toString();
	}
}