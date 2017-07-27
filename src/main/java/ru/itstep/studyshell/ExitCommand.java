package ru.itstep.studyshell;


public class ExitCommand implements Command{

	public void execute() {

		App.getInstance().exit();
		
	}

}
