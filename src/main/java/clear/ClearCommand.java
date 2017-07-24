package clear;

import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;
import ru.itstep.studyshell.Console.MyJTextPane;

public class ClearCommand implements Command{

    @Override
    public void execute() {
	// TODO Auto-generated method stub
	MyJTextPane my = Console.getMyJTP();
	my.clear(my);
    }

}
