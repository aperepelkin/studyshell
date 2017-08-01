package ru.itstep.studyshell;

public class EchoCommand implements Command {
	
	private static final String COMMAND = "echo";
	
	private static class Factory extends BaseCommandFactory {

		public Factory() {
			super(COMMAND);
		}

		@Override
		protected Command createCommand(String option) {
			return new EchoCommand(option);
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
