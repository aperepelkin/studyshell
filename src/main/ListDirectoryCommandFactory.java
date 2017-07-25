package ru.itstep.studyshell;

public class ListDirectoryCommandFactory implements CommandFactory {

	public Command create(String command) {
		if(command.equals("ls"))
			return new ListDirectoryCommand(
					new ShortFilesOutputStrategy());
		if(command.startsWith("ls")) {
			if (command.split(" ")[1].equals("-l")) 
				return new ListDirectoryCommand(
						new DetailedFilesOutputStrategy());
		}
		return null;
	}

}
