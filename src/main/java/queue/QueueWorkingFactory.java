package queue;

import interfaces.CommandFactory;
import ru.itstep.studyshell.Command;

public class QueueWorkingFactory implements CommandFactory{


    public Command create(String command) {
	// TODO Auto-generated method stub
	
	System.out.println("Factory");
	
	return new QueueWorkingCommand();
    }

 

}
