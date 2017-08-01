package ru.itstep.studyshell;

public class EchoCommand implements Command {
	
	private static final String COMMAND = "echo";
	
	private static class Factory implements CommandFactory {

		public Command create(String command) {
			String[] split = command.split(" ");
			if(split.length > 1 && split[0].equals(COMMAND)) {
				return new EchoCommand(split[1]);
			}
			return null;
		}
	}
	
	private String string;
	
	private EchoCommand(String string) {
		this.string = string;
	}

	public void execute() {
		System.out.println(string);
	}
	
	public static CommandFactory createFactory() {
		return new Factory();
	}
}
