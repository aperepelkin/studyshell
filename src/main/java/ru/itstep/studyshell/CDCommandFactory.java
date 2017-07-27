package ru.itstep.studyshell;



public class CDCommandFactory implements CommandFactory {

	private static final String COMMAND = "dd";

	private static class Factory implements CommandFactory {

		public Command create(String command) {
			// cd /home/user/blala
			String[] split = command.split(" ");
			// {"cd", "/home/user/blala"}
			if (split.length > 1 && split[0].equals(COMMAND)) {
				return new ChangeDirectoryCommand(split[1]);
			}
			return null;
		}
		public static CommandFactory createFactory() {
			return new Factory();
		}
	}

	public Command create(String command) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}


