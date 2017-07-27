package ru.itstep.studyshell;

public class ChangeDirectoryCommand implements Command {
	
	private static final String COMMAND = "cd";
	
	private static class Factory implements CommandFactory {

		public Command create(String command) {
			// cd /home/user/blala
			String[] split = command.split(" ");
			// {"cd", "/home/user/blala"}
			if(split.length > 1 && split[0].equals(COMMAND)) {
				return new ChangeDirectoryCommand(split[1]);
			}
			return null;
		}
	}
	
	private String directory;
	
	private ChangeDirectoryCommand(String directory) {
		this.directory = directory;
	}

	public void execute() {
		App.getInstance().setCurrentDirectory(directory);
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}
