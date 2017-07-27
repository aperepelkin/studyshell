package ru.itstep.studyshell;



public class CDCommandFactory implements CommandFactory {

	private static final String COMMAND = "dir";


	public Command create(String command) {
		// TODO Auto-generated method stub
		
			// cd /home/user/blala
			String[] split = command.split(" ");
			// {"cd", "/home/user/blala"}
			if (split.length > 1 && split[0].equals(COMMAND)) {
				return new CDCommand(split[1]);
			}
			return null;
		}
		
	}

	

	
	


