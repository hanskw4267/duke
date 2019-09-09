/**
 * This is the custom exception used by Duke
 * 
 * @author Hans kurnia
 * @see Exception
 */
class TaskException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TaskException(String Msg)
	{
		super(Msg);
	}
}