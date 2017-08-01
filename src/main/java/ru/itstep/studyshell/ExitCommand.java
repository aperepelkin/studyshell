package ru.itstep.studyshell;

import java.io.File;


public class ExitCommand implements Command{
	
	
private static final String COMMAND = "exit";
	
	private static class Factory extends BaseCommandFactory {

		public Factory() {
			super(COMMAND);
		}

		@Override
		protected Command createCommand(String option) {
			// TODO Auto-generated method stub
			return new ExitCommand(option);
		}
	}
	
	private String directory;
	
	public ExitCommand(String directory) {
		this.directory = directory;
	}

	public void execute() {
		App.getInstance().exit();
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}