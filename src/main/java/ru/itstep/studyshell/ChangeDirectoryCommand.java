package ru.itstep.studyshell;

public class ChangeDirectoryCommand implements Command {
	
	private static final String COMMAND = "cd";
	
	private static class Factory implements CommandFactory {

		public Command create(String command) {
			String[] split = command.split(" ");
			if(split.length > 1 && split[0].equalsIgnoreCase(COMMAND)) {
				return new ChangeDirectoryCommand(split[1]);
			}
			return null;
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
