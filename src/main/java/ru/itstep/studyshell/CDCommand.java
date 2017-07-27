package ru.itstep.studyshell;

import java.io.File;

public class CDCommand  implements Command{

	String directory ;
	
	public void execute() {
		
		App.getInstance().setDirectory(new File (App.getInstance().getDirectory(), directory));
	}

	public  CDCommand(String directory) {
		this.directory = directory;
		
	}
}
	
