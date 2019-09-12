import command.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DukeTest
{
    @Test
    public void test_todo()
    {
        Command cmd = new Command(Commandtype.LISTTASK, "list");
        assertEquals(cmd, CommandParser("list"));
    }
}
