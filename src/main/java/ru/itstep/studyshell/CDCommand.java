package ru.itstep.studyshell;

public class CDCommand implements Command {

	private String directory;

	CDCommand(String split) {
		this.directory = directory;
	}

	public void execute() {
		App.getInstance().setDirectory(directory);
	}

	
}
