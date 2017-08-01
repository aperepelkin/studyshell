package ru.itstep.studyshell;

public class ChangeDirectoryCommand implements Command {
	
	private static final String COMMAND = "cd";
	
	private static class Factory extends BaseCommandFactory {

		public Factory() {
			super(COMMAND);
		}

		@Override
		protected Command createCommand(String option) {
			return new ChangeDirectoryCommand(option);
		}
	}
	
	private String directory;
	
	public ChangeDirectoryCommand(String directory) {
		this.directory = directory;
	}

	public void execute() {
		App.getInstance().setCurrentDirectory(directory);
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}
