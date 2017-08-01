package ru.itstep.studyshell;

public abstract class BaseCommandFactory implements CommandFactory {
	
	private String command;
	
	public BaseCommandFactory(String command) {
		this.command = command;
	}

	public Command create(String command) {
		String[] split = command.split(" ");
		if(split.length > 1 && split[0].equalsIgnoreCase(this.command)) {
			return createCommand(split[1]);
		}
		return null;
	}
	
	protected abstract Command createCommand(String option);

}
