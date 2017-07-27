package ru.itstep.studyshell;
public class CDCommand  implements Command{

	String directory ;
	
	public void execute() {
		
		App.getInstance().setDirectory(directory);
	}

	public  CDCommand(String directory) {
		this.directory = directory;
		
	}
}
	
