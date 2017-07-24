package queue;

import ru.itstep.studyshell.Command;

public class QueueWorkingCommand implements Command{
    
    public QueueWorkingCommand() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
	// TODO Auto-generated method stub
	
	System.out.println("Command");
	
	QueueWorking.getInstance();
	QueueWorking.processing();
	
	
    }

}
