import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String LineBreak = "____________________________";
        System.out.println("Hello from\n" + logo +"\n");
        System.out.println("Hello!\nI'm Duke\nWhat can i do for you?\n");
        String str;
        do
        {
            Scanner in = new Scanner(System.in);
            str = in.nextLine();
            System.out.println(LineBreak);
            if(!str.equals("bye"))
            System.out.println(str + "\n" + LineBreak);
        }while(!str.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!"+ "\n");
    }
}
